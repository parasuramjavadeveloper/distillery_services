package com.hpfs.distillery.retailer.dto;

import javax.persistence.Column;

/**
 * @author manikanta
 *
 */
public class WalletAmountupdDto {

	
	public String retailerCode;
	public Long amount;
	public Long user_Id;
	public String updatedBy;
	public String transactionType;
	public Long indentId;
	public String challanNumber;
	public String challanDate;
	public String bankName;
	public String bankLocation;
	
	
	public String getRetailerCode() {
		return retailerCode;
	}
	public void setRetailerCode(String retailerCode) {
		this.retailerCode = retailerCode;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Long getIndentId() {
		return indentId;
	}
	public void setIndentId(Long indentId) {
		this.indentId = indentId;
	}
	public String getChallanNumber() {
		return challanNumber;
	}
	public void setChallanNumber(String challanNumber) {
		this.challanNumber = challanNumber;
	}
	public String getChallanDate() {
		return challanDate;
	}
	public void setChallanDate(String challanDate) {
		this.challanDate = challanDate;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankLocation() {
		return bankLocation;
	}
	public void setBankLocation(String bankLocation) {
		this.bankLocation = bankLocation;
	}
	
	
	
}
