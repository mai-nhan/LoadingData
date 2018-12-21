package com.ifisolution.loadingdata.dao;

import java.io.IOException;
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
	//private static Map<String, Sheet> mapSheet=new HashMap<String, Sheet>(); 
	
	static {
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void init() throws IOException {
		List<String> sheets=readfile.getSheets();
		System.out.println("so luong sheet="+sheets.size());
		for(String s:sheets) {
			System.out.println("sheet"+s);
			//mapSheet.put(s, s);
		}
		//listRecord=
	}
	public List<Record> getRecordByDate(String sheetName,String date) throws IOException{
		return readfile.getRecordByDate(sheetName, date);
	}
	
}
