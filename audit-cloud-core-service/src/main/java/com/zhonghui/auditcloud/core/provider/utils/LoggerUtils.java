package com.zhonghui.auditcloud.core.provider.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {

	private static final Logger ACCESS_LOG = LoggerFactory.getLogger("accessLogger");

	private static final Logger RUN_LOG = LoggerFactory.getLogger("runLogger");

	private static final Logger ERROR_LOG = LoggerFactory.getLogger("errorLogger");

	public static final void errorlog(String msg){
		ERROR_LOG.error(msg);
	}
	
	public static final void errorlog(String msg,Exception e){
		ERROR_LOG.error(msg,e);
	}
	public static final void runlog(String msg){
		RUN_LOG.info(msg);
	}
	public static final void accessLog(String msg){
		ACCESS_LOG.info(msg);
	}
}
