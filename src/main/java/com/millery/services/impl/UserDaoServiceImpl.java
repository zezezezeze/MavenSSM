package com.millery.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millery.domain.User;
import com.millery.mapper.UserMapper;
import com.millery.services.UserDaoService;

@Service
public class UserDaoServiceImpl implements UserDaoService {
	@Autowired
	UserMapper userDao = null;

	@Override
	public User getUser(String phone) {
		// TODO Auto-generated method stub
		return userDao.queryByUsername(phone);
	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}

	@Override
	public Map<String, Object> listAuthByUser(String phone) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allRoles", this.userDao.queryRolesByName(phone));
		map.put("allActions", this.userDao.queryActionByName(phone));
		return map;
	}



}
