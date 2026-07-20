package com.zhl.education.model.convert;

import org.springframework.beans.BeanUtils;
import com.zhl.education.model.vo.CourseVo;
import com.zhl.education.model.entity.EduCourse;
import java.util.List;
import com.google.common.collect.Lists;

public class CourseConverter {

	public static List<CourseVo> entityListToVoList(List<EduCourse> eduCourseList){
		List<CourseVo> courseVoList = Lists.newArrayList();
		for (EduCourse eduCourse : eduCourseList) {
			if (eduCourse == null) {
				return null;
			}
			CourseVo courseVo = entityToVo(eduCourse);
			courseVoList.add(courseVo);
		}
		return courseVoList;
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