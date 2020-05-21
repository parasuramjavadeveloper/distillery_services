package com.hpfs.distillery.retailer.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static String DateToString() {
        Date date = Calendar.getInstance().getTime();
        String strDate = new SimpleDateFormat(ApplicationConstants.DOT_FORMAT).format(date);
        logger.info("DateToString Format" + strDate);
        return strDate;
    }

    public static Date getDateFromString(String anyStringDate) throws ParseException {
        if(anyStringDate != null) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date anyDate = dateFormat.parse(anyStringDate);
            return anyDate;
        }
        else {
            return null;
        }
    }

    public static String getDateAsString(Date anyDate) {
        if(anyDate!=null)
        {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ssZ");
            String dateAddedOn = dateFormat.format(anyDate);
            return dateAddedOn;
        }
        else
        {
            return null;
        }
    }
    public static String LastThirtyDaysDateToString() {
    	Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH,-1);
        Date date = cal.getTime();
        String strDate = new SimpleDateFormat(ApplicationConstants.OT_FORMAT).format(date);
        logger.info("Last 30 Days Date Format" + strDate);
        return strDate;
    }
    
    }
