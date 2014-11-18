package com.my.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * springMVC基类
 *
 */
public class BaseController {
	private static final Logger logger =LoggerFactory.getLogger(BaseController.class);
		 
	/**
	 * 当前页
	 */
	protected int page = 1;
	/**
	 * 开始记录数
	 */
	protected int beginTotal = 1;

	/**
	 * 结束记录数
	 */
	protected int endTotal = 0;

	/**
	 * 所有记录数
	 */
	protected int total = 0;
	/**
	 * 每页记录数
	 */
	protected int rows = 0;
	
	 
	public void outJSON(HttpServletResponse response,String json) {
		try {
			response.setContentType("text/javascript;charset=UTF-8");
			PrintWriter out;
			out = response.getWriter();
			out.write(json);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("outJson："+e.getStackTrace());
		}
	}

	protected HttpSession getSession(HttpServletRequest request) {
		return request.getSession();
	}
	 
}