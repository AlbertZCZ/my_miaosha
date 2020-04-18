package com.geekq.miaosha.redis.redismanager;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class RedisLimitRateWithLUA {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(50);
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(20,30,5,TimeUnit.SECONDS,queue);
        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    latch.await();
                    System.out.println("请求是否被执行："+accquire());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        latch.countDown();
    }

    public static boolean accquire() throws IOException, URISyntaxException {
        Jedis jedis = new Jedis("39.107.245.253");

        String lua =
                "local key = KEYS[1] " +
                        " local limit = tonumber(ARGV[1]) " +
                        " local current = tonumber(redis.call('get', key) or '0')" +
                        " if current + 1 > limit " +
                        " then  return 0 " +
                        " else "+
                        " redis.call('INCRBY', key,'1')" +
                        " redis.call('expire', key,'2') " +
                        " end return 1 ";

        // 当前秒
        String key = "ip:" + System.currentTimeMillis()/1000;
        // 最大限制
        String limit = "3";
        List<String> keys = new ArrayList<>();
        keys.add(key);
        List<String> args = new ArrayList<>();
        args.add(limit);
        jedis.auth("youxin11");
        String luaScript = jedis.scriptLoad(lua);
        Long result = (Long)jedis.evalsha(luaScript, keys, args);
        return result == 1;
    }
}
