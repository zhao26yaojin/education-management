package com.zhl.education.model.convert;

import org.springframework.beans.BeanUtils;
import com.zhl.education.model.entity.EduTeacher;
import java.util.List;
import com.google.common.collect.Lists;
import com.zhl.education.model.vo.TeacherVo;

public class TeacherConverter {

	public static List<TeacherVo> entityListToVoList(List<EduTeacher> eduTeacherList){
		List<TeacherVo> teacherVoList = Lists.newArrayList();
		for (EduTeacher eduTeacher : eduTeacherList) {
			if (eduTeacher == null) {
				return null;
			}
			TeacherVo teacherVo = entityToVo(eduTeacher);
			teacherVoList.add(teacherVo);
		}
		return teacherVoList;
	}

	public static TeacherVo entityToVo(EduTeacher eduTeacher){
		TeacherVo teacherVo = new TeacherVo();
		if (eduTeacher == null) {
			return null;
		}
		BeanUtils.copyProperties(eduTeacher, teacherVo);
		return teacherVo;
	}

	public static EduTeacher voToEntity(TeacherVo teacherVo){
		EduTeacher eduTeacher = new EduTeacher();
		if (teacherVo == null) {
			return null;
		}
		BeanUtils.copyProperties(teacherVo, eduTeacher);
		return eduTeacher;
	}

}