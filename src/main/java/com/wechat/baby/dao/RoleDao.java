package com.wechat.baby.dao;

import java.util.List;

import com.wechat.baby.entity.Role;

public interface RoleDao {

	/**
	 * 获取所有角色信息
	 * @author lianghao
	 * @date 2017年6月15日
	 * @return List<Role>
	 */
	List<Role> getRole();

	/**
	 * 根据ID获取角色信息
	 * @author lianghao
	 * @date 2017年6月15日
	 * @param id
	 * @return Role
	 */
	Role getRoleById(Long id);

	/**
	 * 保存角色信息
	 * @author lianghao
	 * @date 2017年6月15日
	 * @param role
	 *          角色信息
	 * @return boolean
	 */
	boolean save(Role role);

	/**
	 * 保存角色权限信息
	 * @author lianghao
	 * @date 2017年6月15日
	 * @param role
	 *         角色信息
	 * @return boolean
	 */
	boolean saveRoleAuthority(Role role);

	/**
	 * 更新角色信息
	 * @author lianghao
	 * @date 2017年6月15日
	 * @param role
	 *          角色信息
	 * @return boolean
	 */
	boolean update(Role role);

	/**
	 * 删除角色权限信息
	 * @author lianghao
	 * @date 2017年6月15日
	 * @param id
	 *         角色ID
	 * @return boolean
	 */
	boolean deleteRoleAuthority(Long id);

	/**
	 * 删除角色信息
	 * @author lianghao
	 * @date 2017年6月15日
	 * @param id
	 *          角色ID
	 * @return boolean
	 */
	boolean deleteById(Long id);
	
}