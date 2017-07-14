package com.wechat.baby.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.wechat.baby.dao.AdminDao;
import com.wechat.baby.dao.RoleDao;
import com.wechat.baby.entity.Admin;
import com.wechat.baby.entity.ResultEnum;
import com.wechat.baby.entity.Role;
import com.wechat.baby.service.AdminService;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService{

	@Resource(name = "adminDaoImpl")
	private AdminDao adminDao;
	@Resource(name = "roleDaoImpl")
	private RoleDao roleDao;
	
	public Admin getAdminByUsername(String username, boolean isUpdate) {
		Admin admin = adminDao.getAdminByUsername(username, isUpdate);
		if(admin != null){
			List<Long> id = adminDao.getRoleId(admin.getId());
			admin.setRoles(new HashSet<Role>(roleDao.getRoleList(id.toArray(new Long[0]))));
		}
		return admin;
	}

	public Admin getAdminById(Long id, boolean isUpdate) {
		Admin admin = adminDao.getAdminById(id, isUpdate);
		if(admin != null){
			List<Long> ids = adminDao.getRoleId(admin.getId());
			admin.setRoles(new HashSet<Role>(roleDao.getRoleList(ids.toArray(new Long[0]))));
		}
		return admin;
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

	@Transactional
	public boolean save(Admin admin) {
		if(!adminDao.save(admin)){throw new RuntimeException(ResultEnum.DB_INSERT_ERROR.getMsg());}
		if(admin.getRoles() != null && !admin.getRoles().isEmpty()){
			if(!adminDao.saveRole(admin)){
				throw new RuntimeException(ResultEnum.DB_INSERT_ERROR.getMsg());
			}
		}
		return true;
	}

	@Transactional
	public boolean updateAdmin(Admin admin) {
		if(!adminDao.updateAdmin(admin)){throw new RuntimeException(ResultEnum.DB_UPDATE_ERROR.getMsg());}
		if(admin.getRoles() != null && !admin.getRoles().isEmpty()){
			if(!adminDao.deleteAdminRole(admin.getId()) || !adminDao.saveRole(admin)){
				throw new RuntimeException(ResultEnum.DB_INSERT_ERROR.getMsg());
			}
		}
		return true;
	}

	@Transactional
	public boolean deleteById(Long[] ids) {
		int i = 0;
		for(Long id : ids){
			if(adminDao.deleteById(id) && adminDao.deleteAdminRole(id)){
				i++;
			}else{
				throw new RuntimeException(ResultEnum.DB_DELETE_ERROR.getMsg());
			}
		}
		return i == ids.length;
	}
}
