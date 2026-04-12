package com.zhl.acl.model.entity;

import lombok.Data;
import java.lang.Long;
import java.lang.String;

@Data
public class SysUser {

	private Long id;

	private String name;

	private Long parentId;

}