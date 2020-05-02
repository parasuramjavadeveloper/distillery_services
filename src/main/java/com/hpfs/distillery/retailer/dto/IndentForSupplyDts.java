/**
 * 
 */
package com.hpfs.distillery.retailer.dto;

/**
 * @author babasaheb
 *
 */
public class IndentForSupplyDts {

	private String indentNo;
	private Long depotId;
	private String productCode;
	private String brandName;
	private Long size;
	private Long qtyInCases;
	private Float ratePerCase;
	private Float totalAmount;
	private Long userId;
	private Long distilleryId;
	private String indentDate;
	private String creationDate;
	private String createdBy;
	private String updatedDate;
	private String updatedBy;
	private String status;
	
	public String getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(String indentDate) {
		this.indentDate = indentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIndentNo() {
		return indentNo;
	}

	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
	}

	public Long getDepotId() {
		return depotId;
	}

	public void setDepotId(Long depotId) {
		this.depotId = depotId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDistilleryId() {
		return distilleryId;
	}

	public void setDistilleryId(Long distilleryId) {
		this.distilleryId = distilleryId;
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
