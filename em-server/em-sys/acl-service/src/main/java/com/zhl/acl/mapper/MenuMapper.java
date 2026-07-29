package com.zhl.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.lang.Long;
import org.apache.ibatis.annotations.Mapper;
import com.zhl.acl.model.qo.MenuRoleQo;
import java.lang.String;
import org.apache.commons.lang3.StringUtils;
import com.zhl.acl.model.entity.SysMenu;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Mapper
public interface MenuMapper extends BaseMapper<SysMenu> {

	default LambdaQueryWrapper<SysMenu> getQueryWrapper(MenuRoleQo menuRoleQo){
		LambdaQueryWrapper<SysMenu> wrapper = Wrappers.lambdaQuery(SysMenu.class);
		wrapper.eq(menuRoleQo.getId() != null, SysMenu::getId, menuRoleQo.getId());
		wrapper.eq(StringUtils.isNotEmpty(menuRoleQo.getName()), SysMenu::getName, menuRoleQo.getName());
		return wrapper;
	}

}