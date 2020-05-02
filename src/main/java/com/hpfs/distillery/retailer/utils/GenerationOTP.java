package com.hpfs.distillery.retailer.utils;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.numbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class GenerationOTP {
	
	public static String generateOTP(int length) {
		 Random rndm_method = new Random(); 
	        char[] otp = new char[length]; 
	        for (int i = 0; i < length; i++) { 
	            // Use of charAt() method : to get character value 
	            // Use of nextInt() as it is scanning the value as int 
	            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length())); 
	        } 
		 return String.valueOf(otp);
	}
	
	public static String sendOtpSMS(String OTP,String mobileNumber) {
		HttpURLConnection conn = null;
		final StringBuffer stringBuffer = new StringBuffer();
		try {
			// Construct data
			String apiKey = "apikey=" + ApplicationConstants.SMSKEY;//"Pw+d0E9Vexg-BKHcfcSEdGMg65bVyqbpYjf90mGk5V";
			String message = "&message="+OTP+ApplicationConstants.SMS_MSG;
			//+ ApplicationConstants.BLUE_BOLD+OTP+ApplicationConstants.ANSI_RESET+ApplicationConstants.SMS_MSG;
			String sender = "&sender=" +ApplicationConstants.SMS_SENDER;
			String numbers = "&numbers=" + mobileNumber;
			
			conn = (HttpURLConnection) new URL(ApplicationConstants.SMS_URL).openConnection();
			String data = apiKey + numbers + message + sender;
			conn.getURL();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			conn.connect();
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			conn.disconnect();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			conn.disconnect();
			return "Error "+e;
		}
	}
	
	public static void main(String args[]) {
		sendOtpSMS("123456","9110356115");
	}
	
}
