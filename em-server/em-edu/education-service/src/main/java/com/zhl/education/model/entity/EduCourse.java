package com.zhl.education.model.entity;

import java.lang.Long;
import java.lang.String;
import lombok.Data;

@Data
public class EduCourse {

	private Long id;

	private String name;

	private Long parentId;

}