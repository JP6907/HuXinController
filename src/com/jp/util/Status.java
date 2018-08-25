package com.jp.util;

import java.util.HashMap;
import java.util.Map;

public class Status {
	
	private static Map<String,String> status = new HashMap<String,String>();
	
	static{
		status.put("led1", "on");
		status.put("led2", "off");
		status.put("source", "off"); //电源
		//System.out.println(leds.size());
	}
	
	public Status() {
	}
	public static void setStatus(String key,String value){
		System.out.println("设置状态：" + key + ":" + value);
		status.put(key, value);
	}
	
	public static Map<String,String> getStatus(){
		return status;
	}

}
