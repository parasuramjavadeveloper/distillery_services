/**
 * 
 */
package com.hpfs.distillery.retailer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author babasaheb
 *
 */
@Entity
@Table(name="distillery_inv_m")
public class TblDistilleryInvM {

	@Override
	public String toString() {
		return "TblDistilleryInvM [inventoryId=" + inventoryId + ", distilleryId=" + distilleryId + ", caseBarNo="
				+ caseBarNo + ", batchNo=" + batchNo + ", productCode=" + productCode + ", productDescription="
				+ productDescription + ", packType=" + packType + ", productMrp=" + productMrp + ", size=" + size
				+ ", mfgDate=" + mfgDate + ", scannedBy=" + scannedBy + ", approvedBy=" + approvedBy + ", creationDate="
				+ creationDate + ", createdBy=" + createdBy + ", updatedDate=" + updatedDate + ", updatedBy="
				+ updatedBy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approvedBy == null) ? 0 : approvedBy.hashCode());
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		result = prime * result + ((caseBarNo == null) ? 0 : caseBarNo.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((distilleryId == null) ? 0 : distilleryId.hashCode());
		result = prime * result + ((inventoryId == null) ? 0 : inventoryId.hashCode());
		result = prime * result + ((mfgDate == null) ? 0 : mfgDate.hashCode());
		result = prime * result + ((packType == null) ? 0 : packType.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + ((productMrp == null) ? 0 : productMrp.hashCode());
		result = prime * result + ((scannedBy == null) ? 0 : scannedBy.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TblDistilleryInvM other = (TblDistilleryInvM) obj;
		if (approvedBy == null) {
			if (other.approvedBy != null)
				return false;
		} else if (!approvedBy.equals(other.approvedBy))
			return false;
		if (batchNo == null) {
			if (other.batchNo != null)
				return false;
		} else if (!batchNo.equals(other.batchNo))
			return false;
		if (caseBarNo == null) {
			if (other.caseBarNo != null)
				return false;
		} else if (!caseBarNo.equals(other.caseBarNo))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (distilleryId == null) {
			if (other.distilleryId != null)
				return false;
		} else if (!distilleryId.equals(other.distilleryId))
			return false;
		if (inventoryId == null) {
			if (other.inventoryId != null)
				return false;
		} else if (!inventoryId.equals(other.inventoryId))
			return false;
		if (mfgDate == null) {
			if (other.mfgDate != null)
				return false;
		} else if (!mfgDate.equals(other.mfgDate))
			return false;
		if (packType == null) {
			if (other.packType != null)
				return false;
		} else if (!packType.equals(other.packType))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productMrp == null) {
			if (other.productMrp != null)
				return false;
		} else if (!productMrp.equals(other.productMrp))
			return false;
		if (scannedBy == null) {
			if (other.scannedBy != null)
				return false;
		} else if (!scannedBy.equals(other.scannedBy))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (updatedBy == null) {
			if (other.updatedBy != null)
				return false;
		} else if (!updatedBy.equals(other.updatedBy))
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="inventory_id")
	public Long inventoryId;

	@Column(name="distillery_id")
	public Long distilleryId;

	@Column(name="case_bar_no")
	public String caseBarNo;

	@Column(name="batch_no")
	public String batchNo;

	@Column(name="product_code")
	public String productCode;

	@Column(name="product_description")
	public String productDescription;

	@Column(name="pack_type")
	public String packType;

	@Column(name="product_mrp")
	public Long productMrp;

	@Column(name="size")
	public Long size;

	@Column(name="mfg_date")
	public String mfgDate;

	@Column(name="scanned_by")
	public String scannedBy;

	@Column(name="approved_by")
	public String approvedBy;

	@Column(name="creation_date")
	public String creationDate;

	@Column(name="createdBy")
	public String createdBy;

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

	public Long getProductMrp() {
		return productMrp;
	}

	public void setProductMrp(Long productMrp) {
		this.productMrp = productMrp;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
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

	@Column(name="updated_date")
	public String updatedDate;

	@Column(name="updated_by")
	public String updatedBy;

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Long getDistilleryId() {
		return distilleryId;
	}

	public void setDistilleryId(Long distilleryId) {
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
