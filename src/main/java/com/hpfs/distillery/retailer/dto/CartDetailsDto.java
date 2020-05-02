package com.hpfs.distillery.retailer.dto;

import java.util.List;

import com.hpfs.distillery.retailer.model.TblRetailerPaymentDetails;
/**
 * @author Vamsi Alla
 *
 */
public class CartDetailsDto {
	
	public int id;
	public String retailerCode;
	public int distilleryId;
	public String brandName;
	public int size;
	public int quantity;
	public Long unitPrice;
	public Long totalPrice;
	public String creationDate;
	public String createdBy;
	public String updatedDate;
	public String updatedBy;
	
	
	List<TblRetailerPaymentDetails> paymentList;
	
	
	
	public List<TblRetailerPaymentDetails> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<TblRetailerPaymentDetails> paymentList) {
		this.paymentList = paymentList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRetailerCode() {
		return retailerCode;
	}
	public void setRetailerCode(String retailerCode) {
		this.retailerCode = retailerCode;
	}
	public int getDistilleryId() {
		return distilleryId;
	}
	public void setDistilleryId(int distilleryId) {
		this.distilleryId = distilleryId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
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
