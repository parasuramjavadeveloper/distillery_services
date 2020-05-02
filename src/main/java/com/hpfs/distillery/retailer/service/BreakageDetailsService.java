package com.hpfs.distillery.retailer.service;

import java.util.List;

import com.hpfs.distillery.retailer.dto.BreakageDetailsDto;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.model.TblBreakageDetails;

public interface BreakageDetailsService {

	List<TblBreakageDetails> fetchBreakageInfoData();

	TblBreakageDetails saveBreakageDts(BreakageDetailsDto requestData, UserDetails us);

	List<TblBreakageDetails> fetchDateWiseStmts(String startDate, String endDate);

	List<String> fetchProductTypeList();

	
}
