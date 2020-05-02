/**
 * 
 */
package com.hpfs.distillery.retailer.dto;

import javax.persistence.Entity;

/**
 * @author babasaheb
 *
 */
public class ReceiptsDts {
	
	public Long requestId;
	public Long receiptId;
	public String cpeTpNo;
	public String dtpNo;
	public String receiptDate;
	public String vehicleNum;
	public Long actualqty; 
	public Long remainingQty;
	public Long strength;
	public String storageTankNo;
	
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String supplierName;
	public Long dip;
	public Long wastage;
	public String remarks;
	public Long receivedQty;
	public String creationDate;
	public String createdBy;
	public String updatedDate;
	public String updatedBy;

	public Long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}

	public String getCpeTpNo() {
		return cpeTpNo;
	}

	public void setCpeTpNo(String cpeTpNo) {
		this.cpeTpNo = cpeTpNo;
	}

	public String getDtpNo() {
		return dtpNo;
	}

	public void setDtpNo(String dtpNo) {
		this.dtpNo = dtpNo;
	}

	public String getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public Long getRemainingQty() {
		return remainingQty;
	}

	public void setRemainingQty(Long remainingQty) {
		this.remainingQty = remainingQty;
	}

	public Long getStrength() {
		return strength;
	}

	public void setStrength(Long strength) {
		this.strength = strength;
	}

	public String getStorageTankNo() {
		return storageTankNo;
	}

	public void setStorageTankNo(String storageTankNo) {
		this.storageTankNo = storageTankNo;
	}

	public Long getDip() {
		return dip;
	}

	public void setDip(Long dip) {
		this.dip = dip;
	}

	public Long getWastage() {
		return wastage;
	}

	public void setWastage(Long wastage) {
		this.wastage = wastage;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(Long receivedQty) {
		this.receivedQty = receivedQty;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpeTpNo == null) ? 0 : cpeTpNo.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((dip == null) ? 0 : dip.hashCode());
		result = prime * result + ((dtpNo == null) ? 0 : dtpNo.hashCode());
		result = prime * result + ((receiptDate == null) ? 0 : receiptDate.hashCode());
		result = prime * result + ((receiptId == null) ? 0 : receiptId.hashCode());
		result = prime * result + ((receivedQty == null) ? 0 : receivedQty.hashCode());
		result = prime * result + ((remainingQty == null) ? 0 : remainingQty.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((storageTankNo == null) ? 0 : storageTankNo.hashCode());
		result = prime * result + ((strength == null) ? 0 : strength.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result + ((vehicleNum == null) ? 0 : vehicleNum.hashCode());
		result = prime * result + ((wastage == null) ? 0 : wastage.hashCode());
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
		ReceiptsDts other = (ReceiptsDts) obj;
		if (cpeTpNo == null) {
			if (other.cpeTpNo != null)
				return false;
		} else if (!cpeTpNo.equals(other.cpeTpNo))
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
		if (dip == null) {
			if (other.dip != null)
				return false;
		} else if (!dip.equals(other.dip))
			return false;
		if (dtpNo == null) {
			if (other.dtpNo != null)
				return false;
		} else if (!dtpNo.equals(other.dtpNo))
			return false;
		if (receiptDate == null) {
			if (other.receiptDate != null)
				return false;
		} else if (!receiptDate.equals(other.receiptDate))
			return false;
		if (receiptId == null) {
			if (other.receiptId != null)
				return false;
		} else if (!receiptId.equals(other.receiptId))
			return false;
		if (receivedQty == null) {
			if (other.receivedQty != null)
				return false;
		} else if (!receivedQty.equals(other.receivedQty))
			return false;
		if (remainingQty == null) {
			if (other.remainingQty != null)
				return false;
		} else if (!remainingQty.equals(other.remainingQty))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (storageTankNo == null) {
			if (other.storageTankNo != null)
				return false;
		} else if (!storageTankNo.equals(other.storageTankNo))
			return false;
		if (strength == null) {
			if (other.strength != null)
				return false;
		} else if (!strength.equals(other.strength))
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
		if (vehicleNum == null) {
			if (other.vehicleNum != null)
				return false;
		} else if (!vehicleNum.equals(other.vehicleNum))
			return false;
		if (wastage == null) {
			if (other.wastage != null)
				return false;
		} else if (!wastage.equals(other.wastage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReceiptsDts [requestId=" + requestId + ", receiptId=" + receiptId + ", cpeTpNo=" + cpeTpNo + ", dtpNo="
				+ dtpNo + ", receiptDate=" + receiptDate + ", vehicleNum=" + vehicleNum + ", remainingQty="
				+ remainingQty + ", strength=" + strength + ", storageTankNo=" + storageTankNo + ", dip=" + dip
				+ ", wastage=" + wastage + ", remarks=" + remarks + ", receivedQty=" + receivedQty + ", creationDate="
				+ creationDate + ", createdBy=" + createdBy + ", updatedDate=" + updatedDate + ", updatedBy="
				+ updatedBy + "]";
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Long getActualqty() {
		return actualqty;
	}

	public void setActualqty(Long actualqty) {
		this.actualqty = actualqty;
	}
	
	

	
	
}
