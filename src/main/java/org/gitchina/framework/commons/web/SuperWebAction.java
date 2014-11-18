package org.gitchina.framework.commons.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gitchina.framework.commons.utils.DateUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;


 
public class SuperWebAction {
	 
	@InitBinder
	protected void initBinder(WebDataBinder  binder) throws Exception {
		binder.setIgnoreInvalidFields(true); 
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(DateUtils.DEFAULT_DATETIME_FORMAT), true));
	}
	
	@ExceptionHandler
	public String exception(HttpServletRequest request, HttpServletResponse response, Exception exception) {
		/**request.setAttribute(SystemConstants.SYSTEM_CONFIGURE, getSystemConfigure());
		if (exception instanceof WeixinBroswerException) {
			request.setAttribute("error", exception.getMessage());
			return "module/error";
		}*/
		
		return "error/500";
	}
 
	
	 
	
	 
}
