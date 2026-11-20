package com.zhl.acl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.zhl.utils.constant.ExceptionConstants;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.lang.Long;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhl.utils.rest.RestResponse;
import com.zhl.acl.model.qo.RoleQo;
import com.zhl.acl.service.RoleService;
import com.zhl.acl.model.vo.RoleVo;
import java.lang.String;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/list")
	public RestResponse<List<RoleVo>> list(RoleQo roleQo){
		List<RoleVo> roleVoList = roleService.selectVoList(roleQo);
		return RestResponse.ok(roleVoList);
	}

	@PostMapping("/delete")
	public RestResponse<String> delete(@RequestBody List<Long> ids){
		boolean result = roleService.deleteByIds(ids);

		if (result) {
			return RestResponse.ok();
		}

		else {
			return RestResponse.error(ExceptionConstants.DELETE_FAIL);
		}
	}

	@GetMapping("/detail")
	public RestResponse<RoleVo> selectVo(RoleQo roleQo){
		RoleVo roleVo = roleService.selectVo(roleQo);
		return RestResponse.ok(roleVo);
	}

	@PostMapping("/save")
	public RestResponse<String> saveVo(@RequestBody RoleVo roleVo){
		if (roleVo == null) {
			return null;
		}
		boolean result = roleService.saveVo(roleVo);

		if (result) {
			return RestResponse.ok();
		}

		else {
			return RestResponse.error(String.valueOf(result));
		}
	}

}