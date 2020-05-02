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
@Table(name = "distilleries_m")
public class TblDistilleries {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "destillery_id")
	public Long destilleryId;

	@Column(name = "name")
	public String destilleryName;

	@Column(name = "location")
	public String location;

	@Column(name = "address")
	public String address;

	@Column(name = "district")
	public String district;

	@Column(name = "state")
	public String state;

	@Column(name = "country_code")
	public String countryCode;

	@Column(name = "status")
	public String status;

	@Column(name = "creation_date")
	public String creationDate;

	@Column(name = "created_by")
	public String createdBy;

	@Column(name = "updated_date")
	public String updatedDate;

	@Column(name = "updated_by")
	public String updatedBy;

	public Long getDestilleryId() {
		return destilleryId;
	}

	public void setDestilleryId(Long destilleryId) {
		this.destilleryId = destilleryId;
	}

	public String getDestilleryName() {
		return destilleryName;
	}

	public void setDestilleryName(String destilleryName) {
		this.destilleryName = destilleryName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((destilleryId == null) ? 0 : destilleryId.hashCode());
		result = prime * result + ((destilleryName == null) ? 0 : destilleryName.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		TblDistilleries other = (TblDistilleries) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
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
		if (destilleryId == null) {
			if (other.destilleryId != null)
				return false;
		} else if (!destilleryId.equals(other.destilleryId))
			return false;
		if (destilleryName == null) {
			if (other.destilleryName != null)
				return false;
		} else if (!destilleryName.equals(other.destilleryName))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
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
		return true;
	}

	@Override
	public String toString() {
		return "TblDistilleries [destilleryId=" + destilleryId + ", destilleryName=" + destilleryName + ", location="
				+ location + ", address=" + address + ", district=" + district + ", state=" + state + ", countryCode="
				+ countryCode + ", status=" + status + ", creationDate=" + creationDate + ", createdBy=" + createdBy
				+ ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy + "]";
	}

}
