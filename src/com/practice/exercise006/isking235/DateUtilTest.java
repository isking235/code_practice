package com.practice.exercise006.isking235;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testConvert() {
		
		DateUtil dateUtil = new DateUtil();
		Date now = new Date();
        String datetimeStr = now.toString();
		System.out.println("=testConvert()=");
		System.out.println(dateUtil.convert(datetimeStr));
	}

	@Test
	public void testAddDay() {
		//1. 3일 이후를 테스트
		DateUtil dateUtil = new DateUtil();
		Date date = new Date();
        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy/MM/dd");

        Date date3day = dateUtil.addDay(date, 3);
        
        String dayRealut = dayFormat.format(date3day);
        System.out.println("=testAddDay()=");
        System.out.println(dayRealut);
        
	}

	@Test
	public void testGetDateDiffInMsec() {
		//1. 3일 이후와 현재 차이를 구한다. 밀리세컨드 차이
		DateUtil dateUtil = new DateUtil();
		Date date = new Date();
		Date date3day = dateUtil.addDay(date, 3);
		
		long diff = dateUtil.getDateDiffInMsec(date3day,date );
        System.out.println("=testGetDateDiffInMsec()=");
        System.out.println(diff);
	}

	@Test
	public void testGetDateFromMsec() {
		//1. 
		DateUtil dateUtil = new DateUtil();
		Date date = new Date();
		Date date3day = dateUtil.addDay(date, 3);
		
		long diff = dateUtil.getDateDiffInMsec(date, date3day);
				
		String dateFromMsec = dateUtil.getDateFromMsec(diff);
		System.out.println("=testGetDateFromMsec()=");
		System.out.println(dateFromMsec);
	}

}
