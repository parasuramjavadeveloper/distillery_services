package com.hpfs.distillery.retailer.model;
import java.sql.Date;

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
	@Table(name="heal_purchase_indent")
	public class TblHologramDetails {
        @Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="indent_num")
		public Long indentNum;

		@Column(name="challan_num")
		public String challanNum;

		@Column(name="challan_amount")
		public int challanAmount;

		@Column(name="challan_date")
		public String challanDate;
		
		@Column(name="carrier_name")
		public String carrierName;

		@Column(name="quantity")
		public int quantity;

		@Column(name="purpose")
		public String purpose;

		@Column(name="sto_bank")
		public String stoBank;
		
		@Column(name="status")
		public String status;
		
		@Column(name="creation_date")
		public String creationDate;

		@Column(name="created_by")
		public String createdBy;

		@Column(name="updated_date")
		public String updatedDate;

		@Column(name="updated_by")
		public String updatedBy;

		public Long getIndentNum() {
			return indentNum;
		}

		public void setIndentNum(Long indentNum) {
			this.indentNum = indentNum;
		}

		public String getChallanNum() {
			return challanNum;
		}

		public void setChallanNum(String challanNum) {
			this.challanNum = challanNum;
		}

		public int getChallanAmount() {
			return challanAmount;
		}

		public void setChallanAmount(int challanAmount) {
			this.challanAmount = challanAmount;
		}

		public String getChallanDate() {
			return challanDate;
		}

		public void setChallanDate(String challanDate) {
			this.challanDate = challanDate;
		}

		public String getCarrierName() {
			return carrierName;
		}

		public void setCarrierName(String carrierName) {
			this.carrierName = carrierName;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getPurpose() {
			return purpose;
		}

		public void setPurpose(String purpose) {
			this.purpose = purpose;
		}

		public String getStoBank() {
			return stoBank;
		}

		public void setStoBank(String stoBank) {
			this.stoBank = stoBank;
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
