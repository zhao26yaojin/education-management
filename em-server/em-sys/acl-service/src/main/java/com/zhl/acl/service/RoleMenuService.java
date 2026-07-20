package com.zhl.acl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhl.acl.mapper.RoleMenuMapper;
import com.zhl.acl.model.qo.RoleMenuQo;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.acl.model.entity.SysRoleMenu;

@Service
public class RoleMenuService extends ServiceImpl<RoleMenuMapper, SysRoleMenu> {

	public SysRoleMenu selectList(RoleMenuQo roleMenuQo){
		LambdaQueryWrapper<SysRoleMenu> lambdaQueryWrapper = baseMapper.getQueryWrapper(roleMenuQo);
		return this.list(lambdaQueryWrapper);
	}

}