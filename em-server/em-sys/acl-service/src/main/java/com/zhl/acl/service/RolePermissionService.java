package com.zhl.acl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import com.zhl.acl.mapper.RolePermissionMapper;
import com.zhl.acl.model.qo.RolePermissionQo;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.acl.model.entity.SysRolePermission;

@Service
public class RolePermissionService extends ServiceImpl<RolePermissionMapper, SysRolePermission> {

	public List<SysRolePermission> selectList(RolePermissionQo rolePermissionQo){
		LambdaQueryWrapper<SysRolePermission> lambdaQueryWrapper = baseMapper.getQueryWrapper(rolePermissionQo);
		return this.list(lambdaQueryWrapper);
	}

}