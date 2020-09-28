package com.qa.springboot.utils;

import java.util.UUID;

public class UUIDUtils {
	/*
	 * 返回唯一的标识符
	 */
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		str = str.replace("-", "");
		return str;
	}
}
