package com.wechat.baby.controller.admin;

import java.util.HashSet;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechat.baby.entity.Admin;
import com.wechat.baby.entity.Pageable;
import com.wechat.baby.entity.Role;
import com.wechat.baby.service.AdminService;
import com.wechat.baby.service.RoleService;

@Controller
@RequestMapping("/admin/admin")
public class AdminController extends BaseController {

	@Resource(name = "adminServiceImpl")
	private AdminService adminService;
	@Resource(name = "roleServiceImpl")
	private RoleService roleService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Pageable pageable, ModelMap model) {
		PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
		PageInfo<Admin> page = new PageInfo<Admin>(adminService.getAdmin());
		model.addAttribute("page", page);
		return "/admin/admin/list";
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("roles", roleService.getRole());
		return "/admin/admin/add";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Admin admin, Long[] roleIds, RedirectAttributes redirectAttributes) {
		admin.setRoles(new HashSet<Role>(roleService.getRoleList(roleIds)));
		if(adminService.getAdminByUsername(admin.getUsername(), false) != null){
			return String.format("【%s】该用户已存在", admin.getUsername());
		}
		admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
		admin.setIsLocked(false);
		admin.setLoginFailureCount(0);
		admin.setLockedDate(null);
		admin.setLoginIp(null);
		adminService.save(admin);
		return "redirect:list.html";
	}

	/**
	 * 编辑
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Long id, ModelMap model) {
		model.addAttribute("admin", adminService.getAdminById(id, false));
		model.addAttribute("roles", roleService.getRole());
		return "/admin/admin/edit";
	}

	/**
	 * 更新
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Admin admin, Long[] roleIds, RedirectAttributes redirectAttributes) {
		return "redirect:list.jhtml";
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	String delete(Long[] ids) {
		return "";
	}
}