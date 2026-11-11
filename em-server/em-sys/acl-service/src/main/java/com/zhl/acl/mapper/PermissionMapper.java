package com.zhl.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.lang.Long;
import org.apache.ibatis.annotations.Mapper;
import com.zhl.acl.model.qo.PermissionQo;
import com.zhl.acl.model.qo.PermissionRoleQo;
import java.lang.String;
import org.apache.commons.lang3.StringUtils;
import com.zhl.acl.model.entity.SysPermission;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Mapper
public interface PermissionMapper extends BaseMapper<SysPermission> {

	default LambdaQueryWrapper<SysPermission> getQueryWrapper(PermissionRoleQo permissionRoleQo){
		LambdaQueryWrapper<SysPermission> wrapper = Wrappers.lambdaQuery(SysPermission.class);
		wrapper.eq(permissionRoleQo.getId() != null, SysPermission::getId, permissionRoleQo.getId());
		wrapper.eq(StringUtils.isNotEmpty(permissionRoleQo.getName()), SysPermission::getName, permissionRoleQo.getName());
		wrapper.eq(StringUtils.isNotEmpty(permissionRoleQo.getType()), SysPermission::getType, permissionRoleQo.getType());

		return wrapper;
	}

	default LambdaQueryWrapper<SysPermission> getQueryWrapper(PermissionQo permissionQo){
		LambdaQueryWrapper<SysPermission> wrapper = Wrappers.lambdaQuery(SysPermission.class);
		wrapper.eq(permissionQo.getId() != null, SysPermission::getId, permissionQo.getId());
		wrapper.eq(StringUtils.isNotEmpty(permissionQo.getName()), SysPermission::getName, permissionQo.getName());
		wrapper.eq(StringUtils.isNotEmpty(permissionQo.getType()), SysPermission::getType, permissionQo.getType());

		return wrapper;
	}

}