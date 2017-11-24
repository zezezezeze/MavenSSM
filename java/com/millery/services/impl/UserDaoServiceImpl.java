package com.millery.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millery.domain.User;
import com.millery.mapper.UserMapper;
import com.millery.services.UserDaoService;
@Service
public class UserDaoServiceImpl implements UserDaoService {
	@Autowired
    UserMapper userDao=null;
	public User getUser(String phone) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(phone);
	}

}
