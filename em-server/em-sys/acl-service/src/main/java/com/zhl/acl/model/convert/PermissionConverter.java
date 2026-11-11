package com.zhl.acl.model.convert;

import org.springframework.beans.BeanUtils;
import java.util.List;
import com.google.common.collect.Lists;
import com.zhl.acl.model.vo.PermissionRoleNode;
import com.zhl.acl.model.vo.PermissionVo;
import com.zhl.acl.model.entity.SysPermission;
import com.zhl.utils.tree.TreeUtil;

public class PermissionConverter {

	public static List<PermissionRoleNode> entityListToTree(List<SysPermission> sysPermissionList){
		List<PermissionRoleNode> roleNodeList = Lists.newArrayList();

		for (SysPermission sysPermission : sysPermissionList) {
			if (sysPermission == null) {
				return null;
			}
			PermissionRoleNode permissionRoleNode = entityToNode(sysPermission);
			roleNodeList.add(permissionRoleNode);
		}

		roleNodeList = TreeUtil.buildTree(roleNodeList);
		return roleNodeList;
	}

	public static PermissionRoleNode entityToNode(SysPermission sysPermission){
		PermissionRoleNode permissionRoleNode = new PermissionRoleNode();

		if (sysPermission == null) {
			return null;
		}
		BeanUtils.copyProperties(sysPermission, permissionRoleNode);

		return permissionRoleNode;
	}

	public static List<PermissionVo> entityListToVoList(List<SysPermission> sysPermissionList){
		List<PermissionVo> permissionVoList = Lists.newArrayList();

		for (SysPermission sysPermission : sysPermissionList) {
			if (sysPermission == null) {
				return null;
			}
			PermissionVo permissionVo = entityToVo(sysPermission);
			permissionVoList.add(permissionVo);
		}

		return permissionVoList;
	}

	public static PermissionVo entityToVo(SysPermission sysPermission){
		PermissionVo permissionVo = new PermissionVo();

		if (sysPermission == null) {
			return null;
		}
		BeanUtils.copyProperties(sysPermission, permissionVo);

		return permissionVo;
	}

	public static SysPermission voToEntity(PermissionVo permissionVo){
		SysPermission sysPermission = new SysPermission();

		if (permissionVo == null) {
			return null;
		}
		BeanUtils.copyProperties(permissionVo, sysPermission);

		return sysPermission;
	}

}