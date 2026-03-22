package com.zhl.education.model.convert;

import com.zhl.education.model.entity.EduCourse;
import com.google.common.collect.Lists;
import com.zhl.education.model.vo.CourseVo;
import java.util.List;
import org.springframework.beans.BeanUtils;

public class CourseConverter {

	public static List<CourseVo> entityListToVoList(List<EduCourse> courseList){
		List<CourseVo> voList = Lists.newArrayList();
		for (EduCourse eduCourse : courseList) {
			if (eduCourse == null) {
				return null;
			}
			CourseVo courseVo = entityToVo(eduCourse);
			voList.add(courseVo);
		}
		return voList;
	}

	public static CourseVo entityToVo(EduCourse eduCourse){
		CourseVo courseVo = new CourseVo();
		if (eduCourse == null) {
			return null;
		}
		BeanUtils.copyProperties(eduCourse, courseVo);
		return courseVo;
	}

}