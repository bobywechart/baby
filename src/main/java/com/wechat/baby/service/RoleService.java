package com.wechat.baby.service;

import java.util.List;

import com.wechat.baby.entity.Role;

public interface RoleService {

	List<Role> getRole();

	Role getRoleById(Long id);

	boolean save(Role role);

	boolean deleteById(Long[] ids);

	boolean update(Role role);

}
