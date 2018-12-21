package com.ifisolution.loadingdata.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {
	static SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss+0000");
	static SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd");
	public static Date convert(String date) {
		Date d=new Date();
		try {
			d=simpleDateFormat.parse(date);						
		} catch (ParseException e) {
			System.out.println("loi parse: ");
			e.printStackTrace();
		}
		return d;
	}
	
	public static int compareDate(String d1,String d2) {
		Date date1=convert(d1);
		return d2.compareTo(simpleDate.format(date1));
	}
}
