package com.example.calldropanalyzer.service;

import com.example.calldropanalyzer.beans.Appel;
import com.example.calldropanalyzer.repository.AppelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppelService {

    private static final Logger logger = LoggerFactory.getLogger(AppelService.class);
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final DateFormat df = new SimpleDateFormat(DATE_FORMAT);

    @Autowired
    private AppelRepository appelRepository;

    public List<Appel> getAllCalls() {
        try {
            logger.info("Fetching all calls from repository");
            List<Appel> calls = appelRepository.findAll();
            logger.info("Found {} calls in repository", calls.size());
            if( calls.isEmpty()) {
                logger.warn("No calls found in the database");
            }
            return calls;
        } catch (Exception e) {

            logger.error("Error fetching all calls: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<Appel> getAppelsInterrompus(String startDate, String endDate)  {
        if (startDate == null || endDate == null){
            logger.error("Start date or end date is null implementation validation !");
            throw new IllegalArgumentException("Start date and end date must not be null");
        }

        Date start= null;   Date  end=null;
        try {
            logger.info("Parsing Date object types from API, validation of types and format before fetch from object implementation : startDate : {}  , endDate {}", startDate, endDate  );

            start  =  df.parse(startDate) ;
            end =df.parse(endDate);

            if (end.before(start)){         logger.error( "End Date {} before Start Date {} ",  endDate, startDate  );    throw new IllegalArgumentException("End date must be after start date");
            }


            logger.info(" fetching API from  data impl   by types / from   {}  to  {}  ", start , end )  ;
            List<Appel> appelList=  appelRepository.findByCallStartBetweenAndInterrupted(start,end,true);

            if (appelList.isEmpty()){       logger.warn ("Implementation validation types : No data available for  interrupted data for this date range from  {} to {}",  start,  end);        }


            return  appelList;


        } catch (ParseException e){   logger.error(" Error parsing  values data for date object type implementation {} "   , e.getMessage(), e);        start=new Date(124,1,1);  end=new Date()  ;
            return appelRepository.findByCallStartBetweenAndInterrupted(start,end,true );        }
        catch(Exception e)  {   logger.error("unknown data implementation type or configuration problem data object implementation  ", e.getMessage(),e) ; return   Collections.emptyList(); }
    }

    // Implementation also to see a total object
    public  List<Appel> getAppelsNonInterrompus(String startDate, String endDate)  {

        if( startDate==null || endDate== null ){
            logger.warn("Date is null , with data from parameters of object impl . Type settings validation fail  ");  return   Collections.emptyList()   ;}

        Date start = null ;Date  end=null;


        try {    logger.info ("Validate format string type with object and parsing  for non interrupted using date format {} - {}   ",  startDate  , endDate);
            start =   df.parse(startDate);
            end=   df.parse(endDate);
            if (end.before(start))  {    logger.warn(" end date before start date,  "   ,   startDate  ,  endDate);        }   // type data validation for a correct API impl

            return    appelRepository.findByCallStartBetweenAndInterrupted(start, end,false);    }
        catch(ParseException e ){
            logger.error( "Exception with parsing parameters object on implementations " ,e.getMessage(),  e)  ;     start= new  Date(124,1,1);
            end=   new Date();

            return  appelRepository.findByCallStartBetweenAndInterrupted(start , end,  false);
        }

        catch(Exception e) {

            logger.error( " Exception or unknown implementation parameters type to get data values non interrupted by API  " ,e.getMessage(), e) ;   return  Collections.emptyList();      }
    }


    public Map<String, Object> getCallAnalysisByZone(String startDate, String endDate)  {
        if (startDate == null || endDate == null)    {  logger.error("Invalid input data parameters for object implementation"); throw new IllegalArgumentException("Start and end date must be implemented with a String value with type for object parameters validation") ;} ;

        Date start=null; Date end = null;
        try { // also type check validation or data check with a try catch before fetch data for objects with method / or configuration types before query using SQL and database to implement your code logic with data.   When use default implementation, this is also  a good approach of testing data and type validations in project)
            logger.info( "Validating start and end time format before setting values from API fetch :   startDate = {} and Enddate {}", startDate , endDate);

            start = df.parse(startDate) ;
            end  =  df.parse(endDate);


            if ( end.before(start))    {    throw  new IllegalArgumentException("End Date must be a greater  than  startDate "  + startDate  + " : "   + endDate ) ;  };


            logger.info( "Fetching implementations with start date values  {}, enddate {}",    start  , end)   ;

            List<Appel> calls = appelRepository.findByCallStartBetweenAndInterrupted(start, end, true );    // only data objects you need are implemented ( with types check ) if you do not create  all object mapping you do avoid recursions

            Map<String, Object> analysis = new HashMap<>();  // new object for implementation
            Map<String, Integer> zoneStats = new HashMap<>();

            for (Appel call : calls)
            {
                String zoneName = (call.getZone() != null) ? call.getZone().getName() : "Unknown";   // if values exist as properties
                zoneStats.put(zoneName, zoneStats.getOrDefault(zoneName, 0) + 1);  // validate if value are well set

            }

            analysis.put("total_interrupted_calls",calls.size() ); // implement object and data validation (type)

            analysis.put("zoneStats",zoneStats);   // set other types  properties when they required with data


            return  analysis;
        }


        catch (ParseException e)  {   logger.error("Type Implementation error during data fetching with format data time :  ", e.getMessage(),e);    start =new Date(124,1,1);  end = new Date();
            return  Collections.emptyMap();  }

        catch( Exception e ){
            logger.error(   "Exception during API fetch of objects from  getCallAnalysisByZone :  ",e.getMessage()  ,e);
            return Collections.emptyMap()  ;

        }  // all type validation when API is called from fetch and that java implementation provide  a new list object data, before sending at browser for javascript object. Or implementation for framework data access

    }
}