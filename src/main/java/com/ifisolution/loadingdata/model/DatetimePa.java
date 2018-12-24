package com.ifisolution.loadingdata.model;

import java.util.Date;

public class DatetimePa {
	private String date;
	private String pa;
	public DatetimePa() {}
	
	public DatetimePa(String date, String pa) {
		super();
		this.date = date;
		this.pa = pa;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPa() {
		return pa;
	}

	public void setPa(String pa) {
		this.pa = pa;
	}

	@Override
	public String toString() {
		return "[date=" + date + ", pa=" + pa + "]";
	}
	
	
}
