package com.zhl.acl.model.vo;

import lombok.Data;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;

@Data
public class UserLoginVo {

	private Long id;

	private String name;

	private String password;

	private String gender;

	private String email;

	private String phone;

	private Integer status;

	private Long deleted;

	private String userKey;

	private String token;

	private Long loginTime;

}