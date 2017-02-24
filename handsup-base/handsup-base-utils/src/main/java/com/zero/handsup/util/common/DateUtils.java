package com.zero.handsup.util.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtils {
	
	public final static DateFormat NORMAL_DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			return format(date, formatter);
		} catch(Exception e) {
			return NORMAL_DATE_FORMATTER.format(date);
		}
	}
	
	/**
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String format(Date date, DateFormat format) {
			return format.format(date);
	}
	
	public static String format(long date, String pattern) {
		return format(new Date(date), pattern);
	}
	
}
