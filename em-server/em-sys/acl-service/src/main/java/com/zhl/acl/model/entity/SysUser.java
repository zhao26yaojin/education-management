package com.zhl.acl.model.entity;

import lombok.Data;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;

@Data
public class SysUser {

	private Long id;

	private String name;

	private String password;

	private String gender;

	private String email;

	private String phone;

	private Integer status;

	private Long deleted;

}