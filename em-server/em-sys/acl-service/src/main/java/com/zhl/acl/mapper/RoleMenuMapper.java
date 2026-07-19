package com.zhl.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.lang.Long;
import org.apache.ibatis.annotations.Mapper;
import com.zhl.acl.model.qo.RoleMenuQo;
import com.zhl.acl.model.entity.SysRoleMenu;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Mapper
public interface RoleMenuMapper extends BaseMapper<SysRoleMenu> {

	default LambdaQueryWrapper<SysRoleMenu> getQueryWrapper(RoleMenuQo menuQo){
		LambdaQueryWrapper<SysRoleMenu> wrapper = Wrappers.lambdaQuery(SysRoleMenu.class);
		wrapper.eq(menuQo.getRoleId() != null, SysRoleMenu::getRoleId, menuQo.getRoleId());
		return wrapper;
	}

}