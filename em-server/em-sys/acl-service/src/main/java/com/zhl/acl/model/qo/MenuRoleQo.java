package com.zhl.acl.model.qo;

import lombok.Data;
import java.util.List;
import java.lang.Long;
import java.lang.String;

@Data
public class MenuRoleQo {

	private Long id;

	private String name;

	private Long roleId;

	private List<Long> idList;

}