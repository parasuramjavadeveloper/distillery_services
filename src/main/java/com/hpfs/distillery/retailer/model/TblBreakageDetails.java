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
@Table(name = "breakages_d")
public class TblBreakageDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "breakage_id")
	public int breakageId;

	@Column(name = "product_code")
	public String productCode;

	@Column(name = "brand_name")
	public String brandName;
	
	@Column(name = "batch_no")
	public String batchNo;

	@Column(name = "product_type")
	public String productType;

	@Column(name = "case_bar_no")
	public String caseBarNo;

	@Column(name = "size")
	public int size;

	@Column(name = "depot_id")
	public int depotId;

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
	public String creationDate;

	@Column(name = "created_by")
	public String createdBy;

	@Column(name = "updated_date")
	public String updatedDate;

	@Column(name = "updated_by")
	public String updatedBy;
	
	

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public int getBreakageId() {
		return breakageId;
	}

	public void setBreakageId(int breakageId) {
		this.breakageId = breakageId;
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

	

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	
	
	

}
