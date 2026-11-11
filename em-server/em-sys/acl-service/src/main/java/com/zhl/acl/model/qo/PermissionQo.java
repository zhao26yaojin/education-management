package com.zhl.acl.model.qo;

import lombok.Data;
import java.lang.Long;
import java.lang.String;

@Data
public class PermissionQo {

	private Long id;

	private String name;

	private String type;

}