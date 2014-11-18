package com.weixin.utils;

import java.io.IOException;

import com.google.gson.Gson;
 
public class JsonUtils {

	private static Gson gson = null;
	/**
	 * 通过单例获取gson
	 * @return
	 */
	public static Gson getGson(){
		if(gson==null){
			return new Gson();
		}
		return gson;
	}

	/**
	 * 把java对象转换为JSON
	 * @param obj 要转换的对象
	 * @return
	 * @throws IOException 
	 */
	public static String toJson(Object obj){
		return getGson().toJson(obj);
	}
	
}
