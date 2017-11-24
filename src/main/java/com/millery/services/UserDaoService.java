package com.millery.services;

import java.util.Map;
import java.util.Set;

import com.millery.domain.User;

public interface UserDaoService {
	public User getUser(String phone);

	public boolean insertUser(User user);

	public Map<String,Object> listAuthByUser(String phone) throws Exception;
}
