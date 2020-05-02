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
@Table(name="vehicle_m")
public class TblVehicleM {
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Type == null) ? 0 : Type.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result + ((vehicleNum == null) ? 0 : vehicleNum.hashCode());
		result = prime * result + ((vehiclePOCName == null) ? 0 : vehiclePOCName.hashCode());
		result = prime * result + ((vehiclePOCNumber == null) ? 0 : vehiclePOCNumber.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "TblVehicleM [vehicleNum=" + vehicleNum + ", vehiclePOCName=" + vehiclePOCName + ", vehiclePOCNumber="
				+ vehiclePOCNumber + ", Type=" + Type + ", location=" + location + ", address=" + address + ", status="
				+ status + ", creationDate=" + creationDate + ", createdBy=" + createdBy + ", updatedDate="
				+ updatedDate + ", updatedBy=" + updatedBy + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TblVehicleM other = (TblVehicleM) obj;
		if (Type == null) {
			if (other.Type != null)
				return false;
		} else if (!Type.equals(other.Type))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
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
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
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
		if (vehicleNum == null) {
			if (other.vehicleNum != null)
				return false;
		} else if (!vehicleNum.equals(other.vehicleNum))
			return false;
		if (vehiclePOCName == null) {
			if (other.vehiclePOCName != null)
				return false;
		} else if (!vehiclePOCName.equals(other.vehiclePOCName))
			return false;
		if (vehiclePOCNumber == null) {
			if (other.vehiclePOCNumber != null)
				return false;
		} else if (!vehiclePOCNumber.equals(other.vehiclePOCNumber))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vehicle_num")
	public String vehicleNum;

	@Column(name="owner_name")
	public String vehiclePOCName;

	@Column(name="contact_number")
	public Long vehiclePOCNumber;

	@Column(name="type")
	public String Type;

	@Column(name="location")
	public String location;
	
	@Column(name="address")
	public String address;

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

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public String getVehiclePOCName() {
		return vehiclePOCName;
	}

	public void setVehiclePOCName(String vehiclePOCName) {
		this.vehiclePOCName = vehiclePOCName;
	}

	public Long getVehiclePOCNumber() {
		return vehiclePOCNumber;
	}

	public void setVehiclePOCNumber(Long vehiclePOCNumber) {
		this.vehiclePOCNumber = vehiclePOCNumber;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
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
