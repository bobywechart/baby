package com.wechat.baby.dao;

import java.util.List;

import com.wechat.baby.entity.Admin;

public interface AdminDao {

	/**
	 * 根据用户名查找管理员信息
	 * @author lianghao
	 * @date 2017年3月17日
	 * @param username
	 *          用户名
	 * @param isUpdate
	 *          是否使用行级锁
	 * @return Admin
	 */
	Admin getAdminByUsername(String username, boolean isUpdate);
	
	/**
	 * 根据主键ID查找管理员信息
	 * @author lianghao
	 * @date 2017年3月17日
	 * @param id
	 *         主键ID
	 * @param isUpdate
	 *         是否使用行级锁
	 * @return Admin
	 */
	Admin getAdminById(Long id, boolean isUpdate);
	
	/**
	 * 根据主键ID查找用户权限
	 * @author lianghao
	 * @date 2017年3月17日
	 * @param id
	 *         主键ID
	 * @return List<String>
	 */
	List<String> listAuth(Long id);

	/**
	 * 获取当前登录的用户信息
	 * @author lianghao
	 * @date 2017年3月21日
	 * @return Admin
	 */
	Admin getCurrent();

	/**
	 * 更新管理员信息
	 * @author lianghao
	 * @date 2017年3月28日
	 * @param admin
	 *           管理员信息
	 * @return boolean
	 */
	boolean updateAdminLocked(Admin admin);

	/**
	 * 获取所有管理员信息
	 * @author lianghao
	 * @date 2017年4月20日
	 * @return List<Admin>
	 */
	List<Admin> getAdmin();

	/**
	 * 保存管理员信息
	 * @author lianghao
	 * @date 2017年6月15日
	 * @param admin
	 *           管理员信息
	 * @return boolean
	 */
	boolean save(Admin admin);

	/**
	 * 保存管理员角色信息
	 * @author lianghao
	 * @date 2017年6月15日
	 * @param admin
	 *           管理员信息
	 * @return boolean
	 */
	boolean saveRole(Admin admin);

	/**
	 * 更新管理员信息
	 * @author lianghao
	 * @date 2017年6月16日
	 * @param admin
	 *          管理员信息
	 * @return boolean
	 */
	boolean updateAdmin(Admin admin);

	/**
	 * 根据管理员ID查找角色信息
	 * @author lianghao
	 * @date 2017年6月22日
	 * @param id
	 *         管理员ID
	 * @return List<Long>
	 */
	List<Long> getRoleId(Long id);

	/**
	 * 根据管理员ID删除权限信息
	 * @author lianghao
	 * @date 2017年6月22日
	 * @param id
	 *         管理员ID
	 * @return boolean
	 */
	boolean deleteAdminRole(Long id);

	/**
	 * 根据管理员ID删除管理员信息
	 * @author lianghao
	 * @date 2017年6月22日
	 * @param id
	 *         管理员ID
	 * @return boolean
	 */
	boolean deleteById(Long id);
	
}
