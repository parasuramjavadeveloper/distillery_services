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
@Table(name="indent_m")
public class TblIndent_M {

	@Override
	public String toString() {
		return "TblIndent_M [indentId=" + indentId + ", retailerCode=" + retailerCode + ", indentCreationDate="
				+ indentCreationDate + ", needByDate=" + needByDate + ", authorisedPerson=" + authorisedPerson
				+ ", contactNumber=" + contactNumber + ", vehicleNumber=" + vehicleNumber + ", description="
				+ description + ", status=" + status + ", creationDate=" + creationDate + ", createdBy=" + createdBy
				+ ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorisedPerson == null) ? 0 : authorisedPerson.hashCode());
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((indentCreationDate == null) ? 0 : indentCreationDate.hashCode());
		result = prime * result + ((indentId == null) ? 0 : indentId.hashCode());
		result = prime * result + ((needByDate == null) ? 0 : needByDate.hashCode());
		result = prime * result + ((retailerCode == null) ? 0 : retailerCode.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
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
		TblIndent_M other = (TblIndent_M) obj;
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (indentCreationDate == null) {
			if (other.indentCreationDate != null)
				return false;
		} else if (!indentCreationDate.equals(other.indentCreationDate))
			return false;
		if (indentId == null) {
			if (other.indentId != null)
				return false;
		} else if (!indentId.equals(other.indentId))
			return false;
		if (needByDate == null) {
			if (other.needByDate != null)
				return false;
		} else if (!needByDate.equals(other.needByDate))
			return false;
		if (retailerCode == null) {
			if (other.retailerCode != null)
				return false;
		} else if (!retailerCode.equals(other.retailerCode))
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
		if (vehicleNumber == null) {
			if (other.vehicleNumber != null)
				return false;
		} else if (!vehicleNumber.equals(other.vehicleNumber))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="indent_id")
	public Long indentId;

	@Column(name="retailer_code")
	public String retailerCode;

	@Column(name="indent_creation_date")
	public String indentCreationDate;

	@Column(name="need_by_date")
	public String needByDate;

	@Column(name="authorised_person")
	public String authorisedPerson;

	@Column(name="contact_number")
	public Long contactNumber;

	@Column(name="vehicle_number")
	public String vehicleNumber;

	@Column(name="description")
	public String description;

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

	public Long getIndentId() {
		return indentId;
	}

	public void setIndentId(Long indentId) {
		this.indentId = indentId;
	}

	public String getRetailerCode() {
		return retailerCode;
	}

	public void setRetailerCode(String retailerCode) {
		this.retailerCode = retailerCode;
	}

	public String getIndentCreationDate() {
		return indentCreationDate;
	}

	public void setIndentCreationDate(String indentCreationDate) {
		this.indentCreationDate = indentCreationDate;
	}

	public String getNeedByDate() {
		return needByDate;
	}

	public void setNeedByDate(String needByDate) {
		this.needByDate = needByDate;
	}

	public String getAuthorisedPerson() {
		return authorisedPerson;
	}

	public void setAuthorisedPerson(String authorisedPerson) {
		this.authorisedPerson = authorisedPerson;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
