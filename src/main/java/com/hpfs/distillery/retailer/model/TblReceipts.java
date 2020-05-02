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
@Table(name="receipts")
public class TblReceipts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="receipt_id")
	public Long receiptId;

	@Column(name="cpe_tp_no")
	public String cpeTpNo;
	
	@Column(name="dtp_no")
	public String dtpNo;
	
	@Column(name="receipt_date")
	public String receiptDate;
	
	@Column(name="vehicle_num")
	public String vehicleNum;
	
	@Column(name="actual_qty")
	public Long actualqty;
	
	@Column(name="remaining_qty")
	public Long remainingQty;
	
	@Column(name="strength")
	public Long strength;
	
	@Column(name="storage_tank_no")
	public String storageTankNo;
	
	@Column(name="supplier_name")
	public String supplierName;
	
	@Column(name="dip")
	public Long dip;
	
	@Column(name="wastage")
	public Long wastage;
	
	@Column(name="remarks")
	public String remarks;
	
	@Column(name="received_qty")
	public Long receivedQty;
	
	@Column(name="creation_date")
	public String creationDate;

	@Column(name="created_by")
	public String createdBy;

	@Column(name="updated_date")
	public String updatedDate;

	@Column(name="updated_by")
	public String updatedBy;
	
	@Column(name="invoice_date")
	public String invoiceDate;
	
	@Column(name="invoice_no")
	public String invoiceNo;
	
	@Column(name="invoice_amt")
	public String invoiceAmt;
	
	@Column(name="tax_amt")
	public String taxAmt;

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceAmt() {
		return invoiceAmt;
	}

	public void setInvoiceAmt(String invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}

	public String getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}

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

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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
		result = prime * result + ((invoiceAmt == null) ? 0 : invoiceAmt.hashCode());
		result = prime * result + ((invoiceNo == null) ? 0 : invoiceNo.hashCode());
		result = prime * result + ((receiptDate == null) ? 0 : receiptDate.hashCode());
		result = prime * result + ((receiptId == null) ? 0 : receiptId.hashCode());
		result = prime * result + ((receivedQty == null) ? 0 : receivedQty.hashCode());
		result = prime * result + ((remainingQty == null) ? 0 : remainingQty.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((storageTankNo == null) ? 0 : storageTankNo.hashCode());
		result = prime * result + ((strength == null) ? 0 : strength.hashCode());
		result = prime * result + ((supplierName == null) ? 0 : supplierName.hashCode());
		result = prime * result + ((taxAmt == null) ? 0 : taxAmt.hashCode());
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
		TblReceipts other = (TblReceipts) obj;
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
		if (invoiceAmt == null) {
			if (other.invoiceAmt != null)
				return false;
		} else if (!invoiceAmt.equals(other.invoiceAmt))
			return false;
		if (invoiceNo == null) {
			if (other.invoiceNo != null)
				return false;
		} else if (!invoiceNo.equals(other.invoiceNo))
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
		if (supplierName == null) {
			if (other.supplierName != null)
				return false;
		} else if (!supplierName.equals(other.supplierName))
			return false;
		if (taxAmt == null) {
			if (other.taxAmt != null)
				return false;
		} else if (!taxAmt.equals(other.taxAmt))
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
		return "TblReceipts [receiptId=" + receiptId + ", cpeTpNo=" + cpeTpNo + ", dtpNo=" + dtpNo + ", receiptDate="
				+ receiptDate + ", vehicleNum=" + vehicleNum + ", remainingQty=" + remainingQty + ", strength="
				+ strength + ", storageTankNo=" + storageTankNo + ", supplierName=" + supplierName + ", dip=" + dip
				+ ", wastage=" + wastage + ", remarks=" + remarks + ", receivedQty=" + receivedQty + ", creationDate="
				+ creationDate + ", createdBy=" + createdBy + ", updatedDate=" + updatedDate + ", updatedBy="
				+ updatedBy + ", invoiceNo=" + invoiceNo + ", invoiceAmt=" + invoiceAmt + ", taxAmt=" + taxAmt + "]";
	}

	public Long getActualqty() {
		return actualqty;
	}

	public void setActualqty(Long actualqty) {
		this.actualqty = actualqty;
	}
	
	

	
	
}
