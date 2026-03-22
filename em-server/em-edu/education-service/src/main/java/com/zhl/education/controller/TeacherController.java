package com.zhl.education.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.lang.String;
import com.zhl.utils.rest.RestResponse;
import com.zhl.education.model.qo.TeacherQo;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.zhl.education.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import com.zhl.education.model.vo.TeacherVo;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@GetMapping("/list")
	public RestResponse<List<TeacherVo>> List(TeacherQo teacherQo){
		List<TeacherVo> voList = teacherService.selectVoList(teacherQo);
		return RestResponse.ok(voList);
	}

	@PostMapping("/save")
	public RestResponse<String> saveVo(@RequestBody TeacherVo teacherVo){
		if (teacherVo == null) {
			return null;
		}
		boolean result = teacherService.saveVo(teacherVo);
		if (result) {
			return RestResponse.ok();
		}
		else {
			return RestResponse.error(String.valueOf(result));
		}
	}

}