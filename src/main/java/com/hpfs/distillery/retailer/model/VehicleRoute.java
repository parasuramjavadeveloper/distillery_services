/**
 * 
 */
package com.hpfs.distillery.retailer.model;

import java.util.List;

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
@Table(name="route_details")
public class VehicleRoute {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="route_id")
	public Long routeId;

	@Column(name="vehicle_num")
	public String vehicleNum;

	@Column(name="source_disti")
	public String distillerySource;
	
	/*@Column(name="intermediate_depots")
	public List<String> intermediateDepots;
	*/
	@Column(name="intermediate_depots")
	public String intermediateDepots;
	

	@Column(name="destination_depot")
	public String destinationDepot;
	

	@Column(name="route_creation_date")
	public String routeCreationDate;

	@Column(name="estimated_start_date")
	public String estimatedStartDate;
	
	public String getTpPin() {
		return tpPin;
	}

	public void setTpPin(String tpPin) {
		this.tpPin = tpPin;
	}

	@Column(name="comments")
	public String comments;

	@Column(name="status")
	public String status;
	
	@Column(name="tppin")
	public String tpPin;
	
	
	@Column(name="creation_date")
	public String creationDate;
	
	@Column(name="created_by")
	public String createdBy;
	
	@Column(name="updated_date")
	public String updatedDate;
	
	@Column(name="updated_by")
	public String updatedBy;

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

	public String getDistillerySource() {
		return distillerySource;
	}

	public void setDistillerySource(String distillerySource) {
		this.distillerySource = distillerySource;
	}

	/*public List<String> getIntermediateDepots() {
		return intermediateDepots;
	}

	public void setIntermediateDepots(List<String> intermediateDepots) {
		this.intermediateDepots = intermediateDepots;
	}*/
	
	public String getDestinationDepot() {
		return destinationDepot;
	}

	public String getIntermediateDepots() {
		return intermediateDepots;
	}

	public void setIntermediateDepots(String intermediateDepots) {
		this.intermediateDepots = intermediateDepots;
	}

	public void setDestinationDepot(String destinationDepot) {
		this.destinationDepot = destinationDepot;
	}

	public String getRouteCreationDate() {
		return routeCreationDate;
	}

	public void setRouteCreationDate(String routeCreationDate) {
		this.routeCreationDate = routeCreationDate;
	}

	public String getEstimatedStartDate() {
		return estimatedStartDate;
	}

	public void setEstimatedStartDate(String estimatedStartDate) {
		this.estimatedStartDate = estimatedStartDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
