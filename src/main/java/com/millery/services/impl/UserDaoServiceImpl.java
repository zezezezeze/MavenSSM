package com.millery.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millery.domain.TbGroup;
import com.millery.domain.TbMoudle;
import com.millery.domain.TbRole;
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

	@Override
	public List<TbMoudle> queryTbMoudleList() {
		return userMapper.queryTbMoudleList();
	}

	@Override
	public boolean updateUrlName(int id, String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		return userMapper.updateUrlName(map);
	}

	@Override
	public Map<String, Object> queryUserMessage(Long id) {
		// TODO Auto-generated method stub
		return userMapper.queryUserMessage(id);
	}

	@Override
	public List<TbUser> queryTbUserCount(String column, String keyWord) {
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("keyWord", "%"+keyWord+"%");
		map.put("column", column);
		return userMapper.queryTbUserCount(map);
	}

	@Override
	public List<TbGroup> queryTbGruopList() {
		// TODO Auto-generated method stub
		return userMapper.queryTbGruopList();
	}

	@Override
	public boolean deleteTbGroup(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.deleteTbGroup(id);
	}

	@Override
	public List<TbGroup> queryTbGroupList(Integer currentPage, Integer lineSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", (currentPage - 1) * lineSize);
		map.put("lineSize", lineSize);
		return userMapper.queryTbGroupYeList(map);
	}

	@Override
	public boolean insertTbGroup(TbGroup tbGroup) {
		// TODO Auto-generated method stub
		return userMapper.insertTbGroup(tbGroup);
	}

	@Override
	public TbGroup queryTbGroupByid(int id) {
		// TODO Auto-generated method stub
		return userMapper.queryTbGroupByid(id);
	}

	@Override
	public TbRole queryTbRoleByid(int id) {
		// TODO Auto-generated method stub
		return userMapper.queryTbRoleByid(id);
	}


	



}
