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

import com.millery.domain.TbUser;
import com.millery.services.UserDaoService;
import com.millery.util.md5.Md5Util;


@Component
public class UserRealm extends AuthorizingRealm {
	private static final Logger logger = LoggerFactory
			.getLogger(UserRealm.class);
	@Resource
	private UserDaoService userService;

	/**
	 * �û���Ȩ��֤
	 */
	@SuppressWarnings("unchecked")
	@Override            
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		logger.info("======�û���Ȩ��֤======");
		String phone = principalCollection.getPrimaryPrincipal().toString();
		SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
	/*	try {
			Map<String, Object> map = this.userService.listAuthByUser(phone);
			Set<String> allRoles = (Set<String>) map.get("allRoles");
			Set<String> allActions = (Set<String>) map.get("allActions");
			auth.setRoles(allRoles);
			auth.setStringPermissions(allActions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		return auth;
	}

	/**
	 * �û���½��֤
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken) {
		logger.info("======�û���½��֤======");
		String userName = authenticationToken.getPrincipal().toString();
		TbUser user = userService.queryTbUserByUsername(userName);
		if (user != null) {
			String password = new String(
					(char[]) authenticationToken.getCredentials());
			if (user.getPassword().equals(password)) {
				AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
						user.getUserName(), user.getPassword(), "userRealm");
				return authenticationInfo;
			} else {
				throw new IncorrectCredentialsException("�������");
			}

		} else {
			throw new UnknownAccountException("�û�������");

		}
	}
	
}