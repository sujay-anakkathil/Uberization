package com.principal.uberization.userInfo.service.impl;

import org.springframework.stereotype.Service;

import com.principal.uberization.userInfo.service.UserService;
import com.principal.uberization.userInfo.vo.UserInfo;

/**
 * @author Sujay
 * This class is used for various operations on User information
 */

@Service
public class UserServiceImpl implements UserService{
	/**
	 * @param userinfo
	 * @return
	 * This method is used to register user
	 */
	@Override
	public UserInfo registerUser(UserInfo userinfo) {
		// TODO Auto-generated method stub
		return new UserInfo();
	}

}
