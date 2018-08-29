package com.principal.uberization.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.principal.uberization.controller.AppController;

public class LoggerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggerService.class);
	public static void LoggerMethodEntry(String className, String methodName){
		LOGGER.info("Class:"+className+" METHOD entry :"+methodName);
	}
}

