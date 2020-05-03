/**
 *
 */
package com.hpfs.distillery.retailer.dto;

/**
 * @author ram
 *
 */

public class VehicleRouteDto {

    public Long routeId;
    public String vehicleNum;
    public String distillerySource;
    public String intermediateDepots;
    public String destinationDepot;
    public String routeCreationDate;
    public String estimatedStartDate;
    public String comments;
    public String status;
    public String tpPin;
    public String creationDate;
    public String createdBy;
    public String updatedDate;
    public String updatedBy;

	public VehicleRouteDto() {
	}

	public VehicleRouteDto(String distillerySource, String vehicleNum) {
		this.distillerySource = distillerySource;
		this.vehicleNum = vehicleNum;
	}

	public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getTpPin() {
        return tpPin;
    }

    public void setTpPin(String tpPin) {
        this.tpPin = tpPin;
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
