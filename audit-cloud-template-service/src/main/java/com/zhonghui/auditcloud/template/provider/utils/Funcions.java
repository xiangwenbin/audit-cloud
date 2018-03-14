package com.zhonghui.auditcloud.template.provider.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 
 * @author xwb
 *
 */
public class Funcions {
	public  static synchronized String generateOrderNum(Long uid)
	{
//		UUID uuid = UUID.randomUUID();
//		return uid+"-"+uuid.toString().replace("-", "").substring(0, 25);  
		String ordernum = "COMMUNITY"+getCurrentTimeStr()+uid;
		
        return ordernum;
	}
	public static String getCurrentTimeStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String curDate = sdf.format(new Date());
		
		return curDate;
	}
}
