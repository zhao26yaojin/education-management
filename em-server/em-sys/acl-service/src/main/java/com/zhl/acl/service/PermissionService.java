package com.zhl.acl.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.lang.Long;
import com.zhl.acl.model.convert.PermissionConverter;
import com.zhl.acl.mapper.PermissionMapper;
import com.zhl.acl.model.qo.PermissionQo;
import com.zhl.acl.model.vo.PermissionRoleNode;
import com.zhl.acl.model.qo.PermissionRoleQo;
import com.zhl.acl.model.vo.PermissionVo;
import com.zhl.acl.model.qo.RolePermissionQo;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.acl.model.entity.SysPermission;
import com.zhl.acl.model.entity.SysRolePermission;

@Service
public class PermissionService extends ServiceImpl<PermissionMapper, SysPermission> {

	@Autowired
	private RolePermissionService rolePermissionService;

	public List<PermissionRoleNode> selectVoTree(PermissionRoleQo permissionRoleQo){
		RolePermissionQo rolePermissionQo = new RolePermissionQo();
		rolePermissionQo.setRoleId(permissionRoleQo.getRoleId());
		List<SysRolePermission> rolePermissionList = rolePermissionService.selectList(rolePermissionQo);
		List<Long> roleIdList = rolePermissionList.stream().map(SysRolePermission::getRoleId).toList();
		permissionRoleQo.setIdList(roleIdList);

		List<SysPermission> sysPermissionList = selectList(permissionRoleQo);
		return PermissionConverter.entityListToRoleTree(sysPermissionList);
	}

	public List<SysPermission> selectList(PermissionRoleQo permissionRoleQo){
		LambdaQueryWrapper<SysPermission> lambdaQueryWrapper = baseMapper.getQueryWrapper(permissionRoleQo);
		return this.list(lambdaQueryWrapper);
	}

	public List<PermissionVo> selectVoList(PermissionQo permissionQo){
		List<SysPermission> sysPermissionList = selectList(permissionQo);
		return PermissionConverter.entityListToVoList(sysPermissionList);
	}

	public List<SysPermission> selectList(PermissionQo permissionQo){
		LambdaQueryWrapper<SysPermission> lambdaQueryWrapper = baseMapper.getQueryWrapper(permissionQo);
		return this.list(lambdaQueryWrapper);
	}

	public boolean saveVo(PermissionVo permissionVo){
		if (permissionVo == null) {
			return false;
		}
		SysPermission entity = PermissionConverter.voToEntity(permissionVo);
		boolean result = this.saveOrUpdate(entity);

		if (result) {
			permissionVo.setId(entity.getId());
		}
		return result;
	}

}