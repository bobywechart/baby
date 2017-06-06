package com.wechat.baby.controller.baby;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wechat.baby.controller.admin.BaseController;

@Controller
public class ErrorController extends BaseController {

	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String notFound(HttpServletRequest request, ModelMap model) {
		return "/baby/404";
	}
	
	@RequestMapping(value = "/500", method = RequestMethod.GET)
	public String internalServerError(HttpServletRequest request, ModelMap model) {
		return "/baby/500";
	}
	
}