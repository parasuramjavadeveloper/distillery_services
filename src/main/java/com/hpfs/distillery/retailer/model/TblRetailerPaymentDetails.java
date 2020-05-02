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
	@Table(name="retailer_payment_d")
	public class TblRetailerPaymentDetails {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="retailer_payment_id")
		public int retailerPaymentId;

		@Column(name="retailer_code")
		public String retailerCode;

		@Column(name="payment_date")
		public Date paymentDate;

		@Column(name="payment_type")
		public String paymentType;

		@Column(name="status")
		public String status;

		@Column(name="amount")
		public double amount;

		@Column(name="cheque_number")
		public String chequeNumber;

		@Column(name="creation_date")
		public String creationDate;

		@Column(name="created_by")
		public String createdBy;

		@Column(name="updated_date")
		public String updatedDate;

		@Column(name="updated_by")
		public String updatedBy;

		public int getRetailerPaymentId() {
			return retailerPaymentId;
		}

		public void setRetailerPaymentId(int retailerPaymentId) {
			this.retailerPaymentId = retailerPaymentId;
		}

		public String getRetailerCode() {
			return retailerCode;
		}

		public void setRetailerCode(String retailerCode) {
			this.retailerCode = retailerCode;
		}

		public java.util.Date getPaymentDate() {
			return paymentDate;
		}

		public void setPaymentDate(Date paymentDate) {
			this.paymentDate = paymentDate;
		}

		public String getPaymentType() {
			return paymentType;
		}

		public void setPaymentType(String paymentType) {
			this.paymentType = paymentType;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getChequeNumber() {
			return chequeNumber;
		}

		public void setChequeNumber(String chequeNumber) {
			this.chequeNumber = chequeNumber;
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
