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
import com.zhl.acl.model.qo.UserQo;
import com.zhl.acl.service.UserService;
import com.zhl.acl.model.vo.UserVo;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public RestResponse<UserVo> login(@RequestBody UserQo userQo){
		UserVo userVo = userService.login(userQo);
		if (userVo != null) {
			return RestResponse.ok(userVo);
		}
		else {
			return RestResponse.error(ExceptionConstants.NAME_PASSWORD_FAIL);
		}
	}

	@GetMapping("/loginInfo")
	public RestResponse<UserVo> loginInfo(){
		UserQo userQo = new UserQo();
		userQo.setId(SecurityUtil.getUserId());
		UserVo userVo = userService.selectVo(userQo);
		return RestResponse.ok(userVo);
	}

}