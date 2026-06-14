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
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.lang.String;
import com.zhl.acl.model.qo.UserLoginQo;
import com.zhl.acl.model.vo.UserLoginVo;
import com.zhl.acl.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public RestResponse<UserLoginVo> login(@RequestBody UserLoginQo loginQo){
		UserLoginVo loginVo = userService.login(loginQo);
		if (loginVo != null) {
			return RestResponse.ok(loginVo);
		}
		else {
			return RestResponse.error(ExceptionConstants.NAME_PASSWORD_FAIL);
		}
	}

	@GetMapping("/loginInfo")
	public RestResponse<UserLoginVo> loginInfo(){
		UserLoginQo loginQo = new UserLoginQo();
		loginQo.setId(SecurityUtil.getUserId());
		UserLoginVo loginVo = userService.selectLoginVo(loginQo);
		return RestResponse.ok(loginVo);
	}

}