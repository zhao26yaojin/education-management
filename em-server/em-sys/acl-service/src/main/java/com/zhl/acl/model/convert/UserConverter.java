package com.zhl.acl.model.convert;

import org.springframework.beans.BeanUtils;
import com.zhl.acl.model.entity.SysUser;
import com.zhl.acl.model.vo.UserAuthVo;

public class UserConverter {

	public static UserAuthVo entityToVo(SysUser entity){
		UserAuthVo userAuthVo = new UserAuthVo();

		if (entity == null) {
			return null;
		}
		BeanUtils.copyProperties(entity, userAuthVo);

		return userAuthVo;
	}

}