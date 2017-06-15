package com.wechat.baby.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechat.baby.entity.Pageable;
import com.wechat.baby.entity.Role;
import com.wechat.baby.service.RoleService;

@Controller
@RequestMapping("/admin/role")
public class RoleController extends BaseController {

	@Resource(name = "roleServiceImpl")
	private RoleService roleService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Pageable pageable, ModelMap model) {
		PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
		PageInfo<Role> page = new PageInfo<Role>(roleService.getRole());
		model.addAttribute("page", page);
		return "/admin/role/list";
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		return "/admin/role/add";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Role role, RedirectAttributes redirectAttributes) {
		if(role != null){
			roleService.save(role);
		}
		return "redirect:list.html";
	}

	/**
	 * 编辑
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Long id, ModelMap model) {
		model.addAttribute("role", roleService.getRoleById(id));
		return "/admin/role/edit";
	}

	/**
	 * 更新
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Role role, RedirectAttributes redirectAttributes) {
		Role pRole = roleService.getRoleById(role.getId());
		if (pRole == null || pRole.getIsSystem()) {
			return "ERROR";
		}
		roleService.update(role);
		return "redirect:list.html";
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	String delete(Long[] ids) {
		if (ids != null) {
			for (Long id : ids) {
				Role role = roleService.getRoleById(id);
				if (role != null && (role.getIsSystem() || (role.getAdmins() != null && !role.getAdmins().isEmpty()))) {
					return "ERROR";
				}
			}
			roleService.deleteById(ids);
		}
		return "SUCCESS";
	}
}