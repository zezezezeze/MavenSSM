package com.millery.services;

import org.springframework.stereotype.Service;

import com.millery.domain.User;
public interface UserDaoService {
	public User getUser(String phone);
}
