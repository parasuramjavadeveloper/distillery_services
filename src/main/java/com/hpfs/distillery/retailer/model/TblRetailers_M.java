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
@Table(name="retailers_m")
public class TblRetailers_M {

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((depotId == null) ? 0 : depotId.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((retailerCode == null) ? 0 : retailerCode.hashCode());
		result = prime * result + ((retailerType == null) ? 0 : retailerType.hashCode());
		result = prime * result + ((shopName == null) ? 0 : shopName.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
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
		TblRetailers_M other = (TblRetailers_M) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
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
		if (depotId == null) {
			if (other.depotId != null)
				return false;
		} else if (!depotId.equals(other.depotId))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (retailerCode == null) {
			if (other.retailerCode != null)
				return false;
		} else if (!retailerCode.equals(other.retailerCode))
			return false;
		if (retailerType == null) {
			if (other.retailerType != null)
				return false;
		} else if (!retailerType.equals(other.retailerType))
			return false;
		if (shopName == null) {
			if (other.shopName != null)
				return false;
		} else if (!shopName.equals(other.shopName))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TblRetailers_M [retailerCode=" + retailerCode + ", userId=" + userId + ", shopName=" + shopName
				+ ", owner=" + owner + ", contactNumber=" + contactNumber + ", address1=" + address1 + ", address2="
				+ address2 + ", depotId=" + depotId + ", status=" + status + ", retailerType=" + retailerType
				+ ", creationDate=" + creationDate + ", createdBy=" + createdBy + ", updatedDate=" + updatedDate
				+ ", updatedBy=" + updatedBy + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="retailer_code")
	public Long retailerCode;

	@Column(name="user_id")
	public String userId;

	@Column(name="shop_name")
	public String shopName;

	@Column(name="owner")
	public String owner;
	
	@Column(name="contact_number")
	public Long contactNumber;

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column(name="address_1")
	public String address1;

	@Column(name="address_2")
	public String address2;

	@Column(name="depot_id")
	public Long depotId;

	@Column(name="status")
	public String status;
	
	@Column(name="retailer_type")
	public String retailerType;

	@Column(name="creation_date")
	public String creationDate;

	@Column(name="created_by")
	public String createdBy;

	@Column(name="updated_date")
	public String updatedDate;

	@Column(name="updated_by")
	public String updatedBy;



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

	public Long getRetailerCode() {
		return retailerCode;
	}

	public void setRetailerCode(Long retailerCode) {
		this.retailerCode = retailerCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Long getDepotId() {
		return depotId;
	}

	public void setDepotId(Long depotId) {
		this.depotId = depotId;
	}
	
	public String getRetailerType() {
		return retailerType;
	}

	public void setRetailerType(String retailerType) {
		this.retailerType = retailerType;
	}

}
