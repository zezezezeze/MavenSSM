package com.millery.realm;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.millery.domain.User;
import com.millery.services.UserDaoService;


@Component
public class UserRealm extends AuthorizingRealm {
	private static final Logger logger = LoggerFactory
			.getLogger(UserRealm.class);
	@Resource
	private UserDaoService userService;

	/**
	 * 用户授权认证
	 */
	@SuppressWarnings("unchecked")
	@Override            
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		logger.info("======用户授权认证======");
		String phone = principalCollection.getPrimaryPrincipal().toString();
		SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
		try {
			Map<String, Object> map = this.userService.listAuthByUser(phone);
			Set<String> allRoles = (Set<String>) map.get("allRoles");
			Set<String> allActions = (Set<String>) map.get("allActions");
			auth.setRoles(allRoles);
			auth.setStringPermissions(allActions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return auth;
	}

	/**
	 * 用户登陆认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken) {
		logger.info("======用户登陆认证======");
		String userName = authenticationToken.getPrincipal().toString();
		User user = userService.getUser(userName);
		if (user != null) {
			String password = new String(
					(char[]) authenticationToken.getCredentials());

			if (user.getU_password().equals(password)) {
				AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
						user.getU_phone(), user.getU_password(), "userRealm");
				return authenticationInfo;
			} else {
				throw new IncorrectCredentialsException("密码错误");
			}

		} else {
			throw new UnknownAccountException("用户不存在");

		}
	}
	@Bean
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}
}