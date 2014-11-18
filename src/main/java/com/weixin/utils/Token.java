package com.weixin.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.weixin.bean.TokenBean;
public class Token {
	public static String TOKEN = "d6mmF0UM4l9T5YxeVwWm_4vfWmy0UoKukZVIti0oHAhReS7QqDDdK83Dvz22R1iOEyRz2JPP3HGcJH18Py71ZQ";

	/**
	 * 获得ACCESS_TOKEN
	 * 
	 * @Title: getAccess_token
	 * @Description: 获得ACCESS_TOKEN
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String getAccessToken() {
		String APPID = "wxdf2be4d5a2a32609";
		String APPSECRET = "67343b182127e4769c90bd31b4fc3038";
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
				+ APPID + "&secret=" + APPSECRET;
		try {
			URL urlGet = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlGet
					.openConnection();

			http.setRequestMethod("GET"); // 必须是get方式请求
			http.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
			http.connect();

			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			String message = new String(jsonBytes, "UTF-8");

			TokenBean b=JsonUtils.getGson().fromJson(message, TokenBean.class);
			return b.getAccess_token();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Token.TOKEN;
	}
	public static void main(String[] args) {
		String token=getAccessToken();
		System.out.println(token);
	}
}
