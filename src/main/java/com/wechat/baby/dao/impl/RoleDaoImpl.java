package com.wechat.baby.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wechat.baby.dao.RoleDao;
import com.wechat.baby.entity.Role;

@Repository("roleDaoImpl")
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SqlSession sqlSession;
	/** 对应Mapper命名空间*/
    private static String NAME_SPACE = "com.wechat.baby.mapper.RoleMapper.";
    
	public List<Role> getRole() {
		return sqlSession.selectList(NAME_SPACE + "getRole");
	}

	public Role getRoleById(Long id) {
		return sqlSession.selectOne(NAME_SPACE + "getRoleById", id);
	}

	public boolean save(Role role) {
		return sqlSession.insert(NAME_SPACE + "save", role) == 1;
	}

	public boolean saveRoleAuthority(Role role) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", role.getId());
		map.put("authorities", role.getAuthorities());
		return sqlSession.insert(NAME_SPACE + "saveRoleAuthority", map) == role.getAuthorities().size();
	}

	public boolean update(Role role) {
		return sqlSession.update(NAME_SPACE + "update", role) == 1;
	}

	public boolean deleteRoleAuthority(Long id) {
		return sqlSession.delete(NAME_SPACE + "deleteRoleAuthority", id) > 0;
	}

	public boolean deleteById(Long id) {
		return sqlSession.delete(NAME_SPACE + "deleteById", id) == 1;
	}

	public List<Role> getRoleList(Long... roleIds) {
		return sqlSession.selectList(NAME_SPACE + "getRoleList", roleIds);
	}
	
}