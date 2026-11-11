package com.zhl.acl.model.entity;

import lombok.Data;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;

@Data
public class SysRole {

	private Long id;

	private String name;

	private Integer status;

}