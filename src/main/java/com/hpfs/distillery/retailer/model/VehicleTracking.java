/**
 * 
 */
package com.hpfs.distillery.retailer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ram
 *
 */
@Entity
@Table(name = "vehicle_tracking")
public class VehicleTracking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7139983652070747217L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "tracking_id")
	public Long trackingId;

	@Column(name = "longitude")
	public String longitude;
	
	@Column(name = "vehicle_num")
	public String vehicleNum;

	@Column(name = "latitude")
	public String latitude;

	@Column(name = "estimated_time")
	public String estimatedTime;

	@Column(name = "route_id")
	public Long routeId;
	
	

	@Column(name = "tp_vehicle_number")
	public String tpVehicleNumber;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cases == null) ? 0 : cases.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((distilleryName == null) ? 0 : distilleryName.hashCode());
		result = prime * result + ((estimatedTime == null) ? 0 : estimatedTime.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((routeId == null) ? 0 : routeId.hashCode());
		result = prime * result + ((routeName == null) ? 0 : routeName.hashCode());
		result = prime * result + ((tpVehicleNumber == null) ? 0 : tpVehicleNumber.hashCode());
		result = prime * result + ((trackingId == null) ? 0 : trackingId.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result + ((vehicleNum == null) ? 0 : vehicleNum.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "VehicleTracking [trackingId=" + trackingId + ", longitude=" + longitude + ", vehicleNum=" + vehicleNum
				+ ", latitude=" + latitude + ", estimatedTime=" + estimatedTime + ", routeId=" + routeId
				+ ", tpVehicleNumber=" + tpVehicleNumber + ", distilleryName=" + distilleryName + ", destination="
				+ destination + ", cases=" + cases + ", routeName=" + routeName + ", creationDate=" + creationDate
				+ ", createdBy=" + createdBy + ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleTracking other = (VehicleTracking) obj;
		if (cases == null) {
			if (other.cases != null)
				return false;
		} else if (!cases.equals(other.cases))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (distilleryName == null) {
			if (other.distilleryName != null)
				return false;
		} else if (!distilleryName.equals(other.distilleryName))
			return false;
		if (estimatedTime == null) {
			if (other.estimatedTime != null)
				return false;
		} else if (!estimatedTime.equals(other.estimatedTime))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (routeId == null) {
			if (other.routeId != null)
				return false;
		} else if (!routeId.equals(other.routeId))
			return false;
		if (routeName == null) {
			if (other.routeName != null)
				return false;
		} else if (!routeName.equals(other.routeName))
			return false;
		if (tpVehicleNumber == null) {
			if (other.tpVehicleNumber != null)
				return false;
		} else if (!tpVehicleNumber.equals(other.tpVehicleNumber))
			return false;
		if (trackingId == null) {
			if (other.trackingId != null)
				return false;
		} else if (!trackingId.equals(other.trackingId))
			return false;
		if (updatedBy == null) {
			if (other.updatedBy != null)
				return false;
		} else if (!updatedBy.equals(other.updatedBy))
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		if (vehicleNum == null) {
			if (other.vehicleNum != null)
				return false;
		} else if (!vehicleNum.equals(other.vehicleNum))
			return false;
		return true;
	}

	@Column(name = "distillery_name")
	public String distilleryName;

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

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	@Column(name = "destination")
	public String destination;

	@Column(name = "cases")
	public Long cases;
	
	@Column(name = "route_name")
	public String routeName;

	
	

	@Column(name = "creation_date")
	public String creationDate;

	@Column(name = "created_by")
	public String createdBy;

	@Column(name = "updated_date")
	public String updatedDate;

	@Column(name = "updated_by")
	public String updatedBy;
	
	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

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
