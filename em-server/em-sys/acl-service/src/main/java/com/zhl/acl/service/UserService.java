package com.zhl.acl.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.lang.Long;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.acl.model.entity.SysUser;
import com.zhl.acl.model.entity.SysUserRole;
import com.zhl.acl.token.TokenService;
import com.zhl.acl.model.qo.UserAuthQo;
import com.zhl.acl.model.vo.UserAuthVo;
import com.zhl.acl.model.convert.UserConverter;
import com.zhl.acl.mapper.UserMapper;
import com.zhl.acl.model.qo.UserRoleQo;

@Service
public class UserService extends ServiceImpl<UserMapper, SysUser> {

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private TokenService tokenService;

	public UserAuthVo login(UserAuthQo userAuthQo){
		SysUser entity = selectEntity(userAuthQo);
		UserAuthVo userAuthVo = UserConverter.entityToVo(entity);
		UserRoleQo userRoleQo = new UserRoleQo();
		userRoleQo.setUserId(userAuthQo.getId());
		List<SysUserRole> userRoleList = userRoleService.selectList(userRoleQo);
		List<Long> roleIdList = userRoleList.stream().map(SysUserRole::getRoleId).toList();
		userAuthVo.setRoleIdList(roleIdList);
		tokenService.createToken(userAuthVo);
		return userAuthVo;
	}

	public SysUser selectEntity(UserAuthQo userAuthQo){
		LambdaQueryWrapper<SysUser> lambdaQueryWrapper = baseMapper.getQueryWrapper(userAuthQo);
		return this.getOne(lambdaQueryWrapper, false);
	}

	public UserAuthVo selectAuthVo(UserAuthQo userAuthQo){
		SysUser entity = selectEntity(userAuthQo);
		UserAuthVo userAuthVo = UserConverter.entityToVo(entity);
		UserRoleQo userRoleQo = new UserRoleQo();
		userRoleQo.setUserId(userAuthQo.getId());
		List<SysUserRole> userRoleList = userRoleService.selectList(userRoleQo);
		List<Long> roleIdList = userRoleList.stream().map(SysUserRole::getRoleId).toList();
		userAuthVo.setRoleIdList(roleIdList);
		return userAuthVo;
	}

}