package com.hpfs.distillery.retailer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vamsi Alla
 *
 */
@Entity
@Table(name = "shortages_d")
public class TblShortageDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shortage_id")
	public int shortageId;

	@Column(name = "product_code")
	public String productCode;

	@Column(name = "brand_name")
	public String brandName;

	@Column(name = "product_type")
	public String productType;
	
	@Column(name = "batch_no")
	public String batchNo;

	@Column(name = "case_bar_no")
	public String caseBarNo;

	@Column(name = "size")
	public int size;

	@Column(name = "depot_id")
	public int depotId;
	
	@Column(name = "heal_number")
	public Long healNumber;
	
	@Column(name = "received_from")
	public String receivedFrom;

	@Column(name = "breakage_count")
	public int breakageCount;

	@Column(name = "scanned_date")
	public Date scannedDate;

	@Column(name = "scanned_by")
	public String scannedBy;

	@Column(name = "approved_by")
	public String approvedBy;

	@Column(name = "creation_date")
	public Date creationDate;

	@Column(name = "created_by")
	public String createdBy;

	@Column(name = "updated_date")
	public Date updatedDate;

	@Column(name = "updated_by")
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
