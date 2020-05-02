package com.hpfs.distillery.retailer.dto;

	import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.hpfs.distillery.retailer.model.TblHologramDetails;

import lombok.Getter;
import lombok.Setter;

	/**
	 * @author Vamsi Alla
	 *
	 */
	@Getter
	@Setter
	public class HologramDetailsDto implements Serializable{
		
		private static final long serialVersionUID = 479854733025142531L;

		public Long indentNum;
		public String challanNum;
		public int challanAmount;
		public String challanDate;
		public String carrierName;
		public int quantity;
		public String purpose;
		public String stoBank;
		public String status;
		public String creationDate;
		public String createdBy;
		public String updatedDate;
		public String updatedBy;
		public List<TblHologramDetails> hologramList;
		
		// Setters and Getters
		
		public List<TblHologramDetails> getHologramList() {
			return hologramList;
		}
		public void setHologramList(List<TblHologramDetails> hologramList) {
			this.hologramList = hologramList;
		}
		public String getChallanNum() {
			return challanNum;
		}
		public Long getIndentNum() {
			return indentNum;
		}
		public void setIndentNum(Long indentNum) {
			this.indentNum = indentNum;
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
