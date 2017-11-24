package com.millery.mapper;

import java.util.Set;

import com.millery.domain.User;

public interface UserMapper {
	public User queryByUsername(String u_phone);

	public boolean insertUser(User user);

	public Set<String> queryRolesByName(String u_phone);
	
	public Set<String> queryActionByName(String u_phone);
}
