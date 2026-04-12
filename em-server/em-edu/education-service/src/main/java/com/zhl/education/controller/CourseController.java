package com.zhl.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.zhl.education.model.qo.CourseQo;
import com.zhl.education.service.CourseService;
import com.zhl.education.model.vo.CourseVo;
import org.springframework.web.bind.annotation.GetMapping;
import com.zhl.utils.rest.PageBean;
import com.zhl.utils.rest.PageParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhl.utils.rest.RestResponse;

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