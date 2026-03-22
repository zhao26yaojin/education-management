package com.zhl.acl.service;

import com.zhl.acl.model.entity.SysUser;
import com.zhl.acl.model.convert.UserConverter;
import com.zhl.acl.mapper.UserMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.acl.model.vo.UserVo;
import com.zhl.acl.model.qo.UserQo;

@Service
public class UserService extends ServiceImpl<UserMapper, SysUser> {

	public UserVo login(UserQo userQo){
		return selectVo(userQo);
	}

	public UserVo selectVo(UserQo userQo){
		SysUser entity = selectEntity(userQo);
		return UserConverter.entityToVo(entity);
	}

	public SysUser selectEntity(UserQo userQo){
		LambdaQueryWrapper<SysUser> queryWrapper = baseMapper.getQueryWrapper(userQo);
		return this.getOne(queryWrapper, false);
	}

}