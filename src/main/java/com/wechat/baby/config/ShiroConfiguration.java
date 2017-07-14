package com.wechat.baby.config;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ShiroConfiguration {
	
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean(name = "hashedCredentialsMatcher")
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		credentialsMatcher.setHashAlgorithmName("MD5");
		credentialsMatcher.setHashIterations(2);//加密次数
		credentialsMatcher.setStoredCredentialsHexEncoded(true);
		return credentialsMatcher;
	}

	@Bean(name = "shiroAuthRealm")
	@DependsOn("lifecycleBeanPostProcessor")
	public ShiroAuthenticationRealm shiroAuthRealm() {
		ShiroAuthenticationRealm realm = new ShiroAuthenticationRealm();
		//realm.setCredentialsMatcher(hashedCredentialsMatcher());
		return realm;
	}

	@Bean(name = "ehCacheManager")
	@DependsOn("lifecycleBeanPostProcessor")
	public EhCacheManager ehCacheManager() {
		EhCacheManager ehCacheManager = new EhCacheManager();
		return ehCacheManager;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(shiroAuthRealm());
		securityManager.setCacheManager(ehCacheManager());
		return securityManager;
	}

	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean() {
		ShiroFilterFactoryBean shiroFilterbean = new ShiroFilterFactoryBean();
		shiroFilterbean.setSecurityManager(securityManager());
		shiroFilterbean.setLoginUrl("/admin/login/index.html");
		shiroFilterbean.setSuccessUrl("/admin/login/main.html");
		shiroFilterbean.setUnauthorizedUrl("/admin/login/unauthorized.html");
		
		Map<String, Filter> map = shiroFilterbean.getFilters();
		map.put("authc", getShiroAuthenticationFilter());
		LogoutFilter logoutFilter = new LogoutFilter();
		logoutFilter.setRedirectUrl("/admin/login/index.html");
		map.put("logout", logoutFilter);
		
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		filterChainDefinitionMap.put("/admin/", "anon");
		filterChainDefinitionMap.put("/admin/login/main.html", "authc");
		filterChainDefinitionMap.put("/admin/login/index.html", "authc");
		filterChainDefinitionMap.put("/admin/login/logout.html", "logout");
		filterChainDefinitionMap.put("/admin/**", "authc");
		shiroFilterbean.setFilterChainDefinitionMap(filterChainDefinitionMap);

		return shiroFilterbean;
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
		daap.setProxyTargetClass(true);
		return daap;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
		aasa.setSecurityManager(securityManager());
		return aasa;
	}
	
	@Bean
	public ShiroAuthenticationFilter getShiroAuthenticationFilter() {
		return new ShiroAuthenticationFilter();
	}
	
	@Bean
	public FreeMarkerTags getFreeMarkerTags() {
		return new FreeMarkerTags();
	}
}
