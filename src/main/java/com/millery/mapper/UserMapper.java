package com.millery.mapper;


import java.util.List;
import java.util.Map;
import java.util.Set;

import com.millery.domain.TbGroup;
import com.millery.domain.TbMoudle;
import com.millery.domain.TbRole;
import com.millery.domain.TbUser;


public interface UserMapper {
	
	public boolean updatePwd(Map<String, Object> map);

	public Set<String> queryRolesByName(String u_phone);
	
	public Set<String> queryActionByName(String u_phone);
	
	public boolean deleteTbUser(Long id);
	
	public List<TbUser> queryTbUserList(Map<String, Object> map);
	
	public List<TbMoudle> queryTbMoudleList();
	
	public boolean updateUrlName(Map<String, Object> map);
	
	public Map<String, Object> queryUserMessage(Long id);
	
	public List<TbUser> queryTbUserCount(Map<String, Object> map);
	
	public List<TbGroup> queryTbGruopList();
	
	public boolean deleteTbGroup(Integer id);
	
	public List<TbGroup> queryTbGroupYeList(Map<String, Object> map);
	
	public boolean insertTbGroup(TbGroup tbGroup);
	
	public TbGroup queryTbGroupByid(int id);
	
	public TbRole queryTbRoleByid(int id);
	
	public void updateUserImage(Map<String, Object> map);
}
