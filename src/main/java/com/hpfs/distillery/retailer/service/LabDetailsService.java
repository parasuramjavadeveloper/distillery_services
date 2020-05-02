package com.hpfs.distillery.retailer.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import com.hpfs.distillery.retailer.dto.LabSampleDto;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.model.LabInformation;
import com.hpfs.distillery.retailer.model.LabSample;

public interface LabDetailsService {
	
	
	//List<TblShortageDetails> fetchShortageInfoData();

	LabSample saveLabSamples(LabSampleDto requestData, UserDetails us) throws SerialException, SQLException, IOException; 

	List<LabSample> fetchAllSamples() throws IOException;

	LabInformation updateStatus(int labInfoId, String status);

	//List<TblShortageDetails> fetchDateWiseStmts(String startDate, String endDate);


}
