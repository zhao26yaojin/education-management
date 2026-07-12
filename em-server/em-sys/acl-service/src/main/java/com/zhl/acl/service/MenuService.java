package com.zhl.acl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import com.zhl.acl.model.convert.MenuConverter;
import com.zhl.acl.mapper.MenuMapper;
import com.zhl.acl.model.vo.MenuRoleNode;
import com.zhl.acl.model.qo.MenuRoleQo;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.acl.model.entity.SysMenu;

@Service
public class MenuService extends ServiceImpl<MenuMapper, SysMenu> {

	public List<MenuRoleNode> selectVoTree(MenuRoleQo roleQo){
		List<SysMenu> menuList = selectList(roleQo);
		return MenuConverter.entityListToTree(menuList);
	}

	public List<SysMenu> selectList(MenuRoleQo roleQo){
		LambdaQueryWrapper<SysMenu> queryWrapper = baseMapper.getQueryWrapper(roleQo);
		return this.list(queryWrapper);
	}

}