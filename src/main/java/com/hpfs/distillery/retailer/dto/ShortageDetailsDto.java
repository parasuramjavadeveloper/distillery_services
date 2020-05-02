package com.hpfs.distillery.retailer.dto;

import java.util.Date;

public class ShortageDetailsDto {
	
	public int shortageId;;
	public String productCode;
	public String brandName;
	public String productType;
	public String batchNo;
	public String caseBarNo;
	public int size;
	public int depotId;
	public Long healNumber;
	public String receivedFrom;
	public int breakageCount;
	public Date scannedDate;
	public String scannedBy;
	public String approvedBy;
	public Date creationDate;
	public String createdBy;
	public Date updatedDate;
	public String updatedBy;
	
	
	public int getShortageId() {
		return shortageId;
	}
	public void setShortageId(int shortageId) {
		this.shortageId = shortageId;
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
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getCaseBarNo() {
		return caseBarNo;
	}
	public void setCaseBarNo(String caseBarNo) {
		this.caseBarNo = caseBarNo;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getDepotId() {
		return depotId;
	}
	public void setDepotId(int depotId) {
		this.depotId = depotId;
	}
	public Long getHealNumber() {
		return healNumber;
	}
	public void setHealNumber(Long healNumber) {
		this.healNumber = healNumber;
	}
	public String getReceivedFrom() {
		return receivedFrom;
	}
	public void setReceivedFrom(String receivedFrom) {
		this.receivedFrom = receivedFrom;
	}
	public int getBreakageCount() {
		return breakageCount;
	}
	public void setBreakageCount(int breakageCount) {
		this.breakageCount = breakageCount;
	}
	public Date getScannedDate() {
		return scannedDate;
	}
	public void setScannedDate(Date scannedDate) {
		this.scannedDate = scannedDate;
	}
	public String getScannedBy() {
		return scannedBy;
	}
	public void setScannedBy(String scannedBy) {
		this.scannedBy = scannedBy;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
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
	
	

}
