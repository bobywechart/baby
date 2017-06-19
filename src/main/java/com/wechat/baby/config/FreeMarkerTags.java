package com.wechat.baby.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.jagregory.shiro.freemarker.ShiroTags;

import freemarker.template.Configuration;

public class FreeMarkerTags implements InitializingBean{

	@Autowired
	private Configuration configuration;
	
	public void afterPropertiesSet() throws Exception {
		configuration.setSharedVariable("shiro", new ShiroTags());
	}

}
