package com.zhl.acl.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import com.zhl.acl.model.convert.MenuConverter;
import com.zhl.acl.mapper.MenuMapper;
import com.zhl.acl.model.vo.MenuRoleNode;
import com.zhl.acl.model.qo.MenuRoleQo;
import com.zhl.acl.model.qo.RoleMenuQo;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.acl.model.entity.SysMenu;
import com.zhl.acl.model.entity.SysRoleMenu;

@Service
public class MenuService extends ServiceImpl<MenuMapper, SysMenu> {

	@Autowired
	private RoleMenuService roleMenuService;

	public List<MenuRoleNode> selectVoTree(MenuRoleQo menuRoleQo){
		RoleMenuQo roleMenuQo = new RoleMenuQo();
		SysRoleMenu sysRoleMenu = roleMenuService.selectList(roleMenuQo);
		List<SysMenu> sysMenuList = selectList(menuRoleQo);
		return MenuConverter.entityListToTree(sysMenuList);
	}

	public List<SysMenu> selectList(MenuRoleQo menuRoleQo){
		LambdaQueryWrapper<SysMenu> lambdaQueryWrapper = baseMapper.getQueryWrapper(menuRoleQo);
		return this.list(lambdaQueryWrapper);
	}

}