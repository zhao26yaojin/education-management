package com.zhl.education.model.vo;

import lombok.Data;
import java.lang.Long;
import java.lang.String;

@Data
public class CourseVo {

	private Long id;

	private String name;

	private Long parentId;

}