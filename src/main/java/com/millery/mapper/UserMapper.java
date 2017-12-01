package com.millery.mapper;


import java.util.List;
import java.util.Map;
import java.util.Set;

import com.millery.domain.TbMoudle;
import com.millery.domain.TbUser;


public interface UserMapper {
	
	public boolean updatePwd(Map<String, Object> map);

	public Set<String> queryRolesByName(String u_phone);
	
	public Set<String> queryActionByName(String u_phone);
	
	public boolean deleteTbUser(Long id);
	
	public List<TbUser> queryTbUserList(Map<String, Object> map);
	
	public List<TbMoudle> queryTbMoudleList();
	
	public boolean updateUrlName(Map<String, Object> map);
}
