package com.zhl.education.service;

import com.zhl.education.model.entity.EduTeacher;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.lang.Long;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.education.model.convert.TeacherConverter;
import com.zhl.education.mapper.TeacherMapper;
import com.zhl.education.model.qo.TeacherQo;
import com.zhl.education.model.vo.TeacherVo;

@Service
public class TeacherService extends ServiceImpl<TeacherMapper, EduTeacher> {

	public List<TeacherVo> selectVoList(TeacherQo teacherQo){
		List<EduTeacher> eduTeacherList = selectList(teacherQo);
		return TeacherConverter.entityListToVoList(eduTeacherList);
	}

	public List<EduTeacher> selectList(TeacherQo teacherQo){
		LambdaQueryWrapper<EduTeacher> lambdaQueryWrapper = baseMapper.getQueryWrapper(teacherQo);
		return this.list(lambdaQueryWrapper);
	}

	public boolean saveVo(TeacherVo teacherVo){
		if (teacherVo == null) {
			return false;
		}
		EduTeacher entity = TeacherConverter.voToEntity(teacherVo);
		boolean result = this.saveOrUpdate(entity);
		if (result) {
			teacherVo.setId(entity.getId());
		}
		return result;
	}

}