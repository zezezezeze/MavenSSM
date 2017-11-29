package com.millery.mapper;

import java.util.Map;
import java.util.Set;


public interface UserMapper {

	
	public boolean updatePwd(Map<String, String> map);

	public Set<String> queryRolesByName(String u_phone);
	
	public Set<String> queryActionByName(String u_phone);
}
