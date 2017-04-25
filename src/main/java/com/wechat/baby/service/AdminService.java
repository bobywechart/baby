package com.wechat.baby.service;

import java.util.List;

import com.wechat.baby.entity.Admin;

public interface AdminService {

	Admin getAdminByUsername(String username, boolean isUpdate);

	Admin getAdminById(Long id, boolean isUpdate) ;
	
	List<Admin> getAdmin() ;
	
	List<String> listAuth(Long id) ;

	Admin getCurrent();

	String getLoginToken();

	boolean isAuthenticated() ;

	boolean updateAdminLocked(Admin admin);
}
