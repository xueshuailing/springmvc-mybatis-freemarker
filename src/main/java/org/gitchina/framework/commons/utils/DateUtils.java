/*
 * DateUtils.java 2012-7-26 上午10:48:53
 * Copyright 2012 北龙中网（北京）科技有限责任公司. All rights reserved.
 */
package org.gitchina.framework.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类.
 * 
 */
public class DateUtils {
	/** 日期格式 */
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	/** 日期时间格式 */
	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/** 时间格式 */
	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
	
	public static Calendar calendar = Calendar.getInstance();
	
	/**
	 * 将<tt>Date</tt>转换成<tt>String</tt>,使用年月日小时分钟秒格式.
	 * 
	 * @param date yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String format(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(
				DateUtils.DEFAULT_DATETIME_FORMAT);
		return format.format(date);
	}
	
	public static String format(Date date, String formar) {
		SimpleDateFormat format = new SimpleDateFormat(formar);
		return format.format(date);
	}

	/**
	 * 将<tt>String</tt>转换成<tt>Date</tt>,使用年月日小时分钟秒格式.
	 * 
	 * @param source
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static Date parse(String source) {
		SimpleDateFormat format = new SimpleDateFormat(
				DateUtils.DEFAULT_DATETIME_FORMAT);
		try {
			return format.parse(source);
		} catch (ParseException e) {
			format = new SimpleDateFormat(DateUtils.DEFAULT_DATE_FORMAT);;
			try {
				return format.parse(source);
			} catch (ParseException e1) {
				return null;
			}
		}
	}

	/**
	 * 将<tt>String</tt>转换成<tt>Date</tt>,使用指定格式. 如果转换异常,返回null.
	 * 
	 * @param source
	 * @param formar
	 * @return 
	 */
	public static Date parse(String source, String formar) {
		SimpleDateFormat format = new SimpleDateFormat(formar);
		try {
			return format.parse(source);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 将日期增加/减少指定天数.
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, day);
		return cal.getTime();
	}
	
	/**
	 * 将日期增加/减少指定小时.
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addHour(Date date, int hour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, hour);
		return cal.getTime();
	}
	
	/**
	 * 将日期增加/减少指定分钟.
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addMinute(Date date, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minute);
		return cal.getTime();
	}
	
	/**
	 * 将日期增加/减少指定秒.
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addSecond(Date date, int second) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, second);
		return cal.getTime();
	}

	/**
	 * 以友好的方式显示时间信息.
	 * @param time
	 * @return
	 */
	public static String friendlyDate(Date time) {
		if(time == null)  
			return "未知";
		
		int ct = (int)((System.currentTimeMillis() - time.getTime()) / 1000);
		
		if (ct < 3600) {
			return Math.max(ct / 60,1) + "分钟以前";
		}
			
		if (ct >= 3600 && ct < 86400) {
			return (ct / 3600) + "小时以前";
		}
			
		if (ct >= 86400 && ct < 2592000) { //86400 * 30
			int day = ct / 86400 ;
			if (day > 1) {
				return day + "天以前";
			}
			return "昨天";
		}
		
		if (ct >= 2592000 && ct < 31104000) { //86400 * 30
			return (ct / 2592000) + "月以前";
		}
		
		return (ct / 31104000) + "年以前";		
	}
	
	/**
	 * @return 返回当前年
	 */
	public static int getYear() {
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * @return 返回当前月
	 */
	public static int getMonth() {
		return calendar.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * @return 返回当前天
	 */
	public static int getDay() {
		return calendar.get(Calendar.DATE);
	}
	
	/**
	 * @return 返回当前小时
	 */
	public static int get24Hour() {
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * @return 返回当前分钟
	 */
	public static int getMinute() {
		return calendar.get(Calendar.MINUTE);
	}
	
	/**
	 * @return 返回当前秒
	 */
	public static int getSecond() {
		return calendar.get(Calendar.SECOND);
	}
	
	/**
	 * @return 返回当前时间星期几.
	 */
	public static int getWeek() {
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		return  (week == 1) ? 7 : week - 1;
	}
	
	public static long getMillis(String date) {
		return DateUtils.parse(date).getTime();
	}
	
	public static Date randomDate(String beginDate) {
		return randomDate(beginDate, DateUtils.format(new Date()));
	}
	
	public static Date randomDate(String beginDate, String endDate) {
		long start = DateUtils.getMillis(beginDate);
		long end = DateUtils.getMillis(endDate);
				
		if (start >= end) {
			return null;
		}
		long date = randomTime(start, end);
		return new Date(date);
	}
	
	private static long randomTime(long begin, long end) {
		long rtn = begin + (long) (Math.random() * (end - begin));
		// 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
		if (rtn == begin || rtn == end) {
			return randomTime(begin, end);
		}
		return rtn;
	}
	
	public static Date getToday(int hour, int minute, int second) {
		Calendar calendar = Calendar.getInstance(); 
	    calendar.set(Calendar.HOUR_OF_DAY, hour);   
	    calendar.set(Calendar.MINUTE, minute);   
	    calendar.set(Calendar.SECOND, second);   
	    //calendar.set(Calendar.MILLISECOND, 0);
	    
	    return calendar.getTime();
	}
}
