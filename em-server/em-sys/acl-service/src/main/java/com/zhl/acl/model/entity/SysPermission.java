package com.zhl.acl.model.entity;

import lombok.Data;
import java.lang.Long;
import java.lang.String;

@Data
public class SysPermission {

	private Long id;

	private String name;

	private String type;

	private Long parentId;

	private String pidPath;

	private String path;

	private String component;

}