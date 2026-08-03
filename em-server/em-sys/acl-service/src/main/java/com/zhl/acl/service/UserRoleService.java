package com.zhl.acl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.acl.model.entity.SysUserRole;
import com.zhl.acl.mapper.UserRoleMapper;
import com.zhl.acl.model.qo.UserRoleQo;

@Service
public class UserRoleService extends ServiceImpl<UserRoleMapper, SysUserRole> {

	public List<SysUserRole> selectList(UserRoleQo userRoleQo){
		LambdaQueryWrapper<SysUserRole> lambdaQueryWrapper = baseMapper.getQueryWrapper(userRoleQo);
		return this.list(lambdaQueryWrapper);
	}

}