package com.hpfs.distillery.retailer.utils;

public interface ApplicationConstants {
	
	public static final String HEADER_STRING = "Authorization";
	
	public static final String INVALID_REQUEST ="Invalid Request";
	public static final String NOT_AUTHORISED ="Invalid Request";
	public static final String REQUEST_NOT_FOUND ="Invalid Request";
	public static final String INTERNAL_SERVER_ERROR ="Invalid Request";
	public static final String SERVER_NOT_AVAILABLE ="Invalid Request";

	public static final String SCHEMA="distillery.";
	public static final String ACTIVE_STATUS = "ACTIVE";
	public static final String INACTIVE_STATUS = "INACTIVE";
	public static final String ACTIVE = "Y";
	public static final String DOT_FORMAT ="yyyy-MM-dd hh:mm:ss";
	public static final String OT_FORMAT = "yyyy-MM-dd";
	public static final String numbers="0123456789";
	public static final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
	public static final String SMSKEY="frY1EUayREY-Bj63kY3zl69tGkPlxtlYL1SvWTH3Od";
	public static final String SMS_MSG=" is your Login confirmation code. Please do not share this with anyone";
	public static final String SMS_SENDER="TXTLCL";
	public static final String SMS_URL="https://api.textlocal.in/send/?";
	public static final int OTP_LENGTH=6;
	public static final String BLUE_BOLD = "\033[1;34m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static final String DISTI_CSV_LOC = "C:\\temp\\testCSV.csv";
	public static final String PENDING_STATUS="PENDING";
	public static final String APPROVED_STATUS="APPROVED";
	public static final String REJECTED_STATUS="REJECTED";
	public static final String DELIMITER=",";
	
	public static final String LOCAL_SUPPLIER = "Andhra Pradesh";
	public static final String COUNTRY = "India";
	
	public static final String LOCAL = "Local";
	public static final String NON_LOCAL = "NonLocal";
	public static final String FOREIGN = "Foreign";
	public static final String BREWERIES = "Breweries";
}

