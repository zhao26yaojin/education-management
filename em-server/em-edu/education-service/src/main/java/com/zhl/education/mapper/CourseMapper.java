package com.zhl.education.mapper;

import java.lang.Long;
import com.zhl.education.model.entity.EduCourse;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import java.lang.String;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhl.education.model.qo.CourseQo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Mapper
public interface CourseMapper extends BaseMapper<EduCourse> {

	default LambdaQueryWrapper<EduCourse> getQueryWrapper(CourseQo courseQo){
		LambdaQueryWrapper<EduCourse> wrapper = Wrappers.lambdaQuery(EduCourse.class);
		wrapper.eq(courseQo.getId() != null, EduCourse::getId, courseQo.getId());
		wrapper.eq(StringUtils.isNotEmpty(courseQo.getName()), EduCourse::getName, courseQo.getName());
		return wrapper;
	}

}