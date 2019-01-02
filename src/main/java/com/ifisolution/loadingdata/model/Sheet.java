package com.ifisolution.loadingdata.model;

import java.util.ArrayList;
import java.util.List;

public class Sheet {
	private String name;
	private List<Float> listPa;
	private List<String> date;
	
	public Sheet() {
		listPa=new ArrayList<Float>();
		date=new ArrayList<String>();
	}

	public Sheet(String name,List<Float> listPa,List<String> date) {
		super();
		this.name = name;
		this.listPa = listPa;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Float> getListPa() {
		return listPa;
	}

	public void setListPa(ArrayList<Float> listPa) {
		this.listPa = listPa;
	}

	public List<String> getDate() {
		return date;
	}

	public void setDate(ArrayList<String> date) {
		this.date = date;
	}
	
	
}
