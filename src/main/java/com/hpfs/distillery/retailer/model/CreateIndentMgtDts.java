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
//@Table(name="indent_m")
public class CreateIndentMgtDts {
	
	@Id
	@Column(name="retailer_code")
	public Long retailerCode;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorisedPerson == null) ? 0 : authorisedPerson.hashCode());
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((depotId == null) ? 0 : depotId.hashCode());
		result = prime * result + ((depotName == null) ? 0 : depotName.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((retailerCode == null) ? 0 : retailerCode.hashCode());
		result = prime * result + ((shopName == null) ? 0 : shopName.hashCode());
		result = prime * result + ((vehicleNumber == null) ? 0 : vehicleNumber.hashCode());
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
		CreateIndentMgtDts other = (CreateIndentMgtDts) obj;
		if (authorisedPerson == null) {
			if (other.authorisedPerson != null)
				return false;
		} else if (!authorisedPerson.equals(other.authorisedPerson))
			return false;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
			return false;
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
		if (vehicleNumber == null) {
			if (other.vehicleNumber != null)
				return false;
		} else if (!vehicleNumber.equals(other.vehicleNumber))
			return false;
		return true;
	}

	@Column(name="depot_id")
	public Long depotId;

	@Column(name="shop_name")
	public String shopName;

	@Column(name="depot_name")
	public String depotName;
	

	public Long getRetailerCode() {
		return retailerCode;
	}

	public void setRetailerCode(Long retailerCode) {
		this.retailerCode = retailerCode;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column(name="location")
	public String location;

	@Column(name="district")
	public String district;

	@Column(name="owner")
	public String authorisedPerson;
	
	@Column(name="vehicle_num")
	public String vehicleNumber;

	@Column(name="contact_number")
	public String contactNumber;


	

	public String getDepotName() {
		return depotName;
	}

	public void setDepotName(String depotName) {
		this.depotName = depotName;
	}
	public Long getDepotId() {
		return depotId;
	}

	public void setDepotId(Long depotId) {
		this.depotId = depotId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAuthorisedPerson() {
		return authorisedPerson;
	}

	public void setAuthorisedPerson(String authorisedPerson) {
		this.authorisedPerson = authorisedPerson;
	}

	

	

	}
