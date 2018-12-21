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

import com.ifisolution.loadingdata.model.DatetimePa;
import com.ifisolution.loadingdata.model.Record;
import com.ifisolution.loadingdata.model.Sheet;

public class ReadFileExcel {
	List<Sheet> sheets;
	static SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss+0000");
	public ReadFileExcel() {
		sheets=new ArrayList<>();	
		try {
			setSheets();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setSheets() throws IOException{
		FileInputStream inputStream = new FileInputStream(new File("D:\\intern\\javaifi\\eclipse_workspace\\LoadingData\\src\\main\\java\\data\\data.xls"));		  
        // Đối tượng workbook cho file XSL.
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);	 
        // Lấy ra sheet đầu tiên từ workbook
        Sheet sh;
        HSSFSheet sheet;
        for(int i=0;i<3;i++) {
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
		    	records.add(record);
		    }
		    sh.setListRecord(records);		
		    sheets.add(sh);
		    System.out.println(" ban ghi trong sheet "+records.get(3).getDatetimepas()[0].getDate());
        }        
	}
	
	public List<Sheet> getSheets() { return sheets;}
//	public static void main(String []args) throws IOException, EvaluationException {
//		new ReadFileExcel().setSheets();
//	}
}
