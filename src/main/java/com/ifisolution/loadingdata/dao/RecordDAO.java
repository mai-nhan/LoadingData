package com.ifisolution.loadingdata.dao;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import java.util.Collections;
import java.util.Comparator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.ifisolution.loadingdata.common.ConvertDate;
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
		
	}
	public List<String> getSheetName() throws IOException{
		return readfile.getSheets();
	}
	public List<Record> getRecordByDate(String sheetName,String date) throws IOException{
		List<Record> l=readfile.getRecordByDate(sheetName, date);
		for(Record r:l) System.out.println(r.toString());
		return l; 
	}
	public List<Record> getSheet(String sheetName) throws IOException{
		List<Record> l=readfile.getSheet(sheetName);
		//for(Record r:l) System.out.println(r.toString());
		return l; 
	}
	public float getPaPerDay(String sheetName,String date) throws IOException {
		float paPerDay=0;
		List<Record> l=readfile.getRecordByDate(sheetName, date);
		for(Record record:l) {
			String pa=record.getDatetimepas().get(0).getPa();
			paPerDay+=convertPa(pa);
		}
		return paPerDay/6;
	}

	public Sheet getPaPerDays(String sheetName) throws IOException{

		List<Float> listPPD=new ArrayList<>();
		List<String> listDate=new ArrayList<>();
		Map<String,Float> map=new HashMap<>();
		int count=0;
		List<Record> listRecord=readfile.getSheet(sheetName);
		for(Record record:listRecord) {
			count++;
			//lay ngay
			String date=ConvertDate.formatDate(record.getDatetimepas().get(0).getDate());
			
			//kiem tra ngay ? map.put()
			if(!map.containsKey(date)) {
				System.out.println("date="+date);
				map.put(date, convertPa(record.getDatetimepas().get(0).getPa()));
			}
			else {
				float temp=map.get(date);
				temp+=convertPa(record.getDatetimepas().get(0).getPa());
				map.put(date, temp);
			}
			
		}				
		for(String s:map.keySet()) listDate.add(s);
		Collections.sort(listDate,new Comparator<String>() {
			public int compare(String o1, String o2) { 
				return o1.compareToIgnoreCase(o2); 
		    }
		});
		for(String s:listDate) {
			listPPD.add(map.get(s));			
		}

		return (new Sheet(sheetName,listPPD,listDate));

	}
	public float convertPa(String pa) {
		return Float.parseFloat(pa.substring(0, pa.length()-2));
	}
}
