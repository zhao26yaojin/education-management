package com.zhl.acl.model.vo;

import java.lang.Long;
import java.lang.String;
import lombok.Data;

@Data
public class UserVo {

	private Long id;

	private String name;

	private Long parentId;

}