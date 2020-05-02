package com.hpfs.distillery.retailer.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Service;

import com.hpfs.distillery.retailer.dto.ShipmentHeaderDto;
import com.hpfs.distillery.retailer.model.ShipmentHeader;
import com.hpfs.distillery.retailer.repository.ShipmentHeaderRepository;
import com.hpfs.distillery.retailer.utils.DtoToModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ShipmentServiceImpl implements ShipmentService {
	
	@Resource
	ShipmentHeaderRepository shipmentHeaderRepository;
	DtoToModel dtoToModel = new DtoToModel();

	@Override
	public ShipmentHeader saveTransportPermitRequest(ShipmentHeaderDto requestData)
			throws SerialException, SQLException, IOException {
		return shipmentHeaderRepository.save(dtoToModel.toShipmentHeader(requestData));
	}

}
