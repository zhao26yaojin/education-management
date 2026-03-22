package com.zhl.education.mapper;

import java.lang.Long;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import java.lang.String;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhl.education.model.qo.TeacherQo;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhl.education.model.entity.EduTeacher;

@Mapper
public interface TeacherMapper extends BaseMapper<EduTeacher> {

	default LambdaQueryWrapper<EduTeacher> getQueryWrapper(TeacherQo teacherQo){
		LambdaQueryWrapper<EduTeacher> wrapper = Wrappers.lambdaQuery(EduTeacher.class);
		wrapper.eq(teacherQo.getId() != null, EduTeacher::getId, teacherQo.getId());
		wrapper.eq(StringUtils.isNotEmpty(teacherQo.getName()), EduTeacher::getName, teacherQo.getName());
		wrapper.eq(teacherQo.getLevel() != null, EduTeacher::getLevel, teacherQo.getLevel());
		return wrapper;
	}

}