package com.wechat.baby.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wechat.baby.dao.AdminDao;
import com.wechat.baby.entity.Admin;
import com.wechat.baby.entity.Principal;

@Repository("adminDaoImpl")
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SqlSession sqlSession;
	/** 对应Mapper命名空间*/
    private static String NAME_SPACE = "com.wechat.baby.mapper.AdminMapper.";
    
	public Admin getAdminByUsername(String username, boolean isUpdate) {
		Admin result = null;
		if(StringUtils.isNotEmpty(username)){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("username", username);
			map.put("isUpdate", isUpdate);
			result = sqlSession.selectOne(NAME_SPACE + "getAdminByUsername", map);
		}
		return result;
	}

	public Admin getAdminById(Long id, boolean isUpdate) {
		Admin result = null;
		if(id > 0){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("isUpdate", isUpdate);
			result = sqlSession.selectOne(NAME_SPACE + "getAdminById", map);
		}
		return result;
	}

	public List<String> listAuth(Long id) {
		List<String> result = null;
		if(id > 0){
			result = sqlSession.selectList(NAME_SPACE + "listAuth", id);
		}
		return result;
	}

	public Admin getCurrent() {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			Principal principal = (Principal) subject.getPrincipal();
			if (principal != null) {
				return getAdminById(principal.getId(), false);
			}
		}
		return null;
	}

	public boolean updateAdminLocked(Admin admin) {
		boolean result = false;
		if(admin != null){
			result = (sqlSession.update(NAME_SPACE + "updateAdminLocked", admin) == 1);
		}
		return result;
	}

	public List<Admin> getAdmin() {
		return sqlSession.selectList(NAME_SPACE + "getAdmin");
	}

	public boolean save(Admin admin) {
		return sqlSession.insert(NAME_SPACE + "saveAdmin", admin) == 1;
	}

	public boolean saveRole(Admin admin) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", admin.getId());
		map.put("roles", admin.getRoles());
		return sqlSession.insert(NAME_SPACE + "saveRole", map) == admin.getRoles().size();
	}

	public boolean updateAdmin(Admin admin) {
		return (sqlSession.update(NAME_SPACE + "updateAdmin", admin) == 1);
	}

	public List<Long> getRoleId(Long id) {
		return sqlSession.selectList(NAME_SPACE + "getRoleId", id);
	}

	public boolean deleteAdminRole(Long id) {
		return sqlSession.delete(NAME_SPACE + "deleteAdminRole", id) > 0;
	}

	public boolean deleteById(Long id) {
		return sqlSession.delete(NAME_SPACE + "deleteById", id) == 1;
	}

}
