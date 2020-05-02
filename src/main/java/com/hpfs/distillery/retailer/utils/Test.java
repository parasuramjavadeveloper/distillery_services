package com.hpfs.distillery.retailer.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";


	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";//https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static void main(String args[]) throws FileNotFoundException, IOException {
        System.out.println(ANSI_RED + "12333" + ANSI_RESET+" : " + "Hi this");
        
        System.out.println(ANSI_GREEN_BACKGROUND + "This text has a green background but default text!" + ANSI_RESET);
       /* System.out.println(ConsoleColors.RED + "RED COLORED" +
        		ConsoleColors.RESET + " NORMAL");*/
        
        
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\testCSV.csv"))) {
            String line;
            while ((line = br.readLine()) != null ) {
            	if(line.length()==32) {
            	String country = line.substring(0, 3);
            	String supp = line.substring(4, 7);
            	System.out.println(line.length()+"---"+supp);
            	}
               /* String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));*/
            }
        }
    }
	
	
	
	


}
