package com.principal.uberization.userInfo.service;

import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.userInfo.vo.UserInfoVO;

/**
 * @author Sujay
 * This interface is used for various operations on User information
 */
public interface UserService {
	/**
	 * @param userinfo
	 * @return
	 * This method is used to register user
	 * @throws UberizationSystemException 
	 */
	Boolean registerUser(final UserInfoVO userinfo) throws UberizationSystemException;
	/**
	 * @param userId
	 * @return
	 * @throws UberizationSystemException
	 * this method is used to get user profile by email
	 */
	UserInfoVO getUserProfile(final String userId) throws UberizationSystemException;
}
