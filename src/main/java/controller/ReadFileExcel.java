package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.atp.DateParser;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import model.DatetimePa;
import model.Record;
import model.Sheet;

public class ReadFileExcel {
	Sheet[] sheets;
	public ReadFileExcel() {
		sheets=new Sheet[3];		
	}
	public void setSheets() throws IOException{
		FileInputStream inputStream = new FileInputStream(new File("/home/fresher20/Downloads/fresher/data.xls"));		  
        // Đối tượng workbook cho file XSL.
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);	 
        // Lấy ra sheet đầu tiên từ workbook
        for(int i=0;i<3;i++) {
	        HSSFSheet sheet = workbook.getSheetAt(i);
	        sheets[i]=new Sheet();
	        sheets[i].setName(sheet.getSheetName());
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
		    	Iterator<Cell> cellIterator = row.cellIterator();
		    	for(int j=0;j<6;j++) {
		    		Cell cellDate=row.getCell(j);
		    		Cell cellPa=row.getCell(j+6);
		    		String temp=cellDate.getStringCellValue();
		    		System.out.println("column = "+j);
		    		Date date=new Date();
					try {
						date = DateParser.parseDate(temp).getTime();
					} catch (EvaluationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		float pa=(float) cellPa.getNumericCellValue();
		    		datetimepa[j]=new DatetimePa(date,pa);
		    	}
		    	ps=(float)row.getCell(12).getNumericCellValue();
		    	
		    	record=new Record(datetimepa,ps);
		    	records.add(record);
		    }
		    sheets[i].setListRecord(records);		
		    System.out.println("so luong ban ghi trong sheet "+sheet.getSheetName()+" = "+count);
        }
	}
	
	public Sheet[] getSheets() { return sheets;}
	public static void main(String []args) throws IOException, EvaluationException {
		new ReadFileExcel().setSheets();
	}
}
