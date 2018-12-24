package com.ifisolution.loadingdata.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import com.ifisolution.loadingdata.common.ConvertDate;
import com.ifisolution.loadingdata.model.DatetimePa;
import com.ifisolution.loadingdata.model.Record;
import com.ifisolution.loadingdata.model.Sheet;

public class ReadFileExcel {
	private String filename;
	List<String> sheets;	
	public ReadFileExcel() {
		sheets=new ArrayList<>();	
		filename="D:\\intern\\javaifi\\eclipse_workspace\\LoadingData\\src\\main\\java\\data\\data.xls";
		/*try {
			setSheets();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public List<Record> getRecordByDate(String sheetName,String date) throws IOException{
		ArrayList<Record> records=new ArrayList<>();
		records.clear();
		FileInputStream inputStream = new FileInputStream(new File(filename));		  
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);	 
        HSSFSheet sheet = workbook.getSheet(sheetName);	                
	    Iterator<Row> rowIterator = sheet.iterator();
	    Record record; 	    
	    rowIterator.next();
	    while (rowIterator.hasNext()) {
	    	Row row=rowIterator.next();		    		    	
	    	if(ConvertDate.compareDate(row.getCell(0).getStringCellValue(),date)==0) {
	    		List<DatetimePa> datetimepa=new ArrayList<>();		    
	    	    float ps;
		    	for(int j=0;j<6;j++) {	
		    		String d="",pa="";
		    		d=row.getCell(j).getStringCellValue();						//get String Date    		
					pa=row.getCell(j+6).getStringCellValue();					//get String Pa		    		
		    		datetimepa.add(new DatetimePa(d,pa));
		    	}
		    	String s=row.getCell(12).getStringCellValue();		    			    	
		    	records.add(new Record(datetimepa,s));
	    	}
	    }	    
		return records;
	}
	public List<String> getSheets() throws IOException { 
		FileInputStream inputStream = new FileInputStream(new File(filename));		  
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);	 
        int numberSheet=workbook.getNumberOfSheets();
        for(int i=0;i<numberSheet;i++) sheets.add(workbook.getSheetName(i));
        return sheets;
	}
	public List<Record> getSheet(String sheetName) throws IOException{
		ArrayList<Record> records=new ArrayList<>();
		records.clear();
		FileInputStream inputStream = new FileInputStream(new File(filename));		  
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);	            // Đối tượng workbook cho file XSL.
        HSSFSheet sheet = workbook.getSheet(sheetName);	                    // Lấy ra sheet đầu tiên từ workbook        
	    Iterator<Row> rowIterator = sheet.iterator();						// Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
	    Record record; 	    
	    rowIterator.next();
	    while (rowIterator.hasNext()) {
    	Row row=rowIterator.next();		    	
    		List<DatetimePa> datetimepa=new ArrayList<>();		    
    	    float ps;
	    	for(int j=0;j<6;j++) {	
	    		String d="",pa="";
	    		d=row.getCell(j).getStringCellValue();						//get String Date    		
				pa=row.getCell(j+6).getStringCellValue();					//get String Pa		    		
	    		datetimepa.add(new DatetimePa(d,pa));
	    	}
	    	String s=row.getCell(12).getStringCellValue();		    			    	
	    	records.add(new Record(datetimepa,s));	    	
    	}
	    	    
		return records;
	}
//	public static void main(String []args) throws IOException, EvaluationException {
//		//List<Record> l=new ReadFileExcel().getRecordByDate("ENR062A3", "2016-10-24");
//		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		try {
//			Date d=simpleDateFormat.parse("2016-10-24 23:50:00+0000");
//			System.out.println(d);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
