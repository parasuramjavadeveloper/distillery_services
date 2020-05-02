package com.hpfs.distillery.retailer.dto;

public class GRNTransactionDto {

	public Long id;
	public Long supplierNo;
	public String supplierName;
	public double grnProcessFee;
	public String grnNo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSupplierNo() {
		return supplierNo;
	}
	public void setSupplierNo(Long supplierNo) {
		this.supplierNo = supplierNo;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public double getGrnProcessFee() {
		return grnProcessFee;
	}
	public void setGrnProcessFee(double grnProcessFee) {
		this.grnProcessFee = grnProcessFee;
	}
	public String getGrnNo() {
		return grnNo;
	}
	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}
	
	
}
