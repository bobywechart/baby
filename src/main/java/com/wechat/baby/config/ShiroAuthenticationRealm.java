package com.wechat.baby.config;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.DigestUtils;

import com.wechat.baby.entity.Admin;
import com.wechat.baby.entity.Principal;
import com.wechat.baby.service.AdminService;

/**
 * 权限认证
 * @author lianghao
 * 2017年3月20日
 */
public class ShiroAuthenticationRealm extends AuthorizingRealm {

	@Resource(name = "adminServiceImpl")
	private AdminService adminService;
	
	/**
	 * 获取用户授权信息
	 * 
	 * @param principals
	 *            principals
	 * @return 授权信息
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if(principals != null){
			Principal principal = (Principal) principals.fromRealm(getName()).iterator().next();
			if(principal != null){
				List<String> authorities = adminService.listAuth(principal.getId());
				if(authorities != null && !authorities.isEmpty()){
					SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
					authorizationInfo.addStringPermissions(authorities);
					return authorizationInfo;
				}
			}
		}
		return null;
	}

	/**
	 * 获取用户认证信息
	 * 
	 * @param token
	 *            令牌
	 * @return 认证信息
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token){
		ShiroAuthcToken authcToken = (ShiroAuthcToken)token;
		String username = authcToken.getUsername();
		String password = String.valueOf(authcToken.getPassword());
		String ip = authcToken.getHost();
		if(StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)){
			Admin admin = adminService.getAdminByUsername(username, false);
			if(admin == null){
				throw new UnknownAccountException();
			}
			if(!admin.getIsEnabled()){
				throw new DisabledAccountException();
			}
			if(admin.getIsLocked()){
				Date lockedDate = admin.getLockedDate();
				Date unlockDate = DateUtils.addMinutes(lockedDate, 30);
				if (new Date().after(unlockDate)) {
					admin.setLoginFailureCount(0);
					admin.setIsLocked(false);
					admin.setLockedDate(null);
					adminService.updateAdminLocked(admin);
				} else {
					throw new LockedAccountException();
				}
			}
			if (!DigestUtils.md5DigestAsHex(password.getBytes()).equalsIgnoreCase(admin.getPassword())) {
				int loginFailureCount = admin.getLoginFailureCount() + 1;
				if(loginFailureCount >= 3){
					admin.setIsLocked(true);
					admin.setLockedDate(new Date());
				}
				admin.setLoginFailureCount(loginFailureCount);
				adminService.updateAdminLocked(admin);
				throw new IncorrectCredentialsException();
			}
			admin.setLoginIp(ip);
			admin.setModifyDate(new Date());
			admin.setLoginFailureCount(0);
			adminService.updateAdmin(admin);
			return new SimpleAuthenticationInfo(new Principal(admin.getId(), username), password, getName());
		}
		throw new UnknownAccountException();
	}

}