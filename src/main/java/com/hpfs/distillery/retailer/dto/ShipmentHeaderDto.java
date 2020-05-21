package com.hpfs.distillery.retailer.dto;

import java.util.Date;
import java.util.List;

public class ShipmentHeaderDto {
	private Long shipmentHdrId;

	private String consignmentType;

	private String route;

	private String vehicleNum;

	private String transporter;

	private Integer lrNum;

	private String lrDate;

	private String ofsNo;

	private Integer depotId;

	private String creationDate;

	private String createdBy;

	private String updatedDate;

	private String updatedBy;

	private List<ShipmentLineDto> shipmentLineDto;

	public Long getShipmentHdrId() {
		return shipmentHdrId;
	}

	public void setShipmentHdrId(Long shipmentHdrId) {
		this.shipmentHdrId = shipmentHdrId;
	}

	public String getConsignmentType() {
		return consignmentType;
	}

	public void setConsignmentType(String consignmentType) {
		this.consignmentType = consignmentType;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public String getTransporter() {
		return transporter;
	}

	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}

	public Integer getLrNum() {
		return lrNum;
	}

	public void setLrNum(Integer lrNum) {
		this.lrNum = lrNum;
	}

	public String getOfsNo() {
		return ofsNo;
	}

	public void setOfsNo(String ofsNo) {
		this.ofsNo = ofsNo;
	}

	public Integer getDepotId() {
		return depotId;
	}

	public void setDepotId(Integer depotId) {
		this.depotId = depotId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<ShipmentLineDto> getShipmentLineDto() {
		return shipmentLineDto;
	}

	public void setShipmentLineDto(List<ShipmentLineDto> shipmentLineDto) {
		this.shipmentLineDto = shipmentLineDto;
	}

	public String getLrDate() {
		return lrDate;
	}

	public void setLrDate(String lrDate) {
		this.lrDate = lrDate;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
}
