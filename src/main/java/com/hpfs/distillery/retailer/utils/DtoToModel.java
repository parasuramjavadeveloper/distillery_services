package com.hpfs.distillery.retailer.utils;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.BeanUtils;

import com.hpfs.distillery.retailer.dto.BreakageDetailsDto;
import com.hpfs.distillery.retailer.dto.CartDetailsDto;
import com.hpfs.distillery.retailer.dto.HologramDetailsDto;
import com.hpfs.distillery.retailer.dto.IndentCreationDto;
import com.hpfs.distillery.retailer.dto.LabInformationDto;
import com.hpfs.distillery.retailer.dto.LabSampleDto;
import com.hpfs.distillery.retailer.dto.ShipmentHeaderDto;
import com.hpfs.distillery.retailer.dto.ShipmentLineDto;
import com.hpfs.distillery.retailer.dto.ShortageDetailsDto;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.dto.VehicleRouteDto;
import com.hpfs.distillery.retailer.model.LabInformation;
import com.hpfs.distillery.retailer.model.LabSample;
import com.hpfs.distillery.retailer.model.ShipmentHeader;
import com.hpfs.distillery.retailer.model.ShipmentLine;
import com.hpfs.distillery.retailer.model.TblBreakageDetails;
import com.hpfs.distillery.retailer.model.TblCartDetails;
import com.hpfs.distillery.retailer.model.TblHologramDetails;
import com.hpfs.distillery.retailer.model.TblIndent_D;
import com.hpfs.distillery.retailer.model.TblIndent_M;
import com.hpfs.distillery.retailer.model.TblRetailerPaymentDetails;
import com.hpfs.distillery.retailer.model.TblShortageDetails;
import com.hpfs.distillery.retailer.model.VehicleRoute;

public class DtoToModel {
	private static AtomicInteger at = new AtomicInteger(0);

	public int getNextCountValue() {
		return at.incrementAndGet();
	}

	public TblIndent_M toTblIndentM(IndentCreationDto requestData, UserDetails us) {
		TblIndent_M tblIndent_M = new TblIndent_M();
		tblIndent_M.setRetailerCode(String.valueOf(requestData.getRetailerCode()));
		tblIndent_M.setIndentCreationDate(requestData.getIndentCreationDate());
		tblIndent_M.setAuthorisedPerson(requestData.getAuthorisedPerson());
		tblIndent_M.setContactNumber(requestData.getContactNumber());
		tblIndent_M.setDescription(requestData.getDescription());
		tblIndent_M.setNeedByDate(DateUtils.DateToString());
		tblIndent_M.setVehicleNumber(requestData.getVehicleNumber());
		tblIndent_M.setCreationDate(DateUtils.DateToString());
		tblIndent_M.setStatus(ApplicationConstants.ACTIVE_STATUS);
		// tblIndent_M.setCreatedBy(us.getSid());
		return tblIndent_M;
	}

	public List<TblIndent_D> toTblIndentD(IndentCreationDto requestData, UserDetails us) {
		List<TblIndent_D> list = new ArrayList();
		if (requestData != null & requestData.productList != null) {
			for (TblIndent_D d : requestData.productList) {

				TblIndent_D tblIndent_D = new TblIndent_D();
				tblIndent_D.setBarCode(d.getBarCode());
				tblIndent_D.setNoOfUnits(d.getNoOfUnits());
				tblIndent_D.setProductCode(d.getProductCode());
				tblIndent_D.setProductDescription(d.getProductDescription());
				tblIndent_D.setUnitPrice(d.getUnitPrice());
				tblIndent_D.setTotal_price(d.getTotalPrice());
				tblIndent_D.setCreationDate(DateUtils.DateToString());
				// tblIndent_D.setCreatedBy(us.getSid());
				list.add(tblIndent_D);
			}
		}
		return list;
	}

	public VehicleRoute toVehicleRoute(VehicleRouteDto requestData) {

		VehicleRoute vehicleRoute = new VehicleRoute();
		if (requestData != null) {

			// vehicleRoute.setRouteId(requestData.getRouteId());
			vehicleRoute.setDistillerySource(requestData.getDistillerySource());
			vehicleRoute.setVehicleNum(requestData.getVehicleNum());
			vehicleRoute.setIntermediateDepots(requestData.getIntermediateDepots());
			vehicleRoute.setComments(requestData.getComments());
			vehicleRoute.setTpPin(requestData.getTpPin());
			/*
			 * vehicleRoute.setCreatedBy(requestData.getCreatedBy());
			 * vehicleRoute.setCreationDate(requestData.getCreationDate());
			 */
			vehicleRoute.setEstimatedStartDate(requestData.getEstimatedStartDate());
			/*
			 * vehicleRoute.setUpdatedBy(requestData.getUpdatedBy());
			 * vehicleRoute.setUpdatedDate(requestData.getUpdatedDate());
			 */
			vehicleRoute.setDestinationDepot(requestData.getDestinationDepot());
			vehicleRoute.setStatus(ApplicationConstants.ACTIVE_STATUS);

		}
		return vehicleRoute;
	}

	/*
	 * public VehicleTracking toVehicleTracking(VehicleTrackingDto requestData) {
	 * 
	 * VehicleTracking vehicleTracking = new VehicleTracking(); if (requestData !=
	 * null) {
	 * 
	 * vehicleRoute.setRouteId(requestData.getRouteId());
	 * vehicleRoute.setDistillerySource(requestData.getDistillerySource());
	 * vehicleRoute.setVehicleNum(requestData.getVehicleNum());
	 * vehicleRoute.setIntermediateDepots(requestData.getIntermediateDepots());
	 * vehicleRoute.setComments(requestData.getComments());
	 * vehicleRoute.setCreatedBy(requestData.getCreatedBy());
	 * vehicleRoute.setCreationDate(requestData.getCreationDate());
	 * vehicleRoute.setEstimatedStartDate(requestData.getEstimatedStartDate());
	 * vehicleRoute.setUpdatedBy(requestData.getUpdatedBy());
	 * vehicleRoute.setUpdatedDate(requestData.getUpdatedDate());
	 * vehicleRoute.setDestinationDepot(requestData.getDestinationDepot());
	 * vehicleRoute.setStatus(requestData.getStatus());
	 * 
	 * } return vehicleTracking; }
	 */

	// Vamsi Added Newly for Holograms

	// Conversion for HologramHealIndentDetails

	public TblHologramDetails toTblHologramHealIndentDetails(HologramDetailsDto requestData, UserDetails us) {
		TblHologramDetails tblHologram_M = new TblHologramDetails();
		tblHologram_M.setIndentNum(requestData.getIndentNum());
		tblHologram_M.setQuantity(requestData.getQuantity());
		tblHologram_M.setCreationDate(DateUtils.DateToString());
		tblHologram_M.setPurpose(requestData.getPurpose());
		tblHologram_M.setStatus(requestData.getStatus());
		// tblHologram_M.setStatus(ApplicationConstants.ACTIVE_STATUS);
		return tblHologram_M;
	}

	public List<TblHologramDetails> toTblHologramHealIndentDetailsList(HologramDetailsDto requestData, UserDetails us) {
		List<TblHologramDetails> list = new ArrayList();
		if (requestData != null & requestData.getHologramList() != null) {
			for (TblHologramDetails d : requestData.getHologramList()) {

				TblHologramDetails tblHologram_M = new TblHologramDetails();
				tblHologram_M.setIndentNum(requestData.getIndentNum());
				tblHologram_M.setQuantity(requestData.getQuantity());
				tblHologram_M.setCreationDate(DateUtils.DateToString());
				tblHologram_M.setPurpose(requestData.getPurpose());
				tblHologram_M.setStatus(requestData.getStatus());
				list.add(tblHologram_M);
			}
		}
		return list;
	}

	// Conversion for PurchaseIndentDetails

	public TblHologramDetails toTblHologramHealPurchaseIndentDetails(HologramDetailsDto requestData, UserDetails us) {
		TblHologramDetails tblHologram_M = new TblHologramDetails();
		tblHologram_M.setQuantity(requestData.getQuantity());
		tblHologram_M.setChallanNum(requestData.getChallanNum());
		tblHologram_M.setChallanAmount(requestData.getChallanAmount());
		tblHologram_M.setChallanDate(requestData.getChallanDate());
		tblHologram_M.setCarrierName(requestData.getCarrierName());
		tblHologram_M.setStoBank(requestData.getStoBank());
		tblHologram_M.setPurpose(requestData.getPurpose());
		tblHologram_M.setStatus(ApplicationConstants.ACTIVE_STATUS);
		return tblHologram_M;
	}

	// Conversion for Cartdetails
	public TblCartDetails toTblCartdetails(CartDetailsDto requestData, UserDetails us) {
		TblCartDetails tblCartDetails = new TblCartDetails();
		tblCartDetails.setId(requestData.getId());
		tblCartDetails.setRetailerCode(requestData.getRetailerCode());
		tblCartDetails.setDistilleryId(requestData.getDistilleryId());
		tblCartDetails.setBrandName(requestData.getBrandName());
		tblCartDetails.setSize(requestData.getSize());
		tblCartDetails.setQuantity(requestData.getQuantity());
		tblCartDetails.setUnitPrice(requestData.getUnitPrice());
		tblCartDetails.settotalPrice(requestData.getTotalPrice());
		tblCartDetails.setCreationDate(DateUtils.DateToString());
		tblCartDetails.setCreatedBy(requestData.getCreatedBy());
		tblCartDetails.setUpdatedDate(requestData.getUpdatedDate());
		tblCartDetails.setUpdatedBy(requestData.getUpdatedBy());
		// tblIndent_M.setCreatedBy(us.getSid());
		return tblCartDetails;
	}

	public List<TblRetailerPaymentDetails> toTblCartdetailsList(CartDetailsDto requestData, UserDetails us) {
		List<TblRetailerPaymentDetails> list = new ArrayList();
		if (requestData != null & requestData.getPaymentList() != null) {
			for (TblRetailerPaymentDetails d : requestData.getPaymentList()) {

				TblRetailerPaymentDetails tblRetailerPaymentDetails = new TblRetailerPaymentDetails();
				tblRetailerPaymentDetails.setRetailerPaymentId(d.getRetailerPaymentId());
				tblRetailerPaymentDetails.setRetailerCode(d.getRetailerCode());
				tblRetailerPaymentDetails.setPaymentDate(d.getPaymentDate());
				tblRetailerPaymentDetails.setPaymentType(d.getPaymentType());
				tblRetailerPaymentDetails.setStatus(d.getStatus());
				tblRetailerPaymentDetails.setAmount(d.getAmount());
				tblRetailerPaymentDetails.setChequeNumber(d.getChequeNumber());
				tblRetailerPaymentDetails.setCreationDate(DateUtils.DateToString());
				tblRetailerPaymentDetails.setCreatedBy(d.getCreatedBy());
				tblRetailerPaymentDetails.setUpdatedDate(d.getUpdatedDate());
				tblRetailerPaymentDetails.setUpdatedBy(d.getUpdatedBy());
				list.add(tblRetailerPaymentDetails);
			}
		}
		return list;
	}

	// Breakage Module Conversion

	public TblBreakageDetails toBreakageDetails(BreakageDetailsDto requestData, UserDetails us) {
		TblBreakageDetails breakageDetailsDto = new TblBreakageDetails();
		if (requestData != null)
			// vehicleRoute.setRouteId(requestData.getRouteId());
			breakageDetailsDto.setProductCode(requestData.getProductCode());
		breakageDetailsDto.setBrandName(requestData.getBrandName());
		breakageDetailsDto.setProductType(requestData.getProductType());
		breakageDetailsDto.setBatchNo(requestData.getBatchNo());
		breakageDetailsDto.setCaseBarNo(requestData.getCaseBarNo());
		breakageDetailsDto.setSize(requestData.getSize());
		breakageDetailsDto.setDepotId(requestData.getDepotId());
		breakageDetailsDto.setReceivedFrom(requestData.getReceivedFrom());
		breakageDetailsDto.setBreakageCount(requestData.getBreakageCount());
		breakageDetailsDto.setScannedDate(requestData.getScannedDate());
		breakageDetailsDto.setScannedBy(requestData.getScannedBy());
		breakageDetailsDto.setApprovedBy(requestData.getApprovedBy());
		breakageDetailsDto.setCreationDate(requestData.getCreationDate());
		breakageDetailsDto.setCreatedBy(requestData.getCreatedBy());
		breakageDetailsDto.setUpdatedDate(requestData.getUpdatedDate());
		breakageDetailsDto.setUpdatedBy(requestData.getUpdatedBy());
		// return breakageDetailsDto;
		return breakageDetailsDto;

	}

	// Shortage Module Conversion

	public TblShortageDetails toShortageDetails(ShortageDetailsDto requestData, UserDetails us) {
		TblShortageDetails shortageDetailsDto = new TblShortageDetails();
		if (requestData != null)
			// vehicleRoute.setRouteId(requestData.getRouteId());
			shortageDetailsDto.setProductCode(requestData.getProductCode());
		shortageDetailsDto.setBrandName(requestData.getBrandName());
		shortageDetailsDto.setProductType(requestData.getProductType());
		shortageDetailsDto.setBatchNo(requestData.getBatchNo());
		shortageDetailsDto.setCaseBarNo(requestData.getCaseBarNo());
		shortageDetailsDto.setSize(requestData.getSize());
		shortageDetailsDto.setDepotId(requestData.getDepotId());
		shortageDetailsDto.setHealNumber(requestData.getHealNumber());
		shortageDetailsDto.setReceivedFrom(requestData.getReceivedFrom());
		shortageDetailsDto.setBreakageCount(requestData.getBreakageCount());
		shortageDetailsDto.setScannedDate(requestData.getScannedDate());
		shortageDetailsDto.setScannedBy(requestData.getScannedBy());
		shortageDetailsDto.setApprovedBy(requestData.getApprovedBy());
		shortageDetailsDto.setCreationDate(requestData.getCreationDate());
		shortageDetailsDto.setCreatedBy(requestData.getCreatedBy());
		shortageDetailsDto.setUpdatedDate(requestData.getUpdatedDate());
		shortageDetailsDto.setUpdatedBy(requestData.getUpdatedBy());
		return shortageDetailsDto;

	}

	public LabSample toLabSample(LabSampleDto requestData, UserDetails us) throws SerialException, SQLException, IOException {
		LabSample labSampleDto = new LabSample();
		
		if (requestData != null) {

			labSampleDto.setReferenceNum(requestData.getReferenceNum());
			labSampleDto.setSentThrough(requestData.getSentThrough());
			//Blob blob = new SerialBlob(requestData.getSignature());
			//labSampleDto.setSignature(blob);
			labSampleDto.setSampleType(requestData.getSampleType());
			labSampleDto.setCreationDate(new Date());
			labSampleDto.setCreatedBy(requestData.getCreatedBy());
			byte[] compressed=AttachmentUtils.compress(requestData.getSignatureFile());
			labSampleDto.setData(compressed);
			//labSampleDto.setLabInformation((requestData.getLabInformation());
			labSampleDto.setLabInformation(buildLabInformation(requestData.getLabInformation()));
		}

		return labSampleDto;

	}
	
	public ShipmentHeader toShipmentHeader(ShipmentHeaderDto requestData) throws SerialException, SQLException, IOException, ParseException {
		ShipmentHeader shipmentHeader = new ShipmentHeader(); 
		
		if (requestData != null) {

			shipmentHeader.setConsignmentType(requestData.getConsignmentType());
			shipmentHeader.setCreatedBy(requestData.getCreatedBy());
			shipmentHeader.setCreationDate(DateUtils.getDateFromString(requestData.getCreationDate()));
			shipmentHeader.setDepotId(requestData.getDepotId());
			shipmentHeader.setLrDate(DateUtils.getDateFromString(requestData.getLrDate()));
			shipmentHeader.setLrNum(requestData.getLrNum());
			shipmentHeader.setOfsNo(requestData.getOfsNo()); 
			shipmentHeader.setRoute(requestData.getRoute());
			shipmentHeader.setTransporter(requestData.getTransporter());
			shipmentHeader.setUpdatedBy(requestData.getUpdatedBy());
			shipmentHeader.setUpdatedDate(DateUtils.getDateFromString(requestData.getUpdatedDate()));
			shipmentHeader.setVehicleNum(requestData.getVehicleNum()); 
			shipmentHeader.setShipmentLine(buildShipmentLine(requestData.getShipmentLineDto())); 
		}

		return shipmentHeader;

	}


	private List<LabInformation> buildLabInformation(List<LabInformationDto> labInformationDtoList) throws IOException {
		List<LabInformation> labInformationList=new ArrayList<>();
		if(labInformationDtoList!=null)
		{
			for (LabInformationDto d : labInformationDtoList) {
				LabInformation labInformation=new LabInformation();
				BeanUtils.copyProperties(d, labInformation);
				byte[] compressed=AttachmentUtils.compress(d.getDataFile());
				labInformation.setData(compressed);
				labInformationList.add(labInformation);
			}

		}
		return labInformationList;	
		
	}
	
	private List<ShipmentLine> buildShipmentLine(List<ShipmentLineDto> shipmentLineDtoList) throws IOException, ParseException {
		List<ShipmentLine> shipmentLineList=new ArrayList<>();
		if(shipmentLineList!=null)
		{
			for (ShipmentLineDto d : shipmentLineDtoList) {
				ShipmentLine shipmentLine=new ShipmentLine();
				StringBuffer lineNo = new StringBuffer("SLINE");
				lineNo.append(this.getNextCountValue());
				//shipmentLine.setShipmentLineId(lineNo.toString().substring(0,10));
				shipmentLine.setCreationDate(DateUtils.getDateFromString(d.getCreationDate()));
				shipmentLine.setUpdatedDate(DateUtils.getDateFromString(d.getUpdatedDate()));
				BeanUtils.copyProperties(d, shipmentLine);
				shipmentLineList.add(shipmentLine);
			}

		}
		return shipmentLineList;	
		
	}
}

