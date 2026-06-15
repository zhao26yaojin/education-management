package com.zhl.acl.model.vo;

import lombok.Data;
import java.lang.Long;
import java.lang.String;

@Data
public class UserLoginVo {

	private Long id;

	private String name;

	private Long parentId;

}