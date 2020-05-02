/**
 * 
 */
package com.hpfs.distillery.retailer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author babasaheb
 *
 */
@Entity
@Table(name = "order_for_supply")
public class TblOrderForSupply {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "ofs_no")
	private String ofsNo;

	@Column(name = "destillery_id")
	private Long distilleryId;

	@Column(name = "depot_id")
	private Long depotId;

	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "ofs_ref_num")
	private String ofsRefNo;

	@Column(name = "brand_name")
	private String brandName;

	@Column(name = "size")
	private Long size;

	@Column(name = "approved_qty")
	private Long approvedQty;

	@Column(name = "rate_per_case")
	private Float ratePerCase;

	@Column(name = "total_amount")
	private Float totalAmount;

	@Column(name = "approved_by")
	private String approvedBy;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "status")
	private String status;

	@Column(name = "creation_date")
	private String creationDate;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_date")
	private String updatedDate;

	@Column(name = "updated_by")
	private String updatedBy;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getOfsNo() {
		return ofsNo;
	}

	public void setOfsNo(String ofsNo) {
		this.ofsNo = ofsNo;
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

	public String getOfsRefNo() {
		return ofsRefNo;
	}

	public void setOfsRefNo(String ofsRefNo) {
		this.ofsRefNo = ofsRefNo;
	}

	public Long getApprovedQty() {
		return approvedQty;
	}

	public void setApprovedQty(Long approvedQty) {
		this.approvedQty = approvedQty;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approvedBy == null) ? 0 : approvedBy.hashCode());
		result = prime * result + ((approvedQty == null) ? 0 : approvedQty.hashCode());
		result = prime * result + ((brandName == null) ? 0 : brandName.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((depotId == null) ? 0 : depotId.hashCode());
		result = prime * result + ((distilleryId == null) ? 0 : distilleryId.hashCode());
		result = prime * result + ((ofsNo == null) ? 0 : ofsNo.hashCode());
		result = prime * result + ((ofsRefNo == null) ? 0 : ofsRefNo.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + ((ratePerCase == null) ? 0 : ratePerCase.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		TblOrderForSupply other = (TblOrderForSupply) obj;
		if (approvedBy == null) {
			if (other.approvedBy != null)
				return false;
		} else if (!approvedBy.equals(other.approvedBy))
			return false;
		if (approvedQty == null) {
			if (other.approvedQty != null)
				return false;
		} else if (!approvedQty.equals(other.approvedQty))
			return false;
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
		if (ofsNo == null) {
			if (other.ofsNo != null)
				return false;
		} else if (!ofsNo.equals(other.ofsNo))
			return false;
		if (ofsRefNo == null) {
			if (other.ofsRefNo != null)
				return false;
		} else if (!ofsRefNo.equals(other.ofsRefNo))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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

	

}
