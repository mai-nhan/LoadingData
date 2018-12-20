package model;

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
	
}
