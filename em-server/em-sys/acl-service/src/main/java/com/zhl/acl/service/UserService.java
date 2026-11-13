package com.zhl.acl.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.lang.Long;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.lang.String;
import com.zhl.acl.model.entity.SysUser;
import com.zhl.acl.model.entity.SysUserRole;
import com.zhl.services.security.service.TokenService;
import com.zhl.acl.model.qo.UserAuthQo;
import com.zhl.acl.model.vo.UserAuthVo;
import com.zhl.acl.model.convert.UserConverter;
import com.zhl.acl.mapper.UserMapper;
import com.zhl.acl.model.qo.UserQo;
import com.zhl.acl.model.qo.UserRoleQo;
import com.zhl.acl.model.vo.UserVo;

@Service
public class UserService extends ServiceImpl<UserMapper, SysUser> {

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private TokenService tokenService;

	public UserAuthVo login(UserAuthQo userAuthQo){
		SysUser entity = selectEntity(userAuthQo);
		UserAuthVo userAuthVo = UserConverter.entityToAuthVo(entity);

		UserRoleQo userRoleQo = new UserRoleQo();
		userRoleQo.setUserId(userAuthQo.getId());
		List<SysUserRole> userRoleList = userRoleService.selectList(userRoleQo);
		List<Long> roleIdList = userRoleList.stream().map(SysUserRole::getRoleId).toList();
		userAuthVo.setRoleIdList(roleIdList);

		userAuthVo.setToken(tokenService.createToken(userAuthVo.getId(), userAuthVo.getName()));

		return userAuthVo;
	}

	public SysUser selectEntity(UserAuthQo userAuthQo){
		LambdaQueryWrapper<SysUser> lambdaQueryWrapper = baseMapper.getQueryWrapper(userAuthQo);
		return this.getOne(lambdaQueryWrapper, false);
	}

	public UserAuthVo selectAuthVo(UserAuthQo userAuthQo){
		SysUser entity = selectEntity(userAuthQo);
		UserAuthVo userAuthVo = UserConverter.entityToAuthVo(entity);

		UserRoleQo userRoleQo = new UserRoleQo();
		userRoleQo.setUserId(userAuthQo.getId());
		List<SysUserRole> userRoleList = userRoleService.selectList(userRoleQo);
		List<Long> roleIdList = userRoleList.stream().map(SysUserRole::getRoleId).toList();
		userAuthVo.setRoleIdList(roleIdList);

		return userAuthVo;
	}

	public List<UserVo> selectVoList(UserQo userQo){
		List<SysUser> sysUserList = selectList(userQo);
		return UserConverter.entityListToVoList(sysUserList);
	}

	public List<SysUser> selectList(UserQo userQo){
		LambdaQueryWrapper<SysUser> lambdaQueryWrapper = baseMapper.getQueryWrapper(userQo);
		return this.list(lambdaQueryWrapper);
	}

	public boolean saveVo(UserVo userVo){
		if (userVo == null) {
			return false;
		}
		SysUser entity = UserConverter.voToEntity(userVo);
		boolean result = this.saveOrUpdate(entity);

		if (result) {
			userVo.setId(entity.getId());
		}
		return result;
	}

}