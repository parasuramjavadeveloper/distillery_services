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
@Table(name="indent_d")
public class TblIndent_D {

	@Override
	public String toString() {
		return "TblIndent_D [indentDetailId=" + indentDetailId + ", indentId=" + indentId + ", productCode="
				+ productCode + ", barCode=" + barCode + ", productDescription=" + productDescription + ", noOfUnits="
				+ noOfUnits + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + ", creationDate="
				+ creationDate + ", createdBy=" + createdBy + ", updatedDate=" + updatedDate + ", updatedBy="
				+ updatedBy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barCode == null) ? 0 : barCode.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((indentDetailId == null) ? 0 : indentDetailId.hashCode());
		result = prime * result + ((indentId == null) ? 0 : indentId.hashCode());
		result = prime * result + ((noOfUnits == null) ? 0 : noOfUnits.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + Float.floatToIntBits(totalPrice);
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
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
		TblIndent_D other = (TblIndent_D) obj;
		if (barCode == null) {
			if (other.barCode != null)
				return false;
		} else if (!barCode.equals(other.barCode))
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
		if (indentDetailId == null) {
			if (other.indentDetailId != null)
				return false;
		} else if (!indentDetailId.equals(other.indentDetailId))
			return false;
		if (indentId == null) {
			if (other.indentId != null)
				return false;
		} else if (!indentId.equals(other.indentId))
			return false;
		if (noOfUnits == null) {
			if (other.noOfUnits != null)
				return false;
		} else if (!noOfUnits.equals(other.noOfUnits))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (Float.floatToIntBits(totalPrice) != Float.floatToIntBits(other.totalPrice))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="indent_detail_id")
	public Long indentDetailId;

	@Column(name="indent_id")
	public Long indentId;

	@Column(name="product_code")
	public String productCode;

	@Column(name="bar_code")
	public String barCode;

	@Column(name="product_description")
	public String productDescription;

	@Column(name="no_of_units")
	public Long noOfUnits;

	@Column(name="unit_price")
	public Long unitPrice;

	@Column(name="totalPrice")
	public float totalPrice;

	@Column(name="creation_date")
	public String creationDate;

	@Column(name="created_by")
	public String createdBy;

	@Column(name="updated_date")
	public String updatedDate;

	@Column(name="updated_by")
	public String updatedBy;

	public Long getIndentDetailId() {
		return indentDetailId;
	}

	public void setIndentDetailId(Long indentDetailId) {
		this.indentDetailId = indentDetailId;
	}

	public Long getIndentId() {
		return indentId;
	}

	public void setIndentId(Long indentId) {
		this.indentId = indentId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Long getNoOfUnits() {
		return noOfUnits;
	}

	public void setNoOfUnits(Long noOfUnits) {
		this.noOfUnits = noOfUnits;
	}

	public Long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotal_price(float total_price) {
		this.totalPrice = total_price;
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
