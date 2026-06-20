package com.zhl.acl.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.acl.model.entity.SysUser;
import com.zhl.acl.token.TokenService;
import com.zhl.acl.model.convert.UserConverter;
import com.zhl.acl.model.qo.UserLoginQo;
import com.zhl.acl.model.vo.UserLoginVo;
import com.zhl.acl.mapper.UserMapper;

@Service
public class UserService extends ServiceImpl<UserMapper, SysUser> {

	@Autowired
	private TokenService tokenService;

	public UserLoginVo login(UserLoginQo loginQo){
		SysUser entity = selectEntity(loginQo);
		UserLoginVo loginVo = UserConverter.entityToVo(entity);
		tokenService.createToken(loginVo);
		return loginVo;
	}

	public SysUser selectEntity(UserLoginQo loginQo){
		LambdaQueryWrapper<SysUser> queryWrapper = baseMapper.getQueryWrapper(loginQo);
		return this.getOne(queryWrapper, false);
	}

	public UserLoginVo selectLoginVo(UserLoginQo loginQo){
		SysUser entity = selectEntity(loginQo);
		return UserConverter.entityToVo(entity);
	}

}