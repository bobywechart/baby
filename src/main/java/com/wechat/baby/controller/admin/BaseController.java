package com.wechat.baby.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {

	@ModelAttribute
	public void initPath(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String base = request.getContextPath();
		String fullPath = request.getScheme() + "://" + request.getServerName() + base;
		model.addAttribute("base", base);
		model.addAttribute("fullPath", fullPath);
	}

}
