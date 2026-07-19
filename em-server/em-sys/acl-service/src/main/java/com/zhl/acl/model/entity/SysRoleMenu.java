package com.zhl.acl.model.entity;

import lombok.Data;
import java.lang.Long;
import java.lang.String;

@Data
public class SysRoleMenu {

	private Long id;

	private Long roleId;

	private String menuIds;

}