package com.hpfs.distillery.retailer.utils;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class UTIL {

    public static Timestamp stringToTimestamp( String date)
    {
       if (date !=null && date.length()>0) {
           try {
               SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
               Date dateFormat = sdf.parse(date);
               Timestamp ts = new Timestamp(dateFormat.getTime());
               return ts;
           } catch (ParseException e) {
               e.printStackTrace();
           }
       }
      return null;
    }

    public static String timestampToString(Timestamp ts)
    {
        if (ts!=null) {
            Date date = new Date();
            date.setTime(ts.getTime());
            String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
            return formattedDate;
        }
        return null;
    }
}
