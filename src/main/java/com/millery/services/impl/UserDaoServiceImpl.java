package com.millery.services.impl;

import java.util.HashMap;
import java.util.List;
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
	ViewMapper viewMapper ;
	@Autowired
	UserMapper userMapper ;
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
	public boolean updatePwd(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMapper.updatePwd(map);
	}

	@Override
	public boolean deleteTbUser(Long id) {
		// TODO Auto-generated method stub
		return userMapper.deleteTbUser(id);
	}

	@Override
	public List<TbUser> queryTbUserList(String column, String keyWord,
			Integer currentPage, Integer lineSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", column);
		map.put("keyWord", "%"+keyWord+"%");
		map.put("start", (currentPage - 1) * lineSize);
		map.put("lineSize", lineSize);
		return userMapper.queryTbUserList(map);
	}

	



}
