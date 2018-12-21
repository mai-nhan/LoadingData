package com.ifisolution.loadingdata.model;

import java.util.Arrays;

public class Record {
	
	private DatetimePa[] datetimepas;
	private float ps;
	public Record() {}
	public Record(DatetimePa[] datetimepas, float ps) {
		this.datetimepas = datetimepas;
		this.ps = ps;
	}
	public DatetimePa[] getDatetimepas() {
		return datetimepas;
	}
	public void setDatetimepas(DatetimePa[] datetimepas) {
		this.datetimepas = datetimepas;
	}
	public float getPs() {
		return ps;
	}
	public void setPs(float ps) {
		this.ps = ps;
	}
	@Override
	public String toString() {
		return "Record [datetimepas=" + datetimepas[0].toString()+", "+ datetimepas[1].toString() + ", ps=" + ps + "]";
	}
	
}
