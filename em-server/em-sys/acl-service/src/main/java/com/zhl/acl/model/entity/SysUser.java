package com.zhl.acl.model.entity;

import java.lang.Long;
import java.lang.String;
import lombok.Data;

@Data
public class SysUser {

	private Long id;

	private String name;

	private Long parentId;

}