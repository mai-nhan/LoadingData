package com.ifisolution.loadingdata.model;

import java.util.ArrayList;
import java.util.List;

public class Sheet {
	private String name;
	private List<Record> listRecord;
	
	public Sheet() {
		listRecord=new ArrayList<>();
	}

	public Sheet(String name, ArrayList<Record> listRecord) {		
		this.name = name;
		this.listRecord = listRecord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Record> getListRecord() {
		return listRecord;
	}

	public void setListRecord(ArrayList<Record> listRecord) {
		this.listRecord = listRecord;
	}
	
	
}
