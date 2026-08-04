package com.zhl.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.lang.Long;
import org.apache.ibatis.annotations.Mapper;
import java.lang.String;
import org.apache.commons.lang3.StringUtils;
import com.zhl.acl.model.entity.SysUser;
import com.zhl.acl.model.qo.UserAuthQo;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Mapper
public interface UserMapper extends BaseMapper<SysUser> {

	default LambdaQueryWrapper<SysUser> getQueryWrapper(UserAuthQo userAuthQo){
		LambdaQueryWrapper<SysUser> wrapper = Wrappers.lambdaQuery(SysUser.class);
		wrapper.eq(userAuthQo.getId() != null, SysUser::getId, userAuthQo.getId());
		wrapper.eq(StringUtils.isNotEmpty(userAuthQo.getName()), SysUser::getName, userAuthQo.getName());
		wrapper.eq(StringUtils.isNotEmpty(userAuthQo.getPassword()), SysUser::getPassword, userAuthQo.getPassword());

		return wrapper;
	}

}