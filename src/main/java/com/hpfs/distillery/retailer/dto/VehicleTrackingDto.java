/**
 * 
 */
package com.hpfs.distillery.retailer.dto;

import java.util.List;

import javax.persistence.Column;

/**
 * @author ram
 *
 */
public class VehicleTrackingDto {

	public Long trackingId;

	public String longitude;

	public String latitude;

	public String estimatedTime;

	public Long routeId;
	
	public String vehicleNum;
	
	public String tpVehicleNumber;
	
	public String distilleryName;
	public String destination;
	public Long cases;
	
	public List<String> routeName;

	public Long getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(Long trackingId) {
		this.trackingId = trackingId;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public String getTpVehicleNumber() {
		return tpVehicleNumber;
	}

	public void setTpVehicleNumber(String tpVehicleNumber) {
		this.tpVehicleNumber = tpVehicleNumber;
	}

	public String getDistilleryName() {
		return distilleryName;
	}

	public void setDistilleryName(String distilleryName) {
		this.distilleryName = distilleryName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Long getCases() {
		return cases;
	}

	public void setCases(Long cases) {
		this.cases = cases;
	}

	public List<String> getRouteName() {
		return routeName;
	}

	public void setRouteName(List<String> routeName) {
		this.routeName = routeName;
	}

	
	
	
}
