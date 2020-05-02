/**
 * 
 */
package com.hpfs.distillery.retailer.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author babasaheb
 *
 */
@XmlRootElement(name = "parent")
public class TblBarcodeM {

	
	@XmlAttribute(name = "id")
	private Long id;
	
	@XmlAttribute(name = "userName")
	private String userName;
	
	@XmlAttribute(name = "mobileNumber")
	private String mobileNumber;
	
	@XmlAttribute(name = "barcodeNumber")
	private String barcodeNumber;
	
	@XmlAttribute(name = "itemName")
	private String itemName;
	
	@XmlAttribute(name = "size")
	private String size;
	
	@XmlAttribute(name = "price")
	private String price;
	
	@XmlAttribute(name = "offer")
	private String offer;
	
	@XmlAttribute(name = "storeName")
	private String storeName;
	
	@XmlAttribute(name = "location")
	private String location;
	
	@XmlAttribute(name = "offerToAvail")
	private String offerToAvail;
	
	
	public TblBarcodeM() {
		// TODO Auto-generated constructor stub
	}
	
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

	public TblBarcodeM(Long id,String userName,String mobileNumber,String barcodeNumber,String itemName,String size,
						String price,String offer,String storeName,String location,String offerToAvail) {
		this.id =id;
		this.barcodeNumber= barcodeNumber;
		this.userName =userName;
		this.mobileNumber = mobileNumber;
		this.itemName = itemName;
		this.size = size;
		this.price = price;
		this.offer = offer;
		this.offerToAvail = offerToAvail;
		this.storeName =storeName;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "TblBarcodeM [id=" + id + ", userName=" + userName + ", mobileNumber=" + mobileNumber
				+ ", barcodeNumber=" + barcodeNumber + ", itemName=" + itemName + ", size=" + size + ", price=" + price
				+ ", offer=" + offer + ", storeName=" + storeName + ", location=" + location + ", offerToAvail="
				+ offerToAvail + "]";
	}

	
	
	
}
