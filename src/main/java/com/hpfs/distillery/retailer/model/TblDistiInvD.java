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
@Table(name="disti_inv_d")
public class TblDistiInvD {
	
	@Override
	public String toString() {
		return "TblDistiInvD [inventoryDetId=" + inventoryDetId + ", inventoryId=" + inventoryId + ", healNumber="
				+ healNumber + ", creationDate=" + creationDate + ", createdBy=" + createdBy + ", updatedDate="
				+ updatedDate + ", updatedBy=" + updatedBy + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="inventory_det_id")
	public Long inventoryDetId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((healNumber == null) ? 0 : healNumber.hashCode());
		result = prime * result + ((inventoryDetId == null) ? 0 : inventoryDetId.hashCode());
		result = prime * result + ((inventoryId == null) ? 0 : inventoryId.hashCode());
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
		TblDistiInvD other = (TblDistiInvD) obj;
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
		if (healNumber == null) {
			if (other.healNumber != null)
				return false;
		} else if (!healNumber.equals(other.healNumber))
			return false;
		if (inventoryDetId == null) {
			if (other.inventoryDetId != null)
				return false;
		} else if (!inventoryDetId.equals(other.inventoryDetId))
			return false;
		if (inventoryId == null) {
			if (other.inventoryId != null)
				return false;
		} else if (!inventoryId.equals(other.inventoryId))
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

	@Column(name="inventory_id")
	public Long inventoryId;
	
	@Column(name="heal_number")
	public Long healNumber;
	
	@Column(name="creation_date")
	public String creationDate;

	@Column(name="created_by")
	public String createdBy;
	
	@Column(name="updated_date")
	public String updatedDate;

	@Column(name="updated_by")
	public String updatedBy;
	


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public Long getInventoryDetId() {
		return inventoryDetId;
	}

	public void setInventoryDetId(Long inventoryDetId) {
		this.inventoryDetId = inventoryDetId;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Long getHealNumber() {
		return healNumber;
	}

	public void setHealNumber(Long healNumber) {
		this.healNumber = healNumber;
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

	
	

}
