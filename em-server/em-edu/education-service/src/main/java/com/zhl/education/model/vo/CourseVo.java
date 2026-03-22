package com.zhl.education.model.vo;

import java.lang.Long;
import java.lang.String;
import lombok.Data;

@Data
public class CourseVo {

	private Long id;

	private String name;

	private Long parentId;

}