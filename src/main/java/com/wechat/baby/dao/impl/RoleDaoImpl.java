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

	public List<Role> getRole() {
		return sqlSession.selectList("getRole");
	}

	public Role getRoleById(Long id) {
		return sqlSession.selectOne("getRoleById", id);
	}

	public boolean save(Role role) {
		return sqlSession.insert("save", role) == 1;
	}

	public boolean saveRoleAuthority(Role role) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("id", role.getId());
		map.put("authorities", role.getAuthorities());
		return sqlSession.insert("saveRoleAuthority", map) == role.getAuthorities().size();
	}

	public boolean update(Role role) {
		return sqlSession.update("update", role) == 1;
	}

	public boolean deleteRoleAuthority(Long id) {
		return sqlSession.delete("deleteRoleAuthority", id) > 0;
	}

	public boolean deleteById(Long id) {
		return sqlSession.delete("deleteById", id) == 1;
	}
	
}