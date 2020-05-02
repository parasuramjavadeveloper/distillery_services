/**
 * 
 */
package com.hpfs.distillery.retailer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author babasaheb
 *
 */
@Entity
public class GridLicenseDts {
	
	@Id
	@Column(name="license_detail_id")
	public Long licenseDetailId;

	@Override
	public String toString() {
		return "GridLicenseDts [licenseDetailId=" + licenseDetailId + ", issuedDate=" + issuedDate + ", expiryDate="
				+ expiryDate + ", retailerCode=" + retailerCode + ", shopName=" + shopName + ", depotId=" + depotId
				+ ", depotName=" + depotName + ", userId=" + userId + ", mobileNumber=" + mobileNumber + ", emailId="
				+ emailId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((depotId == null) ? 0 : depotId.hashCode());
		result = prime * result + ((depotName == null) ? 0 : depotName.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((issuedDate == null) ? 0 : issuedDate.hashCode());
		result = prime * result + ((licenseDetailId == null) ? 0 : licenseDetailId.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((retailerCode == null) ? 0 : retailerCode.hashCode());
		result = prime * result + ((shopName == null) ? 0 : shopName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		GridLicenseDts other = (GridLicenseDts) obj;
		if (depotId == null) {
			if (other.depotId != null)
				return false;
		} else if (!depotId.equals(other.depotId))
			return false;
		if (depotName == null) {
			if (other.depotName != null)
				return false;
		} else if (!depotName.equals(other.depotName))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (issuedDate == null) {
			if (other.issuedDate != null)
				return false;
		} else if (!issuedDate.equals(other.issuedDate))
			return false;
		if (licenseDetailId == null) {
			if (other.licenseDetailId != null)
				return false;
		} else if (!licenseDetailId.equals(other.licenseDetailId))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (retailerCode == null) {
			if (other.retailerCode != null)
				return false;
		} else if (!retailerCode.equals(other.retailerCode))
			return false;
		if (shopName == null) {
			if (other.shopName != null)
				return false;
		} else if (!shopName.equals(other.shopName))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Column(name="issued_date")
	public String issuedDate;

	@Column(name="expiry_date")
	public String expiryDate;
	
	@Column(name="retailer_code")
	public String retailerCode;

	@Column(name="shop_name")
	public String shopName;

	@Column(name="depot_id")
	public Long depotId;

	@Column(name="depot_name")
	public String depotName;

	@Column(name="user_id")
	public Long userId;

	@Column(name="mobile_number")
	public String mobileNumber;
	
	@Column(name="email_id")
	public String emailId;
	
	public Long getLicenseDetailId() {
		return licenseDetailId;
	}

	public void setLicenseDetailId(Long licenseDetailId) {
		this.licenseDetailId = licenseDetailId;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getRetailerCode() {
		return retailerCode;
	}

	public void setRetailerCode(String retailerCode) {
		this.retailerCode = retailerCode;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Long getDepotId() {
		return depotId;
	}

	public void setDepotId(Long depotId) {
		this.depotId = depotId;
	}

	public String getDepotName() {
		return depotName;
	}

	public void setDepotName(String depotName) {
		this.depotName = depotName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	
}
