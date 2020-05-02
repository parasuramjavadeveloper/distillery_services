/**
 * 
 */
package com.hpfs.distillery.retailer.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author babasaheb
 *
 */
@Getter
@Setter
public class GridStockDtsDto implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 479854733025142531L;

	public Long depotInvId;
	public String productCode;
	public String productType;
	public String brandName;
	public Long openingBalance;
	public Long sales;
	public Long closingBalance;
	public Long breakages;
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
