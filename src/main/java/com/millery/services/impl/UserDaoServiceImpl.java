package com.millery.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millery.domain.TbUser;
import com.millery.mapper.UserMapper;
import com.millery.mapper.ViewMapper;
import com.millery.services.UserDaoService;

@Service
public class UserDaoServiceImpl implements UserDaoService {
	@Autowired
	ViewMapper viewMapper = null;
	@Autowired
	UserMapper userMapper = null;
	/*@Override
	public Map<String, Object> listAuthByUser(String phone) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allRoles", this.userDao.queryRolesByName(phone));
		map.put("allActions", this.userDao.queryActionByName(phone));
		return map;
	}*/

	@Override
	public TbUser queryTbUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return viewMapper.queryTbUserByUsername(userName);
	}

	@Override
	public boolean insertTbUser(TbUser tbUser) {
		// TODO Auto-generated method stub
		return viewMapper.insertTbUser(tbUser);
	}

	@Override
	public boolean updatePwd(Map<String, String> map) {
		// TODO Auto-generated method stub
		return userMapper.updatePwd(map);
	}



}
