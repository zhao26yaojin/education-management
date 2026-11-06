package com.zhl.acl.model.qo;

import lombok.Data;
import java.util.List;
import java.lang.Long;
import java.lang.String;

@Data
public class PermissionRoleQo {

	private Long id;

	private String name;

	private String type;

	private Long roleId;

	private List<Long> idList;

}