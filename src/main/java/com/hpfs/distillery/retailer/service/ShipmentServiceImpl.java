package com.hpfs.distillery.retailer.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialException;

import com.hpfs.distillery.retailer.dto.ShipmentLineDto;
import com.hpfs.distillery.retailer.utils.DateUtils;
import org.springframework.beans.BeanUtils;
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
			throws SerialException, SQLException, IOException, ParseException {
		return shipmentHeaderRepository.save(dtoToModel.toShipmentHeader(requestData));
	}

	@Override
	public List<ShipmentHeader> fetchAllTPR() throws IOException {
		return shipmentHeaderRepository.findAll();
	}

	@Override
	public ShipmentHeaderDto getTPR(String tprid) {
		ShipmentHeader shipmentHeader = shipmentHeaderRepository.getOne(tprid);
		return buildShipmentHeaderDto(shipmentHeader);
	}

	private ShipmentHeaderDto buildShipmentHeaderDto(ShipmentHeader shipmentHeader){
		ShipmentHeaderDto shipmentHeaderDto = new ShipmentHeaderDto();
		shipmentHeaderDto.setCreationDate(DateUtils.getDateAsString(shipmentHeader.getCreationDate()));
		shipmentHeaderDto.setLrDate(DateUtils.getDateAsString(shipmentHeader.getLrDate()));
		shipmentHeaderDto.setUpdatedDate(DateUtils.getDateAsString(shipmentHeader.getUpdatedDate()));
		ShipmentLineDto shipmentLineDto = new ShipmentLineDto();
		List<ShipmentLineDto> shipmentLineDtoList = new ArrayList<>();
		BeanUtils.copyProperties(shipmentHeader,shipmentHeaderDto);
		shipmentHeader.getShipmentLine().forEach(shipmentLine -> {
			BeanUtils.copyProperties(shipmentLine,shipmentLineDto);
			shipmentLineDto.setCreationDate(DateUtils.getDateAsString(shipmentLine.getCreationDate()));
			shipmentLineDto.setUpdatedDate(DateUtils.getDateAsString(shipmentLine.getUpdatedDate()));
			shipmentLineDtoList.add(shipmentLineDto);
		});
		shipmentHeaderDto.setShipmentLineDto(shipmentLineDtoList);
		return shipmentHeaderDto;
	}

}
