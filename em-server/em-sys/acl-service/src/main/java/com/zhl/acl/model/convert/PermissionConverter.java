package com.zhl.acl.model.convert;

import org.springframework.beans.BeanUtils;
import java.util.List;
import com.google.common.collect.Lists;
import com.zhl.acl.model.vo.PermissionRoleNode;
import com.zhl.acl.model.entity.SysPermission;
import com.zhl.utils.tree.TreeUtil;

public class PermissionConverter {

	public static List<PermissionRoleNode> entityListToTree(List<SysPermission> sysPermissionList){
		List<PermissionRoleNode> roleNodeList = Lists.newArrayList();

		for (SysPermission sysPermission : sysPermissionList) {
			if (sysPermission == null) {
				return null;
			}
			PermissionRoleNode permissionRoleNode = entityToVo(sysPermission);
			roleNodeList.add(permissionRoleNode);
		}

		roleNodeList = TreeUtil.buildTree(roleNodeList);
		return roleNodeList;
	}

	public static PermissionRoleNode entityToVo(SysPermission sysPermission){
		PermissionRoleNode permissionRoleNode = new PermissionRoleNode();

		if (sysPermission == null) {
			return null;
		}
		BeanUtils.copyProperties(sysPermission, permissionRoleNode);

		return permissionRoleNode;
	}

}