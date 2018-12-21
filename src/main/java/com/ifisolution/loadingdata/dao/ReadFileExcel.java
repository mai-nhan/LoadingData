package com.ifisolution.loadingdata.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.atp.DateParser;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.format.datetime.joda.DateTimeParser;

import com.ifisolution.loadingdata.common.ConvertDate;
import com.ifisolution.loadingdata.model.DatetimePa;
import com.ifisolution.loadingdata.model.Record;
import com.ifisolution.loadingdata.model.Sheet;

public class ReadFileExcel {
	private String filename;
	List<String> sheets;	
	public ReadFileExcel() {
		sheets=new ArrayList<>();	
		filename="/home/fresher20/eclipse-workspace/LoadingData/src/main/java/data/data.xls";
		/*try {
			setSheets();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	/*public void setSheets() throws IOException{
		FileInputStream inputStream = new FileInputStream(new File(filename));		  
        // Đối tượng workbook cho file XSL.
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);	 
        // Lấy ra sheet đầu tiên từ workbook
        Sheet sh;
        HSSFSheet sheet;
        for(int i=0;i<1;i++) {
	        sheet = workbook.getSheetAt(i);	
	        sh=new Sheet();
	        sh.setName(sheet.getSheetName());
	        ArrayList<Record> records=new ArrayList<>();
		    // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
		    Iterator<Row> rowIterator = sheet.iterator();
		    int count=0;
		    Record record; 
		    DatetimePa[] datetimepa=new DatetimePa[6];		    
		    float ps;
		    rowIterator.next();
		    while (rowIterator.hasNext()) {
		    	count++;
		    	Row row=rowIterator.next();		    	
		    	String s="";
		    	for(int j=0;j<6;j++) {
		    		Cell cellDate=row.getCell(j);
		    		Cell cellPa=row.getCell(j+6);
		    		s=cellDate.getStringCellValue();		    		
		    		Date date=new Date();
					try {
						date=simpleDateFormat.parse(s);						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						System.out.println("loi parse: ");
						e.printStackTrace();
					}
					s=cellPa.getStringCellValue();
		    		float pa=Float.parseFloat(s.substring(0, s.length()-2));
		    		datetimepa[j]=new DatetimePa(date,pa);
		    	}
		    	s=row.getCell(12).getStringCellValue();
		    	ps=Float.parseFloat(s.substring(0, s.length()-2));
		    	
		    	record=new Record(datetimepa,ps);
		    	System.out.println(count+" = "+record.toString());
		    	records.add(record);
		    }
		    System.out.println("sheet = "+sh.getName()+": so ban ghi = "+records.size());
		    sh.setListRecord(records);	
		    
		    sheets.add(sh);		    
        }
        workbook.close();
	}*/
	public List<Record> getRecordByDate(String sheetName,String date) throws IOException{
		List<Record> records=new ArrayList<>();
		FileInputStream inputStream = new FileInputStream(new File(filename));		  
        // Đối tượng workbook cho file XSL.
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);	 
        // Lấy ra sheet đầu tiên từ workbook        
        HSSFSheet sheet = workbook.getSheet(sheetName);	                
	    // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
	    Iterator<Row> rowIterator = sheet.iterator();
	    int count=0;
	    Record record; 
	    DatetimePa[] datetimepa=new DatetimePa[6];		    
	    float ps;
	    rowIterator.next();
	    while (rowIterator.hasNext()) {
	    	Row row=rowIterator.next();		    	
	    	String s="";
	    	if(ConvertDate.compareDate(date, row.getCell(0).getStringCellValue())!=0) continue;
	    	for(int j=0;j<6;j++) {	    			    		
	    		s=row.getCell(j).getStringCellValue();						//get String Date    		
	    		Date d=ConvertDate.convert(s);				    		
				s=row.getCell(j+6).getStringCellValue();					//get String Pa
	    		float pa=Float.parseFloat(s.substring(0, s.length()-2));
	    		datetimepa[j]=new DatetimePa(d,pa);
	    	}
	    	s=row.getCell(12).getStringCellValue();
	    	ps=Float.parseFloat(s.substring(0, s.length()-2));
	    	
	    	record=new Record(datetimepa,ps);
	    	System.out.println(count+" = "+record.toString());
	    	records.add(record);
	    }
		return records;
	}
	public List<String> getSheets() throws IOException { 
		FileInputStream inputStream = new FileInputStream(new File(filename));		  
        // Đối tượng workbook cho file XSL.
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);	 
        // Lấy ra sheet đầu tiên từ workbook   
        int numberSheet=workbook.getNumberOfSheets();
        for(int i=0;i<numberSheet;i++) sheets.add(workbook.getSheetName(i));
        return sheets;
	}
//	public static void main(String []args) throws IOException, EvaluationException {
//		new ReadFileExcel().setSheets();
//	}
}
