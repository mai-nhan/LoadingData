package model;

import java.util.ArrayList;

public class Sheet {
	private String name;
	private ArrayList<Record> listRecord;
	
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

	public ArrayList<Record> getListRecord() {
		return listRecord;
	}

	public void setListRecord(ArrayList<Record> listRecord) {
		this.listRecord = listRecord;
	}
	
	
}
