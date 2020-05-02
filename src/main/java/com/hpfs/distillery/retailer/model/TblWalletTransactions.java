package com.hpfs.distillery.retailer.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author manikanta
 *
 */
@Entity
@Table(name="wallet_transactions")
public class TblWalletTransactions {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public int walletTransactionId;
	
	
	@Column(name="retailer_code")
	public String retailerCode;
	
	@Column(name="user_id")
	public Long userId;
	
	@Column(name="Type")
	public String type;
	
	@Column(name="Amount")
	public Long amount;
	
	@Column(name="indent_id")
	public Long indentId;
	
	@Column(name="challan_date")
	public String challanDate;
	
	@Column(name="challan_number")
	public String challanNumber;
	
	@Column(name="bank_name")
	public String bankName;
	
	@Column(name="bank_location")
	public String bankLocation;
	
	@Column(name="trans_date")
	public String transactionDate;

	@Override
	public String toString() {
		return "TblWalletTransactions [walletTransactionId=" + walletTransactionId + ", retailerCode=" + retailerCode
				+ ", userId=" + userId + ", type=" + type + ", amount=" + amount + ", indentId=" + indentId
				+ ", challanDate=" + challanDate + ", challanNumber=" + challanNumber + ", bankName=" + bankName
				+ ", bankLocation=" + bankLocation + ", transactionDate=" + transactionDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((bankLocation == null) ? 0 : bankLocation.hashCode());
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((challanDate == null) ? 0 : challanDate.hashCode());
		result = prime * result + ((challanNumber == null) ? 0 : challanNumber.hashCode());
		result = prime * result + ((indentId == null) ? 0 : indentId.hashCode());
		result = prime * result + ((retailerCode == null) ? 0 : retailerCode.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + walletTransactionId;
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
		TblWalletTransactions other = (TblWalletTransactions) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (bankLocation == null) {
			if (other.bankLocation != null)
				return false;
		} else if (!bankLocation.equals(other.bankLocation))
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (challanDate == null) {
			if (other.challanDate != null)
				return false;
		} else if (!challanDate.equals(other.challanDate))
			return false;
		if (challanNumber == null) {
			if (other.challanNumber != null)
				return false;
		} else if (!challanNumber.equals(other.challanNumber))
			return false;
		if (indentId == null) {
			if (other.indentId != null)
				return false;
		} else if (!indentId.equals(other.indentId))
			return false;
		if (retailerCode == null) {
			if (other.retailerCode != null)
				return false;
		} else if (!retailerCode.equals(other.retailerCode))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (walletTransactionId != other.walletTransactionId)
			return false;
		return true;
	}

	public int getWalletTransactionId() {
		return walletTransactionId;
	}

	public void setWalletTransactionId(int walletTransactionId) {
		this.walletTransactionId = walletTransactionId;
	}

	public String getRetailerCode() {
		return retailerCode;
	}

	public void setRetailerCode(String retailerCode) {
		this.retailerCode = retailerCode;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getIndentId() {
		return indentId;
	}

	public void setIndentId(Long indentId) {
		this.indentId = indentId;
	}

	public String getChallanDate() {
		return challanDate;
	}

	public void setChallanDate(String challanDate) {
		this.challanDate = challanDate;
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

	public String getBankLocation() {
		return bankLocation;
	}

	public void setBankLocation(String bankLocation) {
		this.bankLocation = bankLocation;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
	
	
	
	
}
