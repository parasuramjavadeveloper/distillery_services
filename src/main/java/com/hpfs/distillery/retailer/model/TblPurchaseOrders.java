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
@Table(name="purchase_orders")
public class TblPurchaseOrders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="request_id")
	public Long requestId;

	@Column(name="type")
	public String type;

	@Override
	public String toString() {
		return "TblPurchaseOrders [requestId=" + requestId + ", type=" + type + ", requestedDate=" + requestedDate
				+ ", subject=" + subject + ", refNum=" + refNum + ", refDate=" + refDate + ", status=" + status
				+ ", allotedQuota=" + allotedQuota + ", requestedQty=" + requestedQty + ", receivedQty=" + receivedQty
				+ ", approvedBy=" + approvedBy + ", approvedDate=" + approvedDate + ", supplierId=" + supplierId
				+ ", supplierName=" + supplierName + ", receiptId=" + receiptId + ", receiptStatus=" + receiptStatus
				+ ", creationDate=" + creationDate + ", createdBy=" + createdBy + ", updatedDate=" + updatedDate
				+ ", updatedBy=" + updatedBy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allotedQuota == null) ? 0 : allotedQuota.hashCode());
		result = prime * result + ((approvedBy == null) ? 0 : approvedBy.hashCode());
		result = prime * result + ((approvedDate == null) ? 0 : approvedDate.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((receiptId == null) ? 0 : receiptId.hashCode());
		result = prime * result + ((receiptStatus == null) ? 0 : receiptStatus.hashCode());
		result = prime * result + ((receivedQty == null) ? 0 : receivedQty.hashCode());
		result = prime * result + ((refDate == null) ? 0 : refDate.hashCode());
		result = prime * result + ((refNum == null) ? 0 : refNum.hashCode());
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((requestedDate == null) ? 0 : requestedDate.hashCode());
		result = prime * result + ((requestedQty == null) ? 0 : requestedQty.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((supplierId == null) ? 0 : supplierId.hashCode());
		result = prime * result + ((supplierName == null) ? 0 : supplierName.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		TblPurchaseOrders other = (TblPurchaseOrders) obj;
		if (allotedQuota == null) {
			if (other.allotedQuota != null)
				return false;
		} else if (!allotedQuota.equals(other.allotedQuota))
			return false;
		if (approvedBy == null) {
			if (other.approvedBy != null)
				return false;
		} else if (!approvedBy.equals(other.approvedBy))
			return false;
		if (approvedDate == null) {
			if (other.approvedDate != null)
				return false;
		} else if (!approvedDate.equals(other.approvedDate))
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
		if (receiptId == null) {
			if (other.receiptId != null)
				return false;
		} else if (!receiptId.equals(other.receiptId))
			return false;
		if (receiptStatus == null) {
			if (other.receiptStatus != null)
				return false;
		} else if (!receiptStatus.equals(other.receiptStatus))
			return false;
		if (receivedQty == null) {
			if (other.receivedQty != null)
				return false;
		} else if (!receivedQty.equals(other.receivedQty))
			return false;
		if (refDate == null) {
			if (other.refDate != null)
				return false;
		} else if (!refDate.equals(other.refDate))
			return false;
		if (refNum == null) {
			if (other.refNum != null)
				return false;
		} else if (!refNum.equals(other.refNum))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (requestedDate == null) {
			if (other.requestedDate != null)
				return false;
		} else if (!requestedDate.equals(other.requestedDate))
			return false;
		if (requestedQty == null) {
			if (other.requestedQty != null)
				return false;
		} else if (!requestedQty.equals(other.requestedQty))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (supplierId == null) {
			if (other.supplierId != null)
				return false;
		} else if (!supplierId.equals(other.supplierId))
			return false;
		if (supplierName == null) {
			if (other.supplierName != null)
				return false;
		} else if (!supplierName.equals(other.supplierName))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
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

	@Column(name="requested_date")
	public String requestedDate;

	@Column(name="subject")
	public String subject;
	
	@Column(name="ref_num")
	public String refNum;
	
	@Column(name="ref_date")
	public String refDate;
	
	@Column(name="status")
	public String status;
	
	@Column(name="alloted_quota")
	public Long allotedQuota;
	
	

	@Column(name="requested_qty")
	public Long requestedQty;
	
	@Column(name="received_qty")
	public Long receivedQty;
	
	@Column(name="approved_by")
	public String approvedBy;
	
	@Column(name="approved_date")
	public String approvedDate;
	
	@Column(name="supplier_id")
	public Long supplierId;
	
	@Column(name="supplier_name")
	public String supplierName;
	
	
	@Column(name="receipt_id")
	public Long receiptId;
	
	@Column(name="receipt_status")
	public String receiptStatus;
	
	
	
	public Long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}

	public String getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(String receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Column(name="creation_date")
	public String creationDate;

	@Column(name="created_by")
	public String createdBy;

	@Column(name="updated_date")
	public String updatedDate;

	@Column(name="updated_by")
	public String updatedBy;
	

	

	public String getRefDate() {
		return refDate;
	}

	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}

	public Long getSupplierId() {
		return supplierId;
	}
	
	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRefNum() {
		return refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}

	public Long getAllotedQuota() {
		return allotedQuota;
	}

	public void setAllotedQuota(Long allotedQuota) {
		this.allotedQuota = allotedQuota;
	}

	public Long getRequestedQty() {
		return requestedQty;
	}

	public void setRequestedQty(Long requestedQty) {
		this.requestedQty = requestedQty;
	}

	public Long getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(Long receivedQty) {
		this.receivedQty = receivedQty;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
