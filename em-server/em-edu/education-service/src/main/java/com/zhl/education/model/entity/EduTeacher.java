package com.zhl.education.model.entity;

import lombok.Data;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;

@Data
public class EduTeacher {

	private Long id;

	private String name;

	private Integer level;

	private String avatar;

}