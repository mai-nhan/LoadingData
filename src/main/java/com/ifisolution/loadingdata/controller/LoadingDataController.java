package com.ifisolution.loadingdata.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ifisolution.loadingdata.dao.RecordDAO;
import com.ifisolution.loadingdata.model.Record;
import com.ifisolution.loadingdata.model.Sheet;

@RestController
@RequestMapping("/services")
public class LoadingDataController {
	@Autowired
	private RecordDAO recordDao;
	
	@RequestMapping(value ="/records/{sheetName}",
			method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody

    public List<Record> getRecordByDate(@PathVariable("sheetName") String sheetName,@RequestParam(value="date", defaultValue="all") String date) throws IOException {
 
        System.out.println("(Service Side) get record by sheet and date: " + sheetName);
        if(date.equals("all")) return recordDao.getSheet(sheetName);
        return recordDao.getRecordByDate(sheetName, date);

    }
	
	@RequestMapping(value ="/pa_weekly/{sheetName}",
			method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody

    public Sheet getPaPerDay(@PathVariable("sheetName") String sheetName) throws IOException {
 
        System.out.println("(Service Side) get pa by sheet : " + sheetName);
        System.out.println("test pa ngay 24-10="+recordDao.getPaPerDay(sheetName, "2016-10-24"));
        return recordDao.getPaPerDays(sheetName);

    }
	@RequestMapping(value ="/pa_weekly/",
			method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<String> getSheetName() throws IOException {        
        return recordDao.getSheetName();

    }
	
	
}
