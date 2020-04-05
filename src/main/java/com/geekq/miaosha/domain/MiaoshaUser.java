package com.geekq.miaosha.domain;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MiaoshaUser {

	private Long id;
	private String nickname;
	private String password;
	private String salt;
	private String head;
	private Date registerDate;
	private Date lastLoginDate;
	private Integer loginCount;
	@Override
	public String toString() {
		return "Logininfo{" +
				"id=" + id +
				", nickname='" + nickname + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", head='" + head + '\'' +
				", registerDate=" + registerDate +
				", lastLoginDate=" + lastLoginDate +
				", loginCount=" + loginCount +
				'}';
	}
}
