package com.example.calldropanalyzer.service;

import com.example.calldropanalyzer.beans.Appel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReportService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ReportService.class);
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final DateFormat df = new SimpleDateFormat(DATE_FORMAT);

    @Autowired
    private AppelService appelService;

    public String generateCallReport(String startDate, String endDate)   {
        try{

            StringBuilder  report=new StringBuilder();
            report.append("<h1>Call Drop Analysis Report </h1>  <br><br>" )   ;// basic test data that we map also
            List<Appel> appels = appelService.getAppelsInterrompus(startDate, endDate);

            if (appels.isEmpty()){  return  "No  data for implementation type : range : "   + startDate + " :  "   +endDate ;  }


            report.append("<h2>Interrupted Calls from ").append(startDate).append(" to ").append(endDate).append("</h2>  <br> <hr>" );
            for (Appel appel : appels) {
                report.append("Call ID: ").append(appel.getId()).append("<br>");
                report.append("Caller: ").append(appel.getCaller()).append("<br>");
                report.append("Date Time: ").append(df.format(appel.getCallStart())).append("<br>");
                if (appel.getZone() != null) report.append("Zone: ").append(appel.getZone().getName()).append("<br>");
                report.append("Interrupted: ").append(appel.isInterrupted()).append("<br>");
                report.append("<hr><br>");
            }; // basic code mapping data with types ( and that all properties and html types and values should be all valid at object level before display)

            return   report.toString();    }
catch (Exception e){
            return "Exception type data mapping or configuration :" + e.getMessage();
        }

    }
    public Map<String, Object> getCallAnalysisByZone(String startDate, String endDate)  {
        if (startDate == null || endDate == null){   logger.error("Error with data object implementation from parameter settings  null values " , startDate  , endDate );   throw new IllegalArgumentException("Start and end date must not be null");   }; // error if object validation fail to get a value before setting on other objects

        Date start= null;  Date end=null;

        try{

            logger.info( "Valid implementation settings : fetching implementation data for api objects getCallAnalysisByZone with date values  {} - {}", startDate, endDate);

            start  =   df.parse(startDate);
            end= df.parse(endDate);

            if(end.before(start) ){
                logger.error("data validation problem implementation , data for parameters objects where wrong: end before start"  ,    endDate,  startDate)   ;
                throw new IllegalArgumentException("End Date must be a after Start Date") ;        };

            logger.info("Fetching objects from API type implementation with start and end   {} :   {}", start , end)   ;


            List<Appel> calls  = appelService.getAppelsInterrompus(startDate, endDate ); // that validate the parameter for types and object accessors ( data)

            Map<String, Object> analysis = new HashMap<>();

            Map<String, Integer> zoneStats= new HashMap<>(); // local object to configure types


            for (Appel call :calls){
                String zoneName = (call.getZone()!=null) ? call.getZone().getName() : "Unknown"; zoneStats.put(zoneName , zoneStats.getOrDefault(zoneName,0)+ 1 ) ; } // map object value by valid implementation by setting defaults also

            analysis.put("total_interrupted_calls",calls.size());   analysis.put(  "zoneStats" ,zoneStats);   // validation if those data type  object properties values exists if not set defaults


            return  analysis ;

        }    catch ( ParseException  e ){   logger.error( " Error at parsing  data from object types setting implementations at java API ",    e.getMessage(),e);  start =new Date(124,1,1);       end =  new Date()   ;
            return  Collections.emptyMap();       } // set defaults values during type validation object if fetch api have incorrect data values also during mapping or when creating a valid object with attributes to be mapped

        catch ( Exception  e ){     logger.error(" Exception object type properties error data fetching or configurations during api for  getCallAnalysisByZone data",    e.getMessage(),e);   return Collections.emptyMap() ;         }

    }
}