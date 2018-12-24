package com.ifisolution.loadingdata.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {
	static SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd");
	public static Date convert(String date) {
		Date d=null;
		try {
			d=simpleDateFormat.parse(date);						
		} catch (ParseException e) {
			System.out.println("loi parse: ");
			e.printStackTrace();
		}
		return d;
	}
	
	public static int compareDate(String d1,String d2) {		
		return d2.compareTo(simpleDate.format(convert(d1)));
	}
}
