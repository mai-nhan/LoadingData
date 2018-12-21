package com.ifisolution.loadingdata.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ifisolution.loadingdata.model.Record;
import com.ifisolution.loadingdata.model.Sheet;

@Repository
public class RecordDAO {
	private static ReadFileExcel readfile=new ReadFileExcel();
	private static List<Record> listRecord=new ArrayList<Record>();
	private static Map<String, Sheet> mapSheet=new HashMap<String, Sheet>(); 
	
	static {
		init();
	}
	private static void init() {
		List<Sheet> sheets=readfile.getSheets();
		System.out.println("so luong sheet="+sheets.size());
		for(Sheet s:sheets) {
			System.out.println(s.getName());
			mapSheet.put(s.getName(), s);
		}
		//listRecord=
	}
	public List<Record> getRecords(String sheetName){
		return mapSheet.get(sheetName).getListRecord();
	}
	
}
