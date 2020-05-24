package com.hpfs.distillery.retailer.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import com.hpfs.distillery.retailer.dto.ShipmentHeaderDto;
import com.hpfs.distillery.retailer.model.ShipmentHeader;

public interface ShipmentService {
	
	

	ShipmentHeader saveTransportPermitRequest(ShipmentHeaderDto requestData) throws SerialException, SQLException, IOException, ParseException;

	List<ShipmentHeader> fetchAllTPR() throws IOException;

	ShipmentHeaderDto getTPR(String tprid);

	//LabInformation updateStatus(int labInfoId, String status);



}
