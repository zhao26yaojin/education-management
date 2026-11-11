package com.zhl.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.lang.Long;
import org.apache.ibatis.annotations.Mapper;
import com.zhl.acl.model.qo.RoleQo;
import java.lang.String;
import org.apache.commons.lang3.StringUtils;
import com.zhl.acl.model.entity.SysRole;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Mapper
public interface RoleMapper extends BaseMapper<SysRole> {

	default LambdaQueryWrapper<SysRole> getQueryWrapper(RoleQo roleQo){
		LambdaQueryWrapper<SysRole> wrapper = Wrappers.lambdaQuery(SysRole.class);
		wrapper.eq(roleQo.getId() != null, SysRole::getId, roleQo.getId());
		wrapper.eq(StringUtils.isNotEmpty(roleQo.getName()), SysRole::getName, roleQo.getName());

		return wrapper;
	}

}