package com.zhl.education.model.entity;

import lombok.Data;
import java.lang.Long;
import java.lang.String;

@Data
public class EduCourse {

	private Long id;

	private String name;

	private Long parentId;

}