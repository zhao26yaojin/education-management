package com.zhl.acl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.zhl.acl.model.vo.PermissionRoleNode;
import com.zhl.acl.model.qo.PermissionRoleQo;
import com.zhl.acl.service.PermissionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhl.utils.rest.RestResponse;

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

}