package com.wechat.baby.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wechat.baby.dao.RoleDao;
import com.wechat.baby.entity.ResultEnum;
import com.wechat.baby.entity.Role;
import com.wechat.baby.service.RoleService;

@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService {

	@Resource(name = "roleDaoImpl")
	private RoleDao roleDao;
	
	public List<Role> getRole() {
		return roleDao.getRole();
	}

	public Role getRoleById(Long id) {
		return roleDao.getRoleById(id);
	}
	
	@Transactional
	public boolean save(Role role) {
		if(!roleDao.save(role)){throw new RuntimeException(ResultEnum.DB_INSERT_ERROR.getMsg());}
		if(role.getId() > 0 && role.getAuthorities() != null && !role.getAuthorities().isEmpty()){
			if(!roleDao.saveRoleAuthority(role)){
				throw new RuntimeException(ResultEnum.DB_INSERT_ERROR.getMsg());
			}
		}
		return true;
	}

	@Transactional
	public boolean deleteById(Long[] ids) {
		int i = 0;
		for(Long id : ids){
			if(roleDao.deleteRoleAuthority(id) && roleDao.deleteById(id)){
				i++;
			}else{
				throw new RuntimeException(ResultEnum.DB_DELETE_ERROR.getMsg());
			}
		}
		return i == ids.length;
	}

	@Transactional
	public boolean update(Role role) {
		if(!roleDao.update(role)){throw new RuntimeException(ResultEnum.DB_UPDATE_ERROR.getMsg());}
		if(role.getId() > 0 && role.getAuthorities() != null && !role.getAuthorities().isEmpty()){
			if(!roleDao.deleteRoleAuthority(role.getId()) || !roleDao.saveRoleAuthority(role)){
				throw new RuntimeException(ResultEnum.DB_INSERT_ERROR.getMsg());
			}
		}	
		return true;
	}

	public List<Role> getRoleList(Long... roleIds) {
		return roleDao.getRoleList(roleIds);
	}

}