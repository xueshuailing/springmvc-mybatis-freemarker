package com.weixin.utils;

import java.util.ArrayList;
import java.util.List;

import com.weixin.bean.ButtonAttBean;
import com.weixin.bean.ButtonBean;
import com.weixin.constant.Constant;


public class WeixinUtils {
	/**
	 * 创建菜单url
	 */
	private static final String CREATE_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	/**
	 * 查询菜单url
	 */
	private static final String GET_URL="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
	/**
	 * 删除菜单url
	 */
	private static final String DELETE_URL="https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";
	/**
	 * 发送客服消息url
	 */
	private static final String SEND_CUSTOMER_MSG_URL="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";
	/**
	 * 创建菜单
	 * @param params
	 * @param accessToken
	 */
	public static String createMenu(String url, String params) {
			String result=HttpClient.createHttp(url,params);
			System.out.println(result);
			return result;
	}
	/**
	 * 查询菜单
	 * @param accessToken
	 */
	public static String getMenu(String url) {
		String result=HttpClient.createHttp(url);
		System.out.println(result);
		return result;
	}
	/**
	 * 删除菜单
	 * @param accessToken
	 */
	public static String delMenu(String url) {
		String result=HttpClient.createHttp(url);
		System.out.println(result);
		return result;
	}
	/**
	 * 发送客服消息
	 * @param accessToken
	 */
	public static String sendCustomerMsg(String url,String param) {
		String result=HttpClient.createHttp(url,param);
		System.out.println(result);
		return result;
	}
	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		List<ButtonAttBean> button=new ArrayList<ButtonAttBean>();
		ButtonAttBean b=new ButtonAttBean();
		b.setName("我的账号");
		b.setType(Constant.BUTTON_CLICK);
		b.setKey("KEY_101");
		ButtonAttBean c=new ButtonAttBean();
		c.setName("我的动态");
		c.setType(Constant.BUTTON_CLICK);
		c.setKey("KEY_102");
		button.add(b);
		button.add(c);
		List<ButtonAttBean> son=new ArrayList<ButtonAttBean>();
		ButtonAttBean e=new ButtonAttBean();
		e.setName("搜索");
		e.setType(Constant.BUTTON_VIEW);
		e.setUrl("http://www.baidu.com");
		ButtonAttBean f=new ButtonAttBean();
		f.setName("视频");
		f.setType(Constant.BUTTON_VIEW);
		f.setUrl("http://www.google.com");
		ButtonAttBean g=new ButtonAttBean();
		g.setName("赞一下我们");
		g.setType(Constant.BUTTON_CLICK);
		g.setKey("KEY_103");
		son.add(e);
		son.add(f);
		son.add(g);
		ButtonAttBean d=new ButtonAttBean();
		d.setName("我的菜单");
		d.setSub_button(son);
		button.add(d);
		ButtonBean bb=new ButtonBean();
		bb.setButton(button);
		System.out.println(JsonUtils.toJson(bb));
		String s = "{\"button\":[{\"name\":\"我的账户\",\"sub_button\":[{\"type\":\"click\",\"name\":\"账户绑定\",\"key\":\"M1001\"},{\"type\":\"click\",\"name\":\"我的资产\",\"key\":\"M1002\"}]},{\"type\":\"click\",\"name\":\"我的资产\",\"key\":\"M2001\"},{\"type\":\"click\",\"name\":\"其它\",\"key\":\"M3001\"}]}";
		//createMenu(CREATE_URL, JsonUtils.toJson(bb));
		getMenu(GET_URL);
		//delMenu(DELETE_URL);
		//String msg = "{ \"touser\":\"OPENID\",\"msgtype\":\"text\",\"text\":{ \"content\":\"Hello World\"}}";
		//sendCustomerMsg(SEND_CUSTOMER_MSG_URL,msg);
	}
}
