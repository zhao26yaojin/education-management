package com.zhl.acl.model.convert;

import org.springframework.beans.BeanUtils;
import java.util.List;
import com.google.common.collect.Lists;
import com.zhl.acl.model.entity.SysUser;
import com.zhl.acl.model.vo.UserAuthVo;
import com.zhl.acl.model.vo.UserVo;

public class UserConverter {

	public static UserAuthVo entityToAuthVo(SysUser entity){
		UserAuthVo userAuthVo = new UserAuthVo();

		if (entity == null) {
			return null;
		}
		BeanUtils.copyProperties(entity, userAuthVo);

		return userAuthVo;
	}

	public static List<UserVo> entityListToVoList(List<SysUser> sysUserList){
		List<UserVo> userVoList = Lists.newArrayList();

		for (SysUser sysUser : sysUserList) {
			if (sysUser == null) {
				return null;
			}
			UserVo userVo = entityToVo(sysUser);
			userVoList.add(userVo);
		}

		return userVoList;
	}

	public static UserVo entityToVo(SysUser sysUser){
		UserVo userVo = new UserVo();

		if (sysUser == null) {
			return null;
		}
		BeanUtils.copyProperties(sysUser, userVo);

		return userVo;
	}

	public static SysUser voToEntity(UserVo userVo){
		SysUser sysUser = new SysUser();

		if (userVo == null) {
			return null;
		}
		BeanUtils.copyProperties(userVo, sysUser);

		return sysUser;
	}

}