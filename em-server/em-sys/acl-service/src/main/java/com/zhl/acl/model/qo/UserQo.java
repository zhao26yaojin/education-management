package com.zhl.acl.model.qo;

import java.lang.Long;
import java.lang.String;
import lombok.Data;

@Data
public class UserQo {

	private Long id;

	private String name;

	private Long parentId;

}