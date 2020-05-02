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
@Table(name="disti_inv_m")
public class TblDistiInvM {
	
	@Override
	public String toString() {
		return "TblDistiInvM [inventoryId=" + inventoryId + ", caseBarNo=" + caseBarNo + ", productCode=" + productCode
				+ ", size=" + size + ", mfgDate=" + mfgDate + ", batchNo=" + batchNo + ", mrp=" + mrp + ", lineId="
				+ lineId + ", countryCode=" + countryCode + ", supplierCode=" + supplierCode + ", distilleryId="
				+ distilleryId + ", segment=" + segment + ", packType=" + packType + ", caseSequenceNum="
				+ caseSequenceNum + ", creationDate=" + creationDate + ", createdBy=" + createdBy + ", updatedDate="
				+ updatedDate + ", updatedBy=" + updatedBy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		result = prime * result + ((caseBarNo == null) ? 0 : caseBarNo.hashCode());
		result = prime * result + ((caseSequenceNum == null) ? 0 : caseSequenceNum.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((distilleryId == null) ? 0 : distilleryId.hashCode());
		result = prime * result + ((inventoryId == null) ? 0 : inventoryId.hashCode());
		result = prime * result + ((lineId == null) ? 0 : lineId.hashCode());
		result = prime * result + ((mfgDate == null) ? 0 : mfgDate.hashCode());
		result = prime * result + ((mrp == null) ? 0 : mrp.hashCode());
		result = prime * result + ((packType == null) ? 0 : packType.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + ((segment == null) ? 0 : segment.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((supplierCode == null) ? 0 : supplierCode.hashCode());
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
		TblDistiInvM other = (TblDistiInvM) obj;
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
		if (caseSequenceNum == null) {
			if (other.caseSequenceNum != null)
				return false;
		} else if (!caseSequenceNum.equals(other.caseSequenceNum))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
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
		if (lineId == null) {
			if (other.lineId != null)
				return false;
		} else if (!lineId.equals(other.lineId))
			return false;
		if (mfgDate == null) {
			if (other.mfgDate != null)
				return false;
		} else if (!mfgDate.equals(other.mfgDate))
			return false;
		if (mrp == null) {
			if (other.mrp != null)
				return false;
		} else if (!mrp.equals(other.mrp))
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
		if (segment == null) {
			if (other.segment != null)
				return false;
		} else if (!segment.equals(other.segment))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (supplierCode == null) {
			if (other.supplierCode != null)
				return false;
		} else if (!supplierCode.equals(other.supplierCode))
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

	/*@Column(name="heal_number")
	public Long healNumber;*/

	@Column(name="case_bar_no")
	public String caseBarNo;

	@Column(name="product_code")
	public String productCode;
	
	@Column(name="size")
	public String size;
	

	@Column(name="mfg_date")
	public String mfgDate;
	
	@Column(name="batch_no")
	public String batchNo;
	
	@Column(name="mrp")
	public Long mrp;

	@Column(name="line_id")
	public Long lineId;

	@Column(name="country_code")
	public Long countryCode;

	@Column(name="supplier_code")
	public Long supplierCode;

	
	public Long getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(Long supplierCode) {
		this.supplierCode = supplierCode;
	}

	@Column(name="distillery_id")
	public Long distilleryId;

	@Column(name="segment")
	public String segment;

	@Column(name="pack_type")
	public String packType;
	

	@Column(name="case_sequence_num")
	public Long caseSequenceNum;

	@Column(name="creation_date")
	public String creationDate;

	@Column(name="created_by")
	public String createdBy;
	
	@Column(name="updated_date")
	public String updatedDate;

	@Column(name="updated_by")
	public String updatedBy;
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	/*public Long getHealNumber() {
		return healNumber;
	}

	public void setHealNumber(Long healNumber) {
		this.healNumber = healNumber;
	}*/

	public String getCaseBarNo() {
		return caseBarNo;
	}

	public void setCaseBarNo(String caseBarNo) {
		this.caseBarNo = caseBarNo;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Long getMrp() {
		return mrp;
	}

	public void setMrp(Long mrp) {
		this.mrp = mrp;
	}

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public Long getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Long countryCode) {
		this.countryCode = countryCode;
	}

	public Long getDistilleryId() {
		return distilleryId;
	}

	public void setDistilleryId(Long distilleryId) {
		this.distilleryId = distilleryId;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getPackType() {
		return packType;
	}

	public void setPackType(String packType) {
		this.packType = packType;
	}

	public Long getCaseSequenceNum() {
		return caseSequenceNum;
	}

	public void setCaseSequenceNum(Long caseSequenceNum) {
		this.caseSequenceNum = caseSequenceNum;
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



	

}
