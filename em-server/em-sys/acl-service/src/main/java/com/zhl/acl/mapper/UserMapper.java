package com.zhl.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.lang.Long;
import org.apache.ibatis.annotations.Mapper;
import java.lang.String;
import org.apache.commons.lang3.StringUtils;
import com.zhl.acl.model.entity.SysUser;
import com.zhl.acl.model.qo.UserLoginQo;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Mapper
public interface UserMapper extends BaseMapper<SysUser> {

	default LambdaQueryWrapper<SysUser> getQueryWrapper(UserLoginQo loginQo){
		LambdaQueryWrapper<SysUser> wrapper = Wrappers.lambdaQuery(SysUser.class);
		wrapper.eq(loginQo.getId() != null, SysUser::getId, loginQo.getId());
		wrapper.eq(StringUtils.isNotEmpty(loginQo.getName()), SysUser::getName, loginQo.getName());
		wrapper.eq(StringUtils.isNotEmpty(loginQo.getPassword()), SysUser::getPassword, loginQo.getPassword());
		return wrapper;
	}

}