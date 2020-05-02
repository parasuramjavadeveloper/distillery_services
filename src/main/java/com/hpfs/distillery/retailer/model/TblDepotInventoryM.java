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
@Table(name="depot_inventory_m")
public class TblDepotInventoryM {

	@Override
	public String toString() {
		return "TblDepotInventoryM [depotInvId=" + depotInvId + ", caseBarNo=" + caseBarNo + ", batchNo=" + batchNo
				+ ", productCode=" + productCode + ", productDescription=" + productDescription + ", productType="
				+ productType + ", depotId=" + depotId + ", availableQty=" + availableQty + ", creationDate="
				+ creationDate + ", createdBy=" + createdBy + ", updatedDate=" + updatedDate + ", updatedBy="
				+ updatedBy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableQty == null) ? 0 : availableQty.hashCode());
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		result = prime * result + ((caseBarNo == null) ? 0 : caseBarNo.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((depotId == null) ? 0 : depotId.hashCode());
		result = prime * result + ((depotInvId == null) ? 0 : depotInvId.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
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
		TblDepotInventoryM other = (TblDepotInventoryM) obj;
		if (availableQty == null) {
			if (other.availableQty != null)
				return false;
		} else if (!availableQty.equals(other.availableQty))
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
		if (depotId == null) {
			if (other.depotId != null)
				return false;
		} else if (!depotId.equals(other.depotId))
			return false;
		if (depotInvId == null) {
			if (other.depotInvId != null)
				return false;
		} else if (!depotInvId.equals(other.depotInvId))
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
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
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
	@Column(name="depot_inv_id")
	public Long depotInvId;

	@Column(name="case_bar_no")
	public String caseBarNo;

	@Column(name="batch_no")
	public String batchNo;

	@Column(name="product_code")
	public String productCode;

	@Column(name="product_description")
	public String productDescription;

	@Column(name="product_type")
	public String productType;

	/*@Column(name="product_mrp")
	public Long productMrp;
*/
	@Column(name="depot_id")
	public Long depotId;

	@Column(name="available_qty")
	public Long availableQty;

	/*@Column(name="received_from")
	public String receivedFrom;*/

	/*@Column(name="scanned_by")
	public String scannedBy;*/

	/*@Column(name="approved_by")
	public String approvedBy;*/

	@Column(name="creation_date")
	public String creationDate;

	@Column(name="created_by")
	public String createdBy;

	@Column(name="updated_date")
	public String updatedDate;

	@Column(name="updated_by")
	public String updatedBy;

	public Long getDepotInvId() {
		return depotInvId;
	}

	public void setDepotInvId(Long depotInvId) {
		this.depotInvId = depotInvId;
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

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	/*public Long getProductMrp() {
		return productMrp;
	}

	public void setProductMrp(Long productMrp) {
		this.productMrp = productMrp;
	}*/

	public Long getDepotId() {
		return depotId;
	}

	public void setDepotId(Long depotId) {
		this.depotId = depotId;
	}

	public Long getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(Long availableQty) {
		this.availableQty = availableQty;
	}
/*
	public String getReceivedFrom() {
		return receivedFrom;
	}

	public void setReceivedFrom(String receivedFrom) {
		this.receivedFrom = receivedFrom;
	}*/

/*	public String getScannedBy() {
		return scannedBy;
	}

	public void setScannedBy(String scannedBy) {
		this.scannedBy = scannedBy;
	}
*/
	/*public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
*/
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
}
