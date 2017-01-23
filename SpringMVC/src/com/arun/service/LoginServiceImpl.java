package com.arun.service;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public boolean validateUser(String username, String password) {
		return "arun".equals(username) && "abc".equals(password) ? true : false;
	}

}
