package com.millery.mapper;

import com.millery.domain.TbUser;

public interface ViewMapper {
	public TbUser queryTbUserByUsername(String userName);

	public boolean insertTbUser(TbUser tbUser);
}
