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
public class GridIndentMgtDts {
	
	@Override
	public String toString() {
		return "GridIndentMgtDts [depotId=" + depotId + ", shopName=" + shopName + ", depotName=" + depotName
				+ ", indentCreationDate=" + indentCreationDate + ", location=" + location + ", district=" + district
				+ ", authorisedPerson=" + authorisedPerson + ", creationDate=" + creationDate + ", createdBy="
				+ createdBy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorisedPerson == null) ? 0 : authorisedPerson.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((depotId == null) ? 0 : depotId.hashCode());
		result = prime * result + ((depotName == null) ? 0 : depotName.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((indentCreationDate == null) ? 0 : indentCreationDate.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((shopName == null) ? 0 : shopName.hashCode());
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
		GridIndentMgtDts other = (GridIndentMgtDts) obj;
		if (authorisedPerson == null) {
			if (other.authorisedPerson != null)
				return false;
		} else if (!authorisedPerson.equals(other.authorisedPerson))
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
		if (indentCreationDate == null) {
			if (other.indentCreationDate != null)
				return false;
		} else if (!indentCreationDate.equals(other.indentCreationDate))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (shopName == null) {
			if (other.shopName != null)
				return false;
		} else if (!shopName.equals(other.shopName))
			return false;
		return true;
	}

	@Id
	@Column(name="depot_id")
	public Long depotId;

	@Column(name="shop_name")
	public String shopName;

	@Column(name="depot_name")
	public String depotName;
	
	@Column(name="indent_creation_date")
	public String indentCreationDate;

	@Column(name="location")
	public String location;

	@Column(name="district")
	public String district;

	@Column(name="authorised_person")
	public String authorisedPerson;

	@Column(name="creation_date")
	public String creationDate;

	@Column(name="created_by")
	public String createdBy;

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

	public String getIndentCreationDate() {
		return indentCreationDate;
	}

	public void setIndentCreationDate(String indentCreationDate) {
		this.indentCreationDate = indentCreationDate;
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

	

	}
