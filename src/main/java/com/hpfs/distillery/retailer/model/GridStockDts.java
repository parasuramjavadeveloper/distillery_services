/**
 * 
 */
package com.hpfs.distillery.retailer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author babasaheb
 *
 */
@Entity
public class GridStockDts implements Serializable{
	

	@Override
	public String toString() {
		return "GridStockDts [depotInvId=" + depotInvId + ", productCode=" + productCode + ", productType="
				+ productType + ", brandName=" + brandName + ", openingBalance=" + openingBalance + ", sales=" + sales
				+ ", closingBalance=" + closingBalance + ", breakages=" + breakages + ", shortages=" + shortages + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brandName == null) ? 0 : brandName.hashCode());
		result = prime * result + ((breakages == null) ? 0 : breakages.hashCode());
		result = prime * result + ((closingBalance == null) ? 0 : closingBalance.hashCode());
		result = prime * result + ((depotInvId == null) ? 0 : depotInvId.hashCode());
		result = prime * result + ((openingBalance == null) ? 0 : openingBalance.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((sales == null) ? 0 : sales.hashCode());
		result = prime * result + ((shortages == null) ? 0 : shortages.hashCode());
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
		GridStockDts other = (GridStockDts) obj;
		if (brandName == null) {
			if (other.brandName != null)
				return false;
		} else if (!brandName.equals(other.brandName))
			return false;
		if (breakages == null) {
			if (other.breakages != null)
				return false;
		} else if (!breakages.equals(other.breakages))
			return false;
		if (closingBalance == null) {
			if (other.closingBalance != null)
				return false;
		} else if (!closingBalance.equals(other.closingBalance))
			return false;
		if (depotInvId == null) {
			if (other.depotInvId != null)
				return false;
		} else if (!depotInvId.equals(other.depotInvId))
			return false;
		if (openingBalance == null) {
			if (other.openingBalance != null)
				return false;
		} else if (!openingBalance.equals(other.openingBalance))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (sales == null) {
			if (other.sales != null)
				return false;
		} else if (!sales.equals(other.sales))
			return false;
		if (shortages == null) {
			if (other.shortages != null)
				return false;
		} else if (!shortages.equals(other.shortages))
			return false;
		return true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 479854733025142531L;

	@Id
	@Column(name="depot_inv_id")
	public Long depotInvId;

	@Column(name="product_code")
	public String productCode;

	@Column(name="product_type")
	public String productType;
	
	@Column(name="brand_name")
	public String brandName;

	@Column(name="opening_balance")
	public Long openingBalance;

	@Column(name="sales")
	public Long sales;

	@Column(name="closing_balance")
	public Long closingBalance;

	@Column(name="breakages")
	public Long breakages;

	@Column(name="shortages")
	public Long shortages;

	
	public Long getDepotInvId() {
		return depotInvId;
	}

	public void setDepotInvId(Long depotInvId) {
		this.depotInvId = depotInvId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Long getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(Long openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Long getSales() {
		return sales;
	}

	public void setSales(Long sales) {
		this.sales = sales;
	}

	public Long getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Long closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Long getBreakages() {
		return breakages;
	}

	public void setBreakages(Long breakages) {
		this.breakages = breakages;
	}

	public Long getShortages() {
		return shortages;
	}

	public void setShortages(Long shortages) {
		this.shortages = shortages;
	}

	}
