package com.hpfs.distillery.retailer.dto;

import java.util.Date;

public class ShipmentLineDto {
	private Integer shipmentLineId;
	private String productCode;
	private String brandName;
	private Integer size;
	private Integer ofsQnty;
	private Integer allocatedQnty;
	private Float exciseDuty;
	private Date creationDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private String challanNum;
	private Integer shipmentQty;
	private Integer balanceQty;
	public String getChallanNum() {
		return challanNum;
	}
	public void setChallanNum(String challanNum) {
		this.challanNum = challanNum;
	}
	public Integer getShipmentLineId() {
		return shipmentLineId;
	}
	public void setShipmentLineId(Integer shipmentLineId) {
		this.shipmentLineId = shipmentLineId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getOfsQnty() {
		return ofsQnty;
	}
	public void setOfsQnty(Integer ofsQnty) {
		this.ofsQnty = ofsQnty;
	}
	public Integer getAllocatedQnty() {
		return allocatedQnty;
	}
	public void setAllocatedQnty(Integer allocatedQnty) {
		this.allocatedQnty = allocatedQnty;
	}
	public Float getExciseDuty() {
		return exciseDuty;
	}
	public void setExciseDuty(Float exciseDuty) {
		this.exciseDuty = exciseDuty;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getShipmentQty() {
		return shipmentQty;
	}

	public void setShipmentQty(Integer shipmentQty) {
		this.shipmentQty = shipmentQty;
	}

	public Integer getBalanceQty() {
		return balanceQty;
	}

	public void setBalanceQty(Integer balanceQty) {
		this.balanceQty = balanceQty;
	}
}
