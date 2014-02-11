package com.practice.exercise006.isking235;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

	public DateUtil() {
		
	}

	public Date convert(String source) {
		Date parsed = null;
		try {
			parsed = sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/*if (parsed != null) {
			return parsed;
		} else {
			return null;
		}*/
		return parsed; // 1. parsed는 초기값이 null이다.
	}

	public Date addDay(Date source, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(source);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public long getDateDiffInMsec(Date source, Date target) {
		/*long diffMSec = 0;
		diffMSec = source.getTime() - target.getTime();*/
		long diffMSec =  source.getTime() - target.getTime(); // 2. 선언과 동시에 대입
		return diffMSec;
	}

	public String getDateFromMsec(long diffMSec) {
		int left = 0;
		int ss = 0;
		int mm = 0;
		int hh = 0;
		int dd = 0;
		left = (int) (diffMSec / 1000);
		ss = left % 60;
		left = (int) left / 60;
		if (left > 0) {
			mm = left % 60;
			left = (int) left / 60;
			if (left > 0) {
				hh = left % 24;
				left = (int) left / 24;
				if (left > 0) {
					dd = left;
				}
			}
		} 
		String diff = Integer.toString(dd) + " " + Integer.toString(hh) + ":"
				+ Integer.toString(mm) + ":" + Integer.toString(ss);
		return diff;
	}
}
