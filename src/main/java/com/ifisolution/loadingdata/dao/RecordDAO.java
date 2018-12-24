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
		List<Record> l=readfile.getRecordByDate(sheetName, date);
<<<<<<< HEAD
		for(Record r:l) System.out.println(r.toString());
=======
		//for(Record r:l) System.out.println(r.toString());
		return l; 
	}
	public List<Record> getSheet(String sheetName) throws IOException{
		List<Record> l=readfile.getSheet(sheetName);
		//for(Record r:l) System.out.println(r.toString());
>>>>>>> af1e6ebf60d4b3c0f0a9625cfee9904e3fa4ddfc
		return l; 
	}
}
