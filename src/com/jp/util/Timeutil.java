package com.jp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ʱ�乤����
 * @author Administrator
 *
 */
public class Timeutil {
	/**
	 * ��ȡ��ǰʱ��
	 * @return
	 */
	public static String getCurrentTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}
}
