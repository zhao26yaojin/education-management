package com.zhl.acl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.zhl.acl.model.vo.MenuRoleNode;
import com.zhl.acl.model.qo.MenuRoleQo;
import com.zhl.acl.service.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhl.utils.rest.RestResponse;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@GetMapping("/role/tree")
	public RestResponse<List<MenuRoleNode>> roleTree(MenuRoleQo menuRoleQo){
		List<MenuRoleNode> roleNodeList = menuService.selectVoTree(menuRoleQo);
		return RestResponse.ok(roleNodeList);
	}

}