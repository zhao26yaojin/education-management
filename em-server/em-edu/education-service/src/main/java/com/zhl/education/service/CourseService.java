package com.zhl.education.service;

import com.zhl.education.mapper.CourseMapper;
import com.zhl.utils.rest.PageBean;
import com.zhl.education.model.entity.EduCourse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhl.education.model.convert.CourseConverter;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.utils.rest.PageParam;
import com.zhl.education.model.vo.CourseVo;
import com.zhl.education.model.qo.CourseQo;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.lang.Long;

@Service
public class CourseService extends ServiceImpl<CourseMapper, EduCourse> {

	public PageBean<CourseVo> selectVoPage(CourseQo courseQo, PageParam pageParam){
		LambdaQueryWrapper<EduCourse> queryWrapper = baseMapper.getQueryWrapper(courseQo);
		Page<EduCourse> coursePage = new Page<EduCourse>(pageParam.getCurrent(), pageParam.getSize());
		baseMapper.selectPage(coursePage, queryWrapper);
		List<CourseVo> voList = CourseConverter.entityListToVoList(coursePage.getRecords());
		PageBean<CourseVo> pageBean = new PageBean<CourseVo>(pageParam.getCurrent(), pageParam.getSize(), coursePage.getTotal(), voList);
		return pageBean;
	}

	public CourseVo selectVo(CourseQo courseQo){
		EduCourse entity = selectEntity(courseQo);
		return CourseConverter.entityToVo(entity);
	}

	public EduCourse selectEntity(CourseQo courseQo){
		LambdaQueryWrapper<EduCourse> queryWrapper = baseMapper.getQueryWrapper(courseQo);
		return this.getOne(queryWrapper, false);
	}

}