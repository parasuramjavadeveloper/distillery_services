/**
 * 
 */
package com.hpfs.distillery.retailer.dto;

import java.util.List;

import com.hpfs.distillery.retailer.model.TblIndent_D;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author babasaheb
 */

/**
 * @author babasaheb
 *
 */
@Getter
@Setter
@ToString
public class IndentCreationDto {

	public int retailerCode;
	public String authorisedPerson;
	public String shopName;
	public Long depot;
	public String depotName;
	public String indentCreationDate;
	public Long contactNumber;
	public String vehicleNumber;
	public String description;
	
	public List<TblIndent_D> productList;
	/*
	 * public String productCode; public String productDescription; public String
	 * barCode; public Long noOfUnits; public Long unitPrice; public float
	 * totalPrice;
	 */

	public String getAuthorisedPerson() {
		return authorisedPerson;
	}

	public void setAuthorisedPerson(String authorisedPerson) {
		this.authorisedPerson = authorisedPerson;
	}

	public int getRetailerCode() {
		return retailerCode;
	}

	public void setRetailerCode(int retailerCode) {
		this.retailerCode = retailerCode;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Long getDepot() {
		return depot;
	}

	public void setDepot(Long depot) {
		this.depot = depot;
	}

	public String getDepotName() {
		return depotName;
	}

	public void setDepotName(String depotName) {
		this.depotName = depotName;
	}

	public String getIndentCreationDate() {
		return indentCreationDate;
	}

	public void setIndentCreationDate(String indentCreationDate) {
		this.indentCreationDate = indentCreationDate;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * public String getProductCode() { return productCode; }
	 * 
	 * public void setProductCode(String productCode) { this.productCode =
	 * productCode; }
	 * 
	 * public String getProductDescription() { return productDescription; }
	 * 
	 * public void setProductDescription(String productDescription) {
	 * this.productDescription = productDescription; }
	 * 
	 * public String getBarCode() { return barCode; }
	 * 
	 * public void setBarCode(String barCode) { this.barCode = barCode; }
	 * 
	 * public Long getNoOfUnits() { return noOfUnits; }
	 *
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

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}*/
}


