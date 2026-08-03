package com.zhl.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.lang.Long;
import org.apache.ibatis.annotations.Mapper;
import com.zhl.acl.model.entity.SysUserRole;
import com.zhl.acl.model.qo.UserRoleQo;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Mapper
public interface UserRoleMapper extends BaseMapper<SysUserRole> {

	default LambdaQueryWrapper<SysUserRole> getQueryWrapper(UserRoleQo userRoleQo){
		LambdaQueryWrapper<SysUserRole> wrapper = Wrappers.lambdaQuery(SysUserRole.class);
		wrapper.eq(userRoleQo.getUserId() != null, SysUserRole::getUserId, userRoleQo.getUserId());
		return wrapper;
	}

}