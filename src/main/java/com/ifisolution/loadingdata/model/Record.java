package com.ifisolution.loadingdata.model;

import java.util.Arrays;
import java.util.List;

public class Record {
	
	private List<DatetimePa> datetimepas;
	private String ps;
	public Record() {}
	public Record(List<DatetimePa> datetimepas, String ps) {
		this.datetimepas = datetimepas;
		this.ps = ps;
	}
	public List<DatetimePa> getDatetimepas() {
		return datetimepas;
	}
	public void setDatetimepas(List<DatetimePa> datetimepas) {
		this.datetimepas = datetimepas;
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	@Override
	public String toString() {
		return "Record [datetimepas=" + datetimepas.toString() + ", ps=" + ps + "]";
	}
	
}
