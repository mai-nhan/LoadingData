package com.ifisolution.loadingdata.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ifisolution.loadingdata.dao.RecordDAO;
import com.ifisolution.loadingdata.model.Record;

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
<<<<<<< HEAD
    public List<Record> getRecords(@PathVariable("sheetName") String sheetName) throws IOException {
 
        System.out.println("(Service Side) get record by sheet: " + sheetName);
 
        return recordDao.getRecordByDate(sheetName, "2016-10-24");
=======
    public List<Record> getRecordByDate(@PathVariable("sheetName") String sheetName,@RequestParam(value="date", defaultValue="all") String date) throws IOException {
 
        System.out.println("(Service Side) get record by sheet and date: " + sheetName);
        if(date.equals("all")) return recordDao.getSheet(sheetName);
        return recordDao.getRecordByDate(sheetName, date);
>>>>>>> af1e6ebf60d4b3c0f0a9625cfee9904e3fa4ddfc
    }
	
	
}
