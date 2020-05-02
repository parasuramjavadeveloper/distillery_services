package com.hpfs.distillery.retailer.service;

import java.util.List;

import com.hpfs.distillery.retailer.dto.HologramDetailsDto;
import com.hpfs.distillery.retailer.dto.IndentCreationDto;
import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.TblDistilleryInvMDto;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.dto.VehicleRouteDto;
import com.hpfs.distillery.retailer.model.GridIndentMgtDts;
import com.hpfs.distillery.retailer.model.TblHologramDetails;
import com.hpfs.distillery.retailer.model.TblProductsM;
import com.hpfs.distillery.retailer.model.VehicleRoute;

public interface HologramDetailsService {

	
	//HealDailyIndent API Methods
	
	TblHologramDetails saveHealDailyIndentDetails(HologramDetailsDto hologramDetailsDto, UserDetails userDetails);
	List<TblHologramDetails> fetchHealDailyIndentDetails();
	List<TblHologramDetails> fetchHealDailyIndentDetailsByIndentNo(Long IndentNo);
	List<HologramDetailsDto> getHealDailyIndentDtsas(HologramDetailsDto search, PageInfo pageInfo);
	
	
	// Purchase Details Methods
	TblHologramDetails saveHealPurchaseIndentDetails(HologramDetailsDto hologramDetailsDto, UserDetails userDetails);
	
	List<String> fetchHealPurchaseIndentPurposeList();
	//Date Wise Methods
	
	List<TblHologramDetails> fetchDateWiseStmts(String startDate, String endDate);
	
	}
