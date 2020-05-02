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
@Table(name = "supplier_m")
public class TblSupplierM {

	@Override
	public String toString() {
		return "TblSupplierM [supplierId=" + supplierId + ", supplierName=" + supplierName + ", contactNumber="
				+ contactNumber + ", billToLocation=" + billToLocation + ", shipToLocation=" + shipToLocation
				+ ", address=" + address + ", statename=" + statename + ", countryname=" + countryname + ", status=" + status + ", creationDate=" + creationDate + ", createdBy="
				+ createdBy + ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "supplier_id")
	public Long supplierId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((statename == null) ? 0 : statename.hashCode());
		result = prime * result + ((countryname == null) ? 0 : countryname.hashCode());
		result = prime * result + ((billToLocation == null) ? 0 : billToLocation.hashCode());
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((shipToLocation == null) ? 0 : shipToLocation.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((supplierId == null) ? 0 : supplierId.hashCode());
		result = prime * result + ((supplierName == null) ? 0 : supplierName.hashCode());
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
		TblSupplierM other = (TblSupplierM) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if(statename == null) {
			if(other.statename != null)
				return false;
		} else if (!statename.equals(other.statename))
			return false;
		if(countryname == null) {
			if(other.countryname != null)
				return false;
		} else if (!countryname.equals(other.countryname))
			return false;
		if (billToLocation == null) {
			if (other.billToLocation != null)
				return false;
		} else if (!billToLocation.equals(other.billToLocation))
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
		if (shipToLocation == null) {
			if (other.shipToLocation != null)
				return false;
		} else if (!shipToLocation.equals(other.shipToLocation))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (supplierId == null) {
			if (other.supplierId != null)
				return false;
		} else if (!supplierId.equals(other.supplierId))
			return false;
		if (supplierName == null) {
			if (other.supplierName != null)
				return false;
		} else if (!supplierName.equals(other.supplierName))
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

	@Column(name = "supplier_name")
	public String supplierName;

	@Column(name = "contact_number")
	public String contactNumber;

	@Column(name = "bill_to_location")
	public String billToLocation;

	@Column(name = "ship_to_location")
	public String shipToLocation;

	@Column(name = "address")
	public String address;

	@Column(name = "state_name")
	public String statename;

	@Column(name = "country_name")
	public String countryname;

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

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getBillToLocation() {
		return billToLocation;
	}

	public void setBillToLocation(String billToLocation) {
		this.billToLocation = billToLocation;
	}

	public String getShipToLocation() {
		return shipToLocation;
	}

	public void setShipToLocation(String shipToLocation) {
		this.shipToLocation = shipToLocation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
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
