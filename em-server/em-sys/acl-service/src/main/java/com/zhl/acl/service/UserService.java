package com.zhl.acl.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.acl.model.entity.SysUser;
import com.zhl.acl.token.TokenService;
import com.zhl.acl.model.qo.UserAuthQo;
import com.zhl.acl.model.vo.UserAuthVo;
import com.zhl.acl.model.convert.UserConverter;
import com.zhl.acl.mapper.UserMapper;

@Service
public class UserService extends ServiceImpl<UserMapper, SysUser> {

	@Autowired
	private TokenService tokenService;

	public UserAuthVo login(UserAuthQo authQo){
		SysUser entity = selectEntity(authQo);
		UserAuthVo authVo = UserConverter.entityToVo(entity);
		tokenService.createToken(authVo);
		return authVo;
	}

	public SysUser selectEntity(UserAuthQo authQo){
		LambdaQueryWrapper<SysUser> queryWrapper = baseMapper.getQueryWrapper(authQo);
		return this.getOne(queryWrapper, false);
	}

	public UserAuthVo selectAuthVo(UserAuthQo authQo){
		SysUser entity = selectEntity(authQo);
		return UserConverter.entityToVo(entity);
	}

}