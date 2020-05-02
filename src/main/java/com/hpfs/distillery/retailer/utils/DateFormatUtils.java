package com.hpfs.distillery.retailer.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateFormatUtils.class);

    public static String DateToString() {
        Date date = Calendar.getInstance().getTime();
        String strDate = new SimpleDateFormat(ApplicationConstants.DOT_FORMAT).format(date);
        logger.info("DateToString Format" + strDate);
        return strDate;
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
