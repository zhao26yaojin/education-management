package com.zhl.education.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.zhl.utils.rest.PageBean;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zhl.utils.rest.RestResponse;
import com.zhl.utils.rest.PageParam;
import com.zhl.education.model.vo.CourseVo;
import com.zhl.education.model.qo.CourseQo;
import com.zhl.education.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/page")
	public RestResponse<PageBean<CourseVo>> page(CourseQo courseQo, PageParam pageParam){
		PageBean<CourseVo> pageBean = courseService.selectVoPage(courseQo, pageParam);
		return RestResponse.ok(pageBean);
	}

	@GetMapping("/detail")
	public RestResponse<CourseVo> selectVo(CourseQo courseQo){
		CourseVo courseVo = courseService.selectVo(courseQo);
		return RestResponse.ok(courseVo);
	}

}