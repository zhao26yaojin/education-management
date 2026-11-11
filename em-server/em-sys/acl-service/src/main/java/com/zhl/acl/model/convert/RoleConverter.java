package com.zhl.acl.model.convert;

import org.springframework.beans.BeanUtils;
import java.util.List;
import com.google.common.collect.Lists;
import com.zhl.acl.model.vo.RoleVo;
import com.zhl.acl.model.entity.SysRole;

public class RoleConverter {

	public static List<RoleVo> entityListToVoList(List<SysRole> sysRoleList){
		List<RoleVo> roleVoList = Lists.newArrayList();

		for (SysRole sysRole : sysRoleList) {
			if (sysRole == null) {
				return null;
			}
			RoleVo roleVo = entityToVo(sysRole);
			roleVoList.add(roleVo);
		}

		return roleVoList;
	}

	public static RoleVo entityToVo(SysRole sysRole){
		RoleVo roleVo = new RoleVo();

		if (sysRole == null) {
			return null;
		}
		BeanUtils.copyProperties(sysRole, roleVo);

		return roleVo;
	}

	public static SysRole voToEntity(RoleVo roleVo){
		SysRole sysRole = new SysRole();

		if (roleVo == null) {
			return null;
		}
		BeanUtils.copyProperties(roleVo, sysRole);

		return sysRole;
	}

}