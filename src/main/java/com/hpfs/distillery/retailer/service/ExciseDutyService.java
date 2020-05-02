package com.hpfs.distillery.retailer.service;

import com.hpfs.distillery.retailer.model.TblExciseDuty;

import java.util.List;

public interface ExciseDutyService {

    List<TblExciseDuty> fetchExciseData(String challanType);

    String saveExciseData(TblExciseDuty request);

	List<TblExciseDuty> fetchDateWiseStmts(String startDate, String endDate);

	List<String> fetchChallanTypeList();

	
}
