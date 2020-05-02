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
public class SubmitTranportDtsDto implements Serializable{
	
	private static final long serialVersionUID = 479854733025142531L;

	public Long distilleryId;
	public String distilleryName;
	public String location;
	public String ipAddress;
	public String vehicleNumber;
	public String vehiclePOCName;//owername
	public String vehiclePOCNumber;//ower number
	public Long trNumber;
	public String scanOption;
	

	public Long getDistilleryId() {
		return distilleryId;
	}
	public void setDistilleryId(Long distilleryId) {
		this.distilleryId = distilleryId;
	}
	public String getDistilleryName() {
		return distilleryName;
	}
	public void setDistilleryName(String distilleryName) {
		this.distilleryName = distilleryName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehiclePOCName() {
		return vehiclePOCName;
	}
	public void setVehiclePOCName(String vehiclePOCName) {
		this.vehiclePOCName = vehiclePOCName;
	}
	public String getVehiclePOCNumber() {
		return vehiclePOCNumber;
	}
	public void setVehiclePOCNumber(String vehiclePOCNumber) {
		this.vehiclePOCNumber = vehiclePOCNumber;
	}
	public Long getTrNumber() {
		return trNumber;
	}
	public void setTrNumber(Long trNumber) {
		this.trNumber = trNumber;
	}
	public String getScanOption() {
		return scanOption;
	}
	public void setScanOption(String scanOption) {
		this.scanOption = scanOption;
	}
	
}
