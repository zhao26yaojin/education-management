package com.zhl.acl.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.lang.Long;
import com.zhl.acl.model.convert.RoleConverter;
import com.zhl.acl.mapper.RoleMapper;
import com.zhl.acl.model.qo.RoleQo;
import com.zhl.acl.model.vo.RoleVo;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.acl.model.entity.SysRole;

@Service
public class RoleService extends ServiceImpl<RoleMapper, SysRole> {

	public List<RoleVo> selectVoList(RoleQo roleQo){
		List<SysRole> sysRoleList = selectList(roleQo);
		return RoleConverter.entityListToVoList(sysRoleList);
	}

	public List<SysRole> selectList(RoleQo roleQo){
		LambdaQueryWrapper<SysRole> lambdaQueryWrapper = baseMapper.getQueryWrapper(roleQo);
		return this.list(lambdaQueryWrapper);
	}

	public boolean saveVo(RoleVo roleVo){
		if (roleVo == null) {
			return false;
		}
		SysRole entity = RoleConverter.voToEntity(roleVo);
		boolean result = this.saveOrUpdate(entity);

		if (result) {
			roleVo.setId(entity.getId());
		}
		return result;
	}

}