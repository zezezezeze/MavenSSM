package com.millery.services;

import java.util.Map;
import java.util.Set;

import com.millery.domain.TbUser;

public interface UserDaoService {
	public TbUser queryTbUserByUsername(String userName);

	public boolean insertTbUser(TbUser tbUser);

	public boolean updatePwd(Map<String, String> map);
	//public Map<String,Object> listAuthByUser(String phone) throws Exception;
}
