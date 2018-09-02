package com.principal.uberization.userInfo.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.uberization.exception.ErrorMessage;
import com.principal.uberization.exception.UberizationBusinessException;
import com.principal.uberization.exception.UberizationExceptionInfo;
import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.userInfo.converter.UserProfileConverter;
import com.principal.uberization.userInfo.enums.SkillEnum;
import com.principal.uberization.userInfo.enums.UserTypeEnum;
import com.principal.uberization.userInfo.model.Skill;
import com.principal.uberization.userInfo.model.UserCredentialPk;
import com.principal.uberization.userInfo.model.UserCredentials;
import com.principal.uberization.userInfo.model.UserProfile;
import com.principal.uberization.userInfo.model.UserType;
import com.principal.uberization.userInfo.repo.UserInfoRepo;
import com.principal.uberization.userInfo.service.UserService;
import com.principal.uberization.userInfo.vo.UserInfoVO;

/**
 * @author Sujay This class is used for various operations on User information
 */

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserInfoRepo userInfoRepo;

	@Autowired
	UserProfileConverter converter;

	/**
	 * @param userinfo
	 * @return This method is used to register user
	 * @throws UberizationSystemException
	 */
	@Override
	public Boolean registerUser(final UserInfoVO userinfo) throws UberizationSystemException {

		final String METHOD_NAME = "registerUser";
		LOGGER.info("Class:" + this.getClass().getName() + " METHOD entry :" + METHOD_NAME);
		try {
			if (null != userinfo) {
				final UserProfile userProfile = new UserProfile();
				userProfile.setFirstName(userinfo.getFirstName());
				userProfile.setLastName(userinfo.getLastName());
				userProfile.setPhone(userinfo.getContactNumber());
				final Set<Skill> skillset = new HashSet<>();
				if (null != userinfo.getSkillSet() && !userinfo.getSkillSet().isEmpty()) {
					for (SkillEnum skillenum : userinfo.getSkillSet()) {
						Skill skill = new Skill(skillenum.getId(), skillenum.getName(), skillenum.getDescription());
						skillset.add(skill);
					}
				}
				userProfile.setSkillSet(skillset);
				userProfile.setVerified(false);
				if (null != userinfo.getResume()) {
					userProfile.setWorkResume(userinfo.getResume().getBytes());
				}

				userProfile.setPhotoSrc(null);
				userProfile.setRating(null);

				final UserTypeEnum userTypeEnum = userinfo.getUserType();
				final UserCredentials userCred = new UserCredentials();
				userCred.setLastLogin(new Date());
				userCred.setPassword(userinfo.getPassword());
				userCred.setLastLogin(new Date());
				userCred.setRegisteredOn(new Date());
				userCred.setUserType(new UserType(userTypeEnum.getId(), userTypeEnum.getName()));
				UserCredentialPk id = new UserCredentialPk();
				id.setUserEmail(userinfo.getEmail());
				userCred.setId(id);

				userInfoRepo.registerUser(userProfile, userCred);

			} else {
				throw new UberizationBusinessException(
						Arrays.asList(
								new ErrorMessage(UberizationExceptionInfo.UBERIZATION_BUSINESS_EXCEPTION.getErrorCode(),
										"User information not available for Registration",
										UberizationExceptionInfo.UBERIZATION_BUSINESS_EXCEPTION.getDescription())),
						"User information not available for Registration");
			}
			return true;

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}

	}

	@Override
	/**
	 * @param userId
	 * @return
	 * @throws UberizationSystemException
	 *             This method is used to get user profile by email
	 */
	public UserInfoVO getUserProfile(final String userId) throws UberizationSystemException {
		final String METHOD_NAME = "getUserProfile";
		LOGGER.info("Class:" + this.getClass().getName() + " METHOD entry :" + METHOD_NAME);
		try {
			if (StringUtils.isNotEmpty(userId)) {
				final UserCredentials userCredentials = userInfoRepo.getUserProfile(userId, null);
				LOGGER.info("Class:" + this.getClass().getName() + " METHOD exit :" + METHOD_NAME);
				return converter.convertUserProfileToUserInfo(userCredentials);
			} else {
				throw new UberizationBusinessException(
						Arrays.asList(
								new ErrorMessage(UberizationExceptionInfo.UBERIZATION_BUSINESS_EXCEPTION.getErrorCode(),
										"Insufficient parameter: email",
										UberizationExceptionInfo.UBERIZATION_BUSINESS_EXCEPTION.getDescription())),
						"Insufficient parameter: email");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
	}

}
