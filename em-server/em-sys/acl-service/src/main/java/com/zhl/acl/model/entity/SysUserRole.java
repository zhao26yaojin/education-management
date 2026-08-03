package com.zhl.acl.model.entity;

import lombok.Data;
import java.lang.Long;

@Data
public class SysUserRole {

	private Long id;

	private Long userId;

	private Long roleId;

}