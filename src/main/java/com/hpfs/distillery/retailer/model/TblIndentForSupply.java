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

import org.hibernate.annotations.GenericGenerator;

/**
 * @author babasaheb
 *
 */
@Entity
@Table(name="indent_for_supply")
public class TblIndentForSupply {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="indent_no")
	private String indentNo;
	
	@Column(name="product_code")
	private String productCode;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Column(name="distillery_id")
	private Long distilleryId;

	@Column(name="depot_id")
	private Long depotId;
	
	@Column(name="status")
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="indent_date")
	private String indentDate;

	@Column(name="brand_name")
	private String brandName;
	
	@Column(name="size")
	private Long size;
	
	@Column(name="qty_in_cases")
	private Long qtyInCases;
	
	@Column(name="rate_per_case")
	private Float ratePerCase;
	
	@Column(name="total_amount")
	private Float totalAmount;
	
	@Column(name="creation_date")
	private String creationDate;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="updated_date")
	private String updatedDate;

	@Column(name="updated_by")
	private String updatedBy;

	public String getIndentNo() {
		return indentNo;
	}

	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
	}

	public Long getDistilleryId() {
		return distilleryId;
	}

	public void setDistilleryId(Long distilleryId) {
		this.distilleryId = distilleryId;
	}

	public Long getDepotId() {
		return depotId;
	}

	public void setDepotId(Long depotId) {
		this.depotId = depotId;
	}

	public String getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(String indentDate) {
		this.indentDate = indentDate;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getQtyInCases() {
		return qtyInCases;
	}

	public void setQtyInCases(Long qtyInCases) {
		this.qtyInCases = qtyInCases;
	}

	public Float getRatePerCase() {
		return ratePerCase;
	}

	public void setRatePerCase(Float ratePerCase) {
		this.ratePerCase = ratePerCase;
	}

	public Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
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
		result = prime * result + ((brandName == null) ? 0 : brandName.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((depotId == null) ? 0 : depotId.hashCode());
		result = prime * result + ((distilleryId == null) ? 0 : distilleryId.hashCode());
		result = prime * result + ((indentDate == null) ? 0 : indentDate.hashCode());
		result = prime * result + ((indentNo == null) ? 0 : indentNo.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + ((qtyInCases == null) ? 0 : qtyInCases.hashCode());
		result = prime * result + ((ratePerCase == null) ? 0 : ratePerCase.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
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
		TblIndentForSupply other = (TblIndentForSupply) obj;
		if (brandName == null) {
			if (other.brandName != null)
				return false;
		} else if (!brandName.equals(other.brandName))
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
		if (distilleryId == null) {
			if (other.distilleryId != null)
				return false;
		} else if (!distilleryId.equals(other.distilleryId))
			return false;
		if (indentDate == null) {
			if (other.indentDate != null)
				return false;
		} else if (!indentDate.equals(other.indentDate))
			return false;
		if (indentNo == null) {
			if (other.indentNo != null)
				return false;
		} else if (!indentNo.equals(other.indentNo))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (qtyInCases == null) {
			if (other.qtyInCases != null)
				return false;
		} else if (!qtyInCases.equals(other.qtyInCases))
			return false;
		if (ratePerCase == null) {
			if (other.ratePerCase != null)
				return false;
		} else if (!ratePerCase.equals(other.ratePerCase))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
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
		return "TblIndentForSupply [indentNo=" + indentNo + ", productCode=" + productCode + ", distilleryId="
				+ distilleryId + ", depotId=" + depotId + ", indentDate=" + indentDate + ", brandName=" + brandName
				+ ", size=" + size + ", qtyInCases=" + qtyInCases + ", ratePerCase=" + ratePerCase + ", totalAmount="
				+ totalAmount + ", creationDate=" + creationDate + ", createdBy=" + createdBy + ", updatedDate="
				+ updatedDate + ", updatedBy=" + updatedBy + "]";
	}

		
}
