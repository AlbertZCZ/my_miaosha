### 搭建教程
1. mysql中新建miaosha库
2. miaosha库运行miaosha.sql
3. 部署redis
4. 部署rabbitmq
5. 给MQConfig中添加miaoshatest，miaosha.queue队列
6. 将mysql、redis、rabbitmq的信息填入到src/main/resources/application.properties中
7. 运行com.geekq.miaosha.GeekQMainApplication
8. 访问地址 http://localhost:8080/login/to_login
9. 在mysql miaosha数据库中把miaosha_user中id字段改为自增（默认的id为手机号，密码是123456加1a2b3c混淆）
可以用自己的手机号注册
10. 修改miaosha_good中的start_time和end_time指定时间可进行秒杀

### 模块说明
#### 开启秒杀活动
向redis中存入商品库存信息同时内存中标记。
#### 用户注册
1. `/miaosha/verifyCodeRegister`生成验证码放入redis中后返回前端
2. `/user/register`对用户输入的内容进行校验，验证码和redis中的进行比较，如果正确将redis中的删除；
3. 对密码md5加密后入库；
4. 生成uuid当作token存入redis中，过期时间为3600 *24*2，生成cookie放入response中。
#### 用户登录
1. 根据用户名查询数据库，用户不存在直接返回；
2. 密码进行md5加密并和查出来的用户密码比较，不想等直接返回；
3. 与注册一样，生成token和cookie存入redis中并返回，进入商品列表。
#### 秒杀
1. 请求`/miaosha/path?goodsId=4&verifyCode=-1`接口获取秒杀路径path：
根据用户名和商品id的key去redis中查询验证码，与用户输入的比对，验证成功将redis中验证码删除；
uuid生成秒杀path以用户名和商品id作为key存入redis中，返回path。
2. 请求`/miaosha/{path}/do_miaosha`进行秒杀：
验证path，用户名和商品id为key去查redis进行对比。
验证是否已秒杀到，用户名和商品为key去redis查秒杀信息，如查到说明已经秒杀到返回信息。
内存标记以减少redis访问
预减库存，redis中减少商品数量，如减少后数量小于0说明超卖，内存标记并返回信息。
否则说明秒杀成功，向mq中发送一条消息。
3. 前段轮询`miaosha/result?goodsId=4`接口查询秒杀结果
根据用户和商品id查询订单是否存在，如果存在则秒杀结果成功，如果不存在根据商品id查询redis中isGoodsOver如查询到说明秒杀失败，如未查询到说明消息还未被消费，前端继续轮询。
#### mq消息消费
1. 监听秒杀队列
接受到消息后查询商品信息，如查询不到返回。
根据用户名和商品id查询redis中秒杀信息，判断是否已经秒杀到
2. 减库存 下订单 写入秒杀订单
如果库存不存在则内存标记为true
成功则创建订单，并将秒杀成功的信息存入redis中。
#### 说明
##### 秒杀相关接口限制
* 通过自定义注解@AccessLimit，在拦截器中判断访问次数和是否登录信息
* 拦截器从request中获取cookie中的值即uuid，然后通过此uuid去redis查询user信息，查询到返回user并重新设置addCookie，否则user为null；
* 如果需要登录注解为true，判断user信息是否为null，为null返回错误信息；
* 根据接口url去redis中查询访问次数，与最大访问次数比较，不满足返回失败信息。