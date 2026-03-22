package com.zhl.education.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.lang.String;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import com.zhl.utils.rest.RestResponse;

@RestController
@RequestMapping("/support")
@Slf4j
public class CheckController {

	@GetMapping("check")
	public RestResponse<String> check(){
		return RestResponse.ok(HttpStatus.OK.getReasonPhrase());
	}

}