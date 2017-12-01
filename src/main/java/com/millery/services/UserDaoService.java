package com.millery.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.millery.domain.TbMoudle;
import com.millery.domain.TbUser;

public interface UserDaoService {
	public TbUser queryTbUserByUsername(String userName);

	public boolean insertTbUser(TbUser tbUser);

	public boolean updatePwd(Map<String, Object> map);
	//public Map<String,Object> listAuthByUser(String phone) throws Exception;
	
	public boolean deleteTbUser(Long id);
	
	public List<TbUser> queryTbUserList(String column, String keyWord, Integer currentPage,Integer lineSize);
	
	public List<TbMoudle> queryTbMoudleList();
	
	public boolean updateUrlName(int id, String name);
	
	public Map<String, Object> queryUserMessage(Long id);
}
