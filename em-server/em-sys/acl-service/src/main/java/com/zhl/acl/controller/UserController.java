package com.zhl.acl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.zhl.utils.constant.ExceptionConstants;
import org.springframework.web.bind.annotation.GetMapping;
import java.lang.Long;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhl.utils.rest.RestResponse;
import com.zhl.services.security.SecurityUtil;
import java.lang.String;
import com.zhl.acl.model.qo.UserAuthQo;
import com.zhl.acl.model.vo.UserAuthVo;
import com.zhl.acl.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/auth/login")
	public RestResponse<UserAuthVo> login(@RequestBody UserAuthQo userAuthQo){
		UserAuthVo userAuthVo = userService.login(userAuthQo);

		if (userAuthVo != null) {
			return RestResponse.ok(userAuthVo);
		}

		else {
			return RestResponse.error(ExceptionConstants.NAME_PASSWORD_FAIL);
		}
	}

	@GetMapping("/auth/loginInfo")
	public RestResponse<UserAuthVo> loginInfo(){
		UserAuthQo userAuthQo = new UserAuthQo();
		userAuthQo.setId(SecurityUtil.getUserId());
		UserAuthVo userAuthVo = userService.selectAuthVo(userAuthQo);
		return RestResponse.ok(userAuthVo);
	}

}