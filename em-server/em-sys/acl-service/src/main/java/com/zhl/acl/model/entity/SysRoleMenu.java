package com.zhl.acl.model.entity;

import lombok.Data;
import java.lang.Long;

@Data
public class SysRoleMenu {

	private Long id;

	private Long roleId;

	private Long menuId;

}