package com.zhl.education.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhl.education.model.convert.CourseConverter;
import com.zhl.education.mapper.CourseMapper;
import com.zhl.education.model.qo.CourseQo;
import com.zhl.education.model.vo.CourseVo;
import com.zhl.education.model.entity.EduCourse;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.lang.Long;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhl.utils.rest.PageBean;
import com.zhl.utils.rest.PageParam;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service
public class CourseService extends ServiceImpl<CourseMapper, EduCourse> {

	public PageBean<CourseVo> selectVoPage(CourseQo courseQo, PageParam pageParam){
		LambdaQueryWrapper<EduCourse> lambdaQueryWrapper = baseMapper.getQueryWrapper(courseQo);

		Page<EduCourse> eduCoursePage = new Page<EduCourse>(pageParam.getCurrent(), pageParam.getSize());
		baseMapper.selectPage(eduCoursePage, lambdaQueryWrapper);
		List<CourseVo> courseVoList = CourseConverter.entityListToVoList(eduCoursePage.getRecords());
		PageBean<CourseVo> voPageBean = new PageBean<CourseVo>(pageParam.getCurrent(), pageParam.getSize(), eduCoursePage.getTotal(), courseVoList);
		return voPageBean;
	}

	public CourseVo selectVo(CourseQo courseQo){
		EduCourse entity = selectEntity(courseQo);
		return CourseConverter.entityToVo(entity);
	}

	public EduCourse selectEntity(CourseQo courseQo){
		LambdaQueryWrapper<EduCourse> lambdaQueryWrapper = baseMapper.getQueryWrapper(courseQo);
		return this.getOne(lambdaQueryWrapper, false);
	}

}