package com.zhl.acl.mapper;

import java.lang.Long;
import com.zhl.acl.model.entity.SysUser;
import org.apache.commons.lang3.StringUtils;
import java.lang.String;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhl.acl.model.qo.UserQo;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Mapper
public interface UserMapper extends BaseMapper<SysUser> {

	default LambdaQueryWrapper<SysUser> getQueryWrapper(UserQo userQo){
		LambdaQueryWrapper<SysUser> wrapper = Wrappers.lambdaQuery(SysUser.class);
		wrapper.eq(userQo.getId() != null, SysUser::getId, userQo.getId());
		wrapper.eq(StringUtils.isNotEmpty(userQo.getName()), SysUser::getName, userQo.getName());
		wrapper.eq(userQo.getParentId() != null, SysUser::getParentId, userQo.getParentId());
		return wrapper;
	}

}