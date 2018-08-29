package com.principal.uberization.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.principal.uberization.Login.VO.LoginVO;
import com.principal.uberization.Login.service.LoginService;
import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.userInfo.service.UserService;
import com.principal.uberization.userInfo.validator.UserServiceValidator;
import com.principal.uberization.userInfo.vo.UserInfo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/rest")
public class AppController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	UserService userService;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
	
	@RequestMapping("/testController")
	public String index() {
		return "test spring rest";
	}

	@RequestMapping(method=RequestMethod.POST,value="/authenticateUser",consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<UserInfo> authenticateUser(@RequestBody final LoginVO loginVO) throws UberizationSystemException {
		final String METHOD_NAME="authenticateUser";
		LOGGER.info("Class:"+this.getClass().getName()+" METHOD entry :"+METHOD_NAME);
		try {
			LOGGER.info("Class:"+this.getClass().getName()+" METHOD exit :"+METHOD_NAME);
			return new ResponseEntity<UserInfo>(loginService.authenticateUser(loginVO), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/registrateUser",consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Boolean> registerUser(@RequestBody final UserInfo userInfo) throws UberizationSystemException {
		final String METHOD_NAME="registerUser";
		LOGGER.info("Class:"+this.getClass().getName()+" METHOD entry :"+METHOD_NAME);
		try {
			UserServiceValidator.validteUser(userInfo);
			LOGGER.info("Class:"+this.getClass().getName()+" METHOD exit :"+METHOD_NAME);
			return new ResponseEntity<>(userService.registerUser(userInfo), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/userprofile/{userID}",consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<UserInfo> getUserProfile(@PathVariable final String userID) throws UberizationSystemException {
		final String METHOD_NAME="authenticateUser";
		LOGGER.info("Class:"+this.getClass().getName()+" METHOD entry :"+METHOD_NAME);
		try {
			LOGGER.info("Class:"+this.getClass().getName()+" METHOD exit :"+METHOD_NAME);
			return new ResponseEntity<UserInfo>(userService.getUserProfile(userID), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
	}
}
