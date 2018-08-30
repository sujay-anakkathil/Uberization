package com.principal.uberization.userInfo.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.userInfo.enums.SkillEnum;
import com.principal.uberization.userInfo.enums.UserTypeEnum;
import com.principal.uberization.userInfo.model.Skill;
import com.principal.uberization.userInfo.model.UserCredentials;
import com.principal.uberization.userInfo.vo.UserInfoVO;

/**
 * @author Sujay This class is used for various conversion related UserProfile
 */
@Component
public class UserProfileConverter {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileConverter.class);

	public UserInfoVO convertUserProfileToUserInfo(final UserCredentials userCredentials)
			throws UberizationSystemException {

		final String METHOD_NAME = "convertUserProfileToUserInfo";
		LOGGER.info("Class:" + this.getClass().getName() + " METHOD entry :" + METHOD_NAME);
		UserInfoVO userInfo = null;
		try {
			if (null != userCredentials) {
				userInfo = new UserInfoVO();
				userInfo.setEmail(userCredentials.getId().getUserEmail());

				if (null != userCredentials.getUserProfile()) {
					userInfo.setContactNumber(userCredentials.getUserProfile().getPhone());
					userInfo.setFirstName(userCredentials.getUserProfile().getFirstName());
					userInfo.setLastName(userCredentials.getUserProfile().getLastName());
					if (null != userCredentials.getUserType() && StringUtils.isNotEmpty(userCredentials.getUserType().getUserTypeText())) {
						if (UserTypeEnum.getNamesMap().containsKey(StringUtils.lowerCase(userCredentials.getUserType().getUserTypeText()))) {
							userInfo.setUserType(UserTypeEnum.getNamesMap().get(StringUtils.lowerCase(userCredentials.getUserType().getUserTypeText())));
						}
					}
					
					if (null != userCredentials.getUserProfile().getSkillSet()
							&& !userCredentials.getUserProfile().getSkillSet().isEmpty()) {
						final List<SkillEnum> skillList = new ArrayList<>();
						for (final Skill skill : userCredentials.getUserProfile().getSkillSet()) {
							if (SkillEnum.getNamesMap().containsKey(skill.getSkillName().toLowerCase())) {
								skillList.add(SkillEnum.getNamesMap().get(StringUtils.lowerCase(skill.getSkillName())));
							}
						}
						userInfo.setSkillSet(skillList);
					}
				}

			} else {
				LOGGER.info("User profile not available");
			}
			return userInfo;

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}

	}

}
