/**
 * 
 */
package com.hpfs.distillery.retailer.model;

import java.io.Serializable;

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
@Table(name="wallet")
public class TblWallet implements Serializable{
	
	private static final long serialVersionUID = -2094628535845468338L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	public Long walletId;

	@Column(name="retailer_code")
	public String retailerCode;

	@Column(name="available_balance")
	public Long availableBalance;
	
	@Column(name="previous_balance")
	public Long previousBalance;

	@Column(name="amount_added")
	public Long amountAdded;

	@Column(name="added_date")
	public String addedDate;
	
	@Column(name="wallet_amount")
	public Long walletAmount;

	@Column(name="txn_reference_number")
	public Long txnRefNum;

	@Column(name="user_id")
	public Long userId;

	//newly added columns start
	@Column(name="retailer_name")
	public String retailerName;
	
	@Column(name="retailer_type")
	public String retailerType;
	
	@Column(name="status")
	public String status;
	
	@Column(name="challan_number")
	public String challanNumber;
	
	@Column(name="bank_name")
	public String bankName;
	
	@Column(name="challan_place")
	public String challanPlace;
	
	@Column(name="deposit_amount")
	public String depositAmount;
	
	@Column(name="date")
	public String date;
	
//	@Column(name="otp")
//	public int otp;
	
	@Column(name="file_name")
	public String fileName;
	

	@Column(name="creation_date")
	public String creationDate;

	@Column(name="created_by")
	public String createdBy;

	public String getChallanPlace() {
		return challanPlace;
	}

	public void setChallanPlace(String challanPlace) {
		this.challanPlace = challanPlace;
	}

	public String getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(String depositAmount) {
		this.depositAmount = depositAmount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name="updated_date")
	public String updatedDate;

	@Column(name="updated_by")
	public String updatedBy;

	public Long getWalletId() {
		return walletId;
	}

	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}

	public String getRetailerCode() {
		return retailerCode;
	}

	public void setRetailerCode(String retailerCode) {
		this.retailerCode = retailerCode;
	}

	
	public String getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}

	public Long getWalletAmount() {
		return walletAmount;
	}

	public void setWalletAmount(Long walletAmount) {
		this.walletAmount = walletAmount;
	}

	public Long getTxnRefNum() {
		return txnRefNum;
	}

	public void setTxnRefNum(Long txnRefNum) {
		this.txnRefNum = txnRefNum;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public String getRetailerType() {
		return retailerType;
	}

	public void setRetailerType(String retailerType) {
		this.retailerType = retailerType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getChallanNumber() {
		return challanNumber;
	}

	public void setChallanNumber(String challanNumber) {
		this.challanNumber = challanNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getChallan_Place() {
		return challanPlace;
	}

	public void setChallan_Place(String challanPlace) {
		this.challanPlace = challanPlace;
	}

//	public int getOtp() {
//		return otp;
//	}
//
//	public void setOtp(int otp) {
//		this.otp = otp;
//	}

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

	public Long getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Long availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Long getPreviousBalance() {
		return previousBalance;
	}

	public void setPreviousBalance(Long previousBalance) {
		this.previousBalance = previousBalance;
	}

	public Long getAmountAdded() {
		return amountAdded;
	}

	public void setAmountAdded(Long amountAdded) {
		this.amountAdded = amountAdded;
	}

	

	

	
}
