package com.zhl.acl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.zhl.acl.model.qo.PermissionQo;
import com.zhl.acl.model.vo.PermissionRoleNode;
import com.zhl.acl.model.qo.PermissionRoleQo;
import com.zhl.acl.service.PermissionService;
import com.zhl.acl.model.vo.PermissionVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhl.utils.rest.RestResponse;
import java.lang.String;

@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@GetMapping("/role/tree")
	public RestResponse<List<PermissionRoleNode>> roleTree(PermissionRoleQo permissionRoleQo){
		List<PermissionRoleNode> roleNodeList = permissionService.selectVoTree(permissionRoleQo);
		return RestResponse.ok(roleNodeList);
	}

	@GetMapping("/list")
	public RestResponse<List<PermissionVo>> list(PermissionQo permissionQo){
		List<PermissionVo> permissionVoList = permissionService.selectVoList(permissionQo);
		return RestResponse.ok(permissionVoList);
	}

	@PostMapping("/save")
	public RestResponse<String> saveVo(@RequestBody PermissionVo permissionVo){
		if (permissionVo == null) {
			return null;
		}
		boolean result = permissionService.saveVo(permissionVo);

		if (result) {
			return RestResponse.ok();
		}

		else {
			return RestResponse.error(String.valueOf(result));
		}
	}

}