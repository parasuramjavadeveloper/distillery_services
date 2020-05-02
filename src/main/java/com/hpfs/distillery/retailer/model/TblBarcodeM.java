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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author babasaheb
 *
 */
@Entity
@Table(name="barcode_m")
@XmlRootElement(name = "parent")
public class TblBarcodeM {

	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="user_name")
	public String userName;
	
	@Column(name="mobile_number")
	public String mobileNumber;

	@Column(name="barcode_number")
	private String barcodeNumber;

	@Column(name="item_name")
	public String itemName;
	
	@Column(name="size")
	public String size;

	@Column(name="price")
	public String price;

	@Column(name="offer")
	public String offer;
	

	@Column(name="store_name")
	public String storeName;

	@Column(name="location")
	public String location;

	@Column(name="offer_to_avail")
	public String offerToAvail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getBarcodeNumber() {
		return barcodeNumber;
	}

	public void setBarcodeNumber(String barcodeNumber) {
		this.barcodeNumber = barcodeNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOfferToAvail() {
		return offerToAvail;
	}

	public void setOfferToAvail(String offerToAvail) {
		this.offerToAvail = offerToAvail;
	}

	
	
}
