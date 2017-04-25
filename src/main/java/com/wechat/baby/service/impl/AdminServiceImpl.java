package com.wechat.baby.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.wechat.baby.dao.AdminDao;
import com.wechat.baby.entity.Admin;
import com.wechat.baby.service.AdminService;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService{

	@Resource(name = "adminDaoImpl")
	private AdminDao adminDao;
	
	public Admin getAdminByUsername(String username, boolean isUpdate) {
		return adminDao.getAdminByUsername(username, isUpdate);
	}

	public Admin getAdminById(Long id, boolean isUpdate) {
		return adminDao.getAdminById(id, isUpdate);
	}
	
	public List<String> listAuth(Long id) {
		return adminDao.listAuth(id);
	}

	public Admin getCurrent() {
		return adminDao.getCurrent();
	}

	public boolean isAuthenticated() {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			return subject.isAuthenticated();
		}
		return false;
	}

	public boolean updateAdminLocked(Admin admin) {
		return adminDao.updateAdminLocked(admin);
	}

	public String getLoginToken() {
		return DigestUtils.md5DigestAsHex("A8D9F5W3F79D5FG896D5".getBytes());
	}

	public List<Admin> getAdmin() {
		return adminDao.getAdmin();
	}
}
