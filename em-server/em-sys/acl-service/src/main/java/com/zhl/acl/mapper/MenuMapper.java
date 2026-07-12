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

	default LambdaQueryWrapper<SysMenu> getQueryWrapper(MenuRoleQo roleQo){
		LambdaQueryWrapper<SysMenu> wrapper = Wrappers.lambdaQuery(SysMenu.class);
		wrapper.eq(roleQo.getId() != null, SysMenu::getId, roleQo.getId());
		wrapper.eq(StringUtils.isNotEmpty(roleQo.getName()), SysMenu::getName, roleQo.getName());
		wrapper.eq(roleQo.getRoleId() != null, SysMenu::getRoleId, roleQo.getRoleId());
		return wrapper;
	}

}