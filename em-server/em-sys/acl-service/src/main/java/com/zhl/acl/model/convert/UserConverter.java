package com.zhl.acl.model.convert;

import org.springframework.beans.BeanUtils;
import com.zhl.acl.model.entity.SysUser;
import com.zhl.acl.model.vo.UserLoginVo;

public class UserConverter {

	public static UserLoginVo entityToVo(SysUser entity){
		UserLoginVo loginVo = new UserLoginVo();
		if (entity == null) {
			return null;
		}
		BeanUtils.copyProperties(entity, loginVo);
		return loginVo;
	}

}