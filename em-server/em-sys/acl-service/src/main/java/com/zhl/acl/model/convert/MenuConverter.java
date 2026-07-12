package com.zhl.acl.model.convert;

import org.springframework.beans.BeanUtils;
import java.util.List;
import com.google.common.collect.Lists;
import com.zhl.acl.model.vo.MenuRoleNode;
import com.zhl.acl.model.entity.SysMenu;
import com.zhl.utils.tree.TreeUtil;

public class MenuConverter {

	public static List<MenuRoleNode> entityListToTree(List<SysMenu> menuList){
		List<MenuRoleNode> nodeList = Lists.newArrayList();
		for (SysMenu sysMenu : menuList) {
			if (sysMenu == null) {
				return null;
			}
			MenuRoleNode roleNode = entityToVo(sysMenu);
			nodeList.add(roleNode);
		}
		nodeList = TreeUtil.buildTree(nodeList);
		return nodeList;
	}

	public static MenuRoleNode entityToVo(SysMenu sysMenu){
		MenuRoleNode roleNode = new MenuRoleNode();
		if (sysMenu == null) {
			return null;
		}
		BeanUtils.copyProperties(sysMenu, roleNode);
		return roleNode;
	}

}