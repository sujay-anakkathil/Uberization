package com.principal.uberization.controller;

import java.util.List;

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
import com.principal.uberization.exception.ErrorMessage;
import com.principal.uberization.exception.UberizationAuthenticationException;
import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.job.service.JobService;
import com.principal.uberization.job.vo.JobDetailsVO;
import com.principal.uberization.job.vo.UserJobResponse;
import com.principal.uberization.userInfo.service.UserService;
import com.principal.uberization.userInfo.validator.UserServiceValidator;
import com.principal.uberization.userInfo.vo.UserInfoVO;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("/rest")
public class AppController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	JobService jobService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
	
	@RequestMapping("/testController")
	public String index() throws UberizationSystemException {
		jobService.test();
		return "test spring rest";
	}

	@RequestMapping(method=RequestMethod.POST,value="/authenticateUser",consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> authenticateUser(@RequestBody final LoginVO loginVO) throws UberizationSystemException {
		final String METHOD_NAME="authenticateUser";
		LOGGER.info("Class:"+this.getClass().getName()+" METHOD entry :"+METHOD_NAME);
		try {
			LOGGER.info("Class:"+this.getClass().getName()+" METHOD exit :"+METHOD_NAME);
			return new ResponseEntity<UserInfoVO>(loginService.authenticateUser(loginVO), HttpStatus.OK);
		}catch(UberizationAuthenticationException e) {
			return new ResponseEntity<ErrorMessage>(new ErrorMessage(401, "Invalid Username or Password", "AUTHENTICATION_FAILED"),HttpStatus.UNAUTHORIZED);
		}catch (Exception e) {
			throw new UberizationSystemException(e.getMessage(), e);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/registerUser",consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Boolean> registerUser(@RequestBody final UserInfoVO userInfo) throws UberizationSystemException {
		final String METHOD_NAME="registerUser";
		LOGGER.info("Class:"+this.getClass().getName()+" METHOD entry :"+METHOD_NAME);
		try {
			//TODO: Need to complete the validations for user registrations
			UserServiceValidator.validteUser(userInfo);
			LOGGER.info("Class:"+this.getClass().getName()+" METHOD exit :"+METHOD_NAME);
			return new ResponseEntity<>(userService.registerUser(userInfo), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/userprofile/{userID:.+}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<UserInfoVO> getUserProfile(@PathVariable final String userID) throws UberizationSystemException {
		final String METHOD_NAME="authenticateUser";
		LOGGER.info("Class:"+this.getClass().getName()+" METHOD entry :"+METHOD_NAME);
		try {
			LOGGER.info("Class:"+this.getClass().getName()+" METHOD exit :"+METHOD_NAME);
			return new ResponseEntity<UserInfoVO>(userService.getUserProfile(userID), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/publishJob",consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Boolean> publishJob(@RequestBody final JobDetailsVO jobDetailsVO) throws UberizationSystemException {
		final String METHOD_NAME="registerUser";
		LOGGER.info("Class:"+this.getClass().getName()+" METHOD entry :"+METHOD_NAME);
		try {
			LOGGER.info("Class:"+this.getClass().getName()+" METHOD exit :"+METHOD_NAME);
			return new ResponseEntity<>(jobService.publishJobPosting(jobDetailsVO), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getTaskList",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<JobDetailsVO>> getTaskList() throws UberizationSystemException {
		final String METHOD_NAME="getTaskList";
		LOGGER.info("Class:"+this.getClass().getName()+" METHOD entry :"+METHOD_NAME);
		try {
			LOGGER.info("Class:"+this.getClass().getName()+" METHOD exit :"+METHOD_NAME);
			return new ResponseEntity<List<JobDetailsVO>>(jobService.getTaskList(), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/saveUserTaskResponse",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Boolean> saveUserTaskResponse(@RequestBody final List<UserJobResponse> userJobResponseList) throws UberizationSystemException {
		final String METHOD_NAME="saveUserTaskResponse";
		LOGGER.info("Class:"+this.getClass().getName()+" METHOD entry :"+METHOD_NAME);
		try {
			LOGGER.info("Class:"+this.getClass().getName()+" METHOD exit :"+METHOD_NAME);
			return new ResponseEntity<Boolean>(jobService.saveUserJobResponseList(userJobResponseList), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
	}
	
}
