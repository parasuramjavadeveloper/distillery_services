package com.hpfs.distillery.retailer.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.hpfs.distillery.retailer.model.TblWallet;

import au.com.bytecode.opencsv.CSVReader;  

@Component
public class CsvUtils {
    private static final CsvMapper mapper = new CsvMapper();
    public static <T> List<T> read(Class<T> clazz, InputStream stream) throws IOException {
        CsvSchema schema = mapper.schemaFor(clazz).withHeader().withColumnReordering(true);
        ObjectReader reader = mapper.readerFor(clazz).with(schema);
        return reader.<T>readValues(stream).readAll();
    }
    
    
    //Read CSV data of Wallet and Save data into the DB
    
    public static List<TblWallet> readCSVWalletData() throws NumberFormatException, IOException {
    //public static void main(String[] args) throws IOException {	
    List<TblWallet> walletList = new ArrayList<>();
    	//parsing a CSV file into Scanner class constructor  
    String line = "";  
    BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\wallet.csv"));  
    while ((line = br.readLine()) != null) {  //returns a Boolean value  
	   	TblWallet wallet1 = new TblWallet();
	    String[] wallet = line.split(ApplicationConstants.DELIMITER);    // use comma as separator  
	    System.out.println("Wallet [UserId=" + wallet[0] + ", Tax ref Num=" + wallet[1] + ", Wallent amount=" + wallet[2] + ", Date= " + wallet[3] +"]");  
	    wallet1.setUserId(Long.valueOf(wallet[0]));
	    wallet1.setTxnRefNum(Long.valueOf(wallet[1]));
	    wallet1.setWalletAmount(Long.valueOf(wallet[2]));
	    wallet1.setAddedDate(wallet[3]);
	    walletList.add(wallet1);
    }  
    System.out.print(walletList.size()+" "); 
    return walletList;
    }
    
    /*CSVReader reader = null; 
    reader = new CSVReader(new FileReader("C:\\temp\\wallet.csv"));  
    String [] nextLine;  
    //reads one line at a time  
    while ((nextLine = reader.readNext()) != null)  
    {  
    	TblWallet wallet = new TblWallet();
    for(String token : nextLine)  
    {  
    	wallet.setId(Long.valueOf(token));
    	wallet.setTxnRefNum(Long.valueOf(token));
    	wallet.setWalletAmount(Long.valueOf(token));
    	wallet.setAddedDate(token);
   // System.out.print(token+" ");  
    }  
    System.out.print("\n");  
    walletList.add(wallet);
    }  */
    //System.out.print(walletList.size()+" ");  
    //}

}

    
