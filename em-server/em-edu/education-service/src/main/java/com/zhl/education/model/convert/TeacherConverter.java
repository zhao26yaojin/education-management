package com.zhl.education.model.convert;

import org.springframework.beans.BeanUtils;
import com.zhl.education.model.entity.EduTeacher;
import java.util.List;
import com.google.common.collect.Lists;
import com.zhl.education.model.vo.TeacherVo;

public class TeacherConverter {

	public static List<TeacherVo> entityListToVoList(List<EduTeacher> teacherList){
		List<TeacherVo> voList = Lists.newArrayList();
		for (EduTeacher eduTeacher : teacherList) {
			if (eduTeacher == null) {
				return null;
			}
			TeacherVo teacherVo = entityToVo(eduTeacher);
			voList.add(teacherVo);
		}
		return voList;
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