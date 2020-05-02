/**
 * 
 */
package com.hpfs.distillery.retailer.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author babasaheb
 */

/**
 * @author babasaheb
 *
 */
@Getter
@Setter
@ToString
public class TblDistilleryInvMDto {

	public int inventoryId;
	public int distilleryId;
	public String caseBarNo;
	public String batchNo;
	public String productCode;
	public String productDescription;
	public String packType;
	public int productMrp;
	public int size;
	public String mfgDate;
	public String scannedBy;
	public String approvedBy;
	public String creationDate;

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getPackType() {
		return packType;
	}

	public void setPackType(String packType) {
		this.packType = packType;
	}

	public int getProductMrp() {
		return productMrp;
	}

	public void setProductMrp(int productMrp) {
		this.productMrp = productMrp;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
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

	public String getCreationDate() {
		return creationDate;
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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String createdBy;
	public String updatedDate;
	public String updatedBy;


	public int getInventoryId() {
			return inventoryId;
		}

		public void setInventoryId(int inventoryId) {
			this.inventoryId = inventoryId;
		}

		public int getDistilleryId() {
			return distilleryId;
		}

		public void setDistilleryId(int distilleryId) {
			this.distilleryId = distilleryId;
		}

		public String getCaseBarNo() {
			return caseBarNo;
		}

		public void setCaseBarNo(String caseBarNo) {
			this.caseBarNo = caseBarNo;
		}

		public String getBatchNo() {
			return batchNo;
		}

		public void setBatchNo(String batchNo) {
			this.batchNo = batchNo;
		}

		public String getProductCode() {
			return productCode;
		}

		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}
	}


