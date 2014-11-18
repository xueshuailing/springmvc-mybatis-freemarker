package com.my.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gitchina.framework.commons.form.DoubleEditor;
import org.gitchina.framework.commons.form.FloatEditor;
import org.gitchina.framework.commons.form.LongEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


import com.alibaba.fastjson.JSON;

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
	
	@InitBinder  
    protected void initBinder(WebDataBinder binder) {  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));  
        binder.registerCustomEditor(Long.class, new LongEditor());  
        binder.registerCustomEditor(Double.class, new DoubleEditor());  
        binder.registerCustomEditor(Float.class, new FloatEditor());  
    } 
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
	public void outJSON(HttpServletResponse response,Object o) {
		try {
			response.setContentType("text/javascript;charset=UTF-8");
			PrintWriter out;
			out = response.getWriter();
			out.write(JSON.toJSONString(o));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("outJson："+e.getStackTrace());
		}
	}
	protected HttpSession getSession(HttpServletRequest request) {
		return request.getSession();
	}
	 
}