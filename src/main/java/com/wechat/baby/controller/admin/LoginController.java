package com.wechat.baby.controller.admin;

import java.io.IOException;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wechat.baby.entity.Admin;
import com.wechat.baby.service.RSAService;
import com.wechat.baby.service.impl.AdminServiceImpl;

@Controller
@RequestMapping("/admin/login")
public class LoginController extends BaseController{

	@Resource(name = "adminServiceImpl")
	private AdminServiceImpl adminService;
	@Resource(name = "rsaServiceImpl")
	private RSAService rsaService;
	
	/**
	 * 主页
	 */
	@RequestMapping("/main")
	public String main(ModelMap model) {
		Admin admin = adminService.getCurrent();
		if(admin != null){
			model.addAttribute("admin", admin);
		}
		return "/admin/login/index";
	}

	/**
	 * 登录
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		if(adminService.isAuthenticated()){
			return "redirect:main.html";
		}
		String loginFailure = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		String failureMessage = "";
		if(StringUtils.isNotEmpty(loginFailure)){
			if (loginFailure.equals("org.apache.shiro.authc.pam.UnsupportedTokenException")) {
				failureMessage = "验证码输入错误";
			} else if (loginFailure.equals("org.apache.shiro.authc.UnknownAccountException")) {
				failureMessage = "此账号不存在";
			} else if (loginFailure.equals("org.apache.shiro.authc.DisabledAccountException")) {
				failureMessage = "此账号已被禁用";
			} else if (loginFailure.equals("org.apache.shiro.authc.LockedAccountException")) {
				failureMessage = "此账号已被锁定";
			} else if (loginFailure.equals("org.apache.shiro.authc.IncorrectCredentialsException")) {
				failureMessage = "用户名或密码错误";
			} else if (loginFailure.equals("org.apache.shiro.authc.AuthenticationException")) {
				failureMessage = "账号认证失败";
			}
		}
		RSAPublicKey publicKey = rsaService.generateKey(request);
		model.addAttribute("modulus", Base64.getEncoder().encodeToString(publicKey.getModulus().toByteArray()));
		model.addAttribute("exponent", Base64.getEncoder().encodeToString(publicKey.getPublicExponent().toByteArray()));
		model.addAttribute("failureMessage", failureMessage);
		return "/admin/login/login";
	}
	
	/**
	 * 权限错误
	 */
	@RequestMapping("/unauthorized")
	public String unauthorized(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")) {
			response.addHeader("loginStatus", "unauthorized");
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		return "/admin/403";
	}
}