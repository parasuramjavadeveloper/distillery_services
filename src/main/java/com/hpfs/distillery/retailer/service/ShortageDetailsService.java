package com.hpfs.distillery.retailer.service;

import java.util.List;

import com.hpfs.distillery.retailer.dto.ShortageDetailsDto;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.model.TblBreakageDetails;
import com.hpfs.distillery.retailer.model.TblShortageDetails;

public interface ShortageDetailsService {
	
	List<TblShortageDetails> fetchShortageInfoData();

	TblShortageDetails saveShortageDts(ShortageDetailsDto requestData, UserDetails us);

	List<TblShortageDetails> fetchDateWiseStmts(String startDate, String endDate);


}
