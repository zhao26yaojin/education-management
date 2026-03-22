package com.zhl.acl.model.convert;

import org.springframework.beans.BeanUtils;
import com.zhl.acl.model.vo.UserVo;
import com.zhl.acl.model.entity.SysUser;

public class UserConverter {

	public static UserVo entityToVo(SysUser entity){
		UserVo userVo = new UserVo();
		if (entity == null) {
			return null;
		}
		BeanUtils.copyProperties(entity, userVo);
		return userVo;
	}

}