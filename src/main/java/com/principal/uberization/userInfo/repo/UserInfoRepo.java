package com.principal.uberization.userInfo.repo;

import com.principal.uberization.Login.VO.LoginVO;
import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.userInfo.model.UserCredentials;

/**
 * @author Sujay
 * This nmethod is used for CRUD operations on User
 *
 */
public interface UserInfoRepo {

	/**
	 * @param email
	 * @return
	 * This method is used to get user profile data
	 * @throws UberizationSystemException 
	 */
	UserCredentials getUserProfile(final String email,final String password) throws UberizationSystemException;
	
}
