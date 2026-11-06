package com.zhl.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.lang.Long;
import org.apache.ibatis.annotations.Mapper;
import com.zhl.acl.model.qo.RolePermissionQo;
import com.zhl.acl.model.entity.SysRolePermission;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Mapper
public interface RolePermissionMapper extends BaseMapper<SysRolePermission> {

	default LambdaQueryWrapper<SysRolePermission> getQueryWrapper(RolePermissionQo rolePermissionQo){
		LambdaQueryWrapper<SysRolePermission> wrapper = Wrappers.lambdaQuery(SysRolePermission.class);
		wrapper.eq(rolePermissionQo.getRoleId() != null, SysRolePermission::getRoleId, rolePermissionQo.getRoleId());

		return wrapper;
	}

}