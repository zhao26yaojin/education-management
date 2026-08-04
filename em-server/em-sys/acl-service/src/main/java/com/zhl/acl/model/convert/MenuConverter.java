package com.zhl.acl.model.convert;

import org.springframework.beans.BeanUtils;
import java.util.List;
import com.google.common.collect.Lists;
import com.zhl.acl.model.vo.MenuRoleNode;
import com.zhl.acl.model.entity.SysMenu;
import com.zhl.utils.tree.TreeUtil;

public class MenuConverter {

	public static List<MenuRoleNode> entityListToTree(List<SysMenu> sysMenuList){
		List<MenuRoleNode> roleNodeList = Lists.newArrayList();

		for (SysMenu sysMenu : sysMenuList) {
			if (sysMenu == null) {
				return null;
			}
			MenuRoleNode menuRoleNode = entityToVo(sysMenu);
			roleNodeList.add(menuRoleNode);
		}

		roleNodeList = TreeUtil.buildTree(roleNodeList);
		return roleNodeList;
	}

	public static MenuRoleNode entityToVo(SysMenu sysMenu){
		MenuRoleNode menuRoleNode = new MenuRoleNode();

		if (sysMenu == null) {
			return null;
		}
		BeanUtils.copyProperties(sysMenu, menuRoleNode);

		return menuRoleNode;
	}

}