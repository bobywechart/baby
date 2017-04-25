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

	public Admin getAdminByUsername(String username, boolean isUpdate) {
		Admin result = null;
		if(StringUtils.isNotEmpty(username)){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("username", username);
			map.put("isUpdate", isUpdate);
			result = sqlSession.selectOne("getAdminByUsername", map);
		}
		return result;
	}

	public Admin getAdminById(Long id, boolean isUpdate) {
		Admin result = null;
		if(id > 0){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("isUpdate", isUpdate);
			result = sqlSession.selectOne("getAdminById", map);
		}
		return result;
	}

	public List<String> listAuth(Long id) {
		List<String> result = null;
		if(id > 0){
			result = sqlSession.selectList("listAuth", id);
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
			result = (sqlSession.update("updateAdminLocked", admin) == 1);
		}
		return result;
	}

	public List<Admin> getAdmin() {
		return sqlSession.selectList("getAdmin");
	}

}
