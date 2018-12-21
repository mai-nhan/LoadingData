package com.ifisolution.loadingdata.model;

import java.util.Date;

public class DatetimePa {
	private Date date;
	private float pa;
	public DatetimePa() {}
	public DatetimePa(Date date, float pa) {
		this.date = date;
		this.pa = pa;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getPa() {
		return pa;
	}
	public void setPa(float pa) {
		this.pa = pa;
	}
	
	
}
