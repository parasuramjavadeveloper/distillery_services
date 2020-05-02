package com.hpfs.distillery.retailer.dto;

import java.util.Date;
import java.util.List;

public class ShipmentHeaderDto {
    private int shipmentHdrId;

    private String consignmentType;

    private String route;

    private String vehicleNum;

    private String transporter;

    private Integer lrNum;

    private Date lrDate;

    private String ofsNo;

    private Integer depotId;

    private Date creationDate;

    private String createdBy;

    private Date updatedDate;

    private String updatedBy;

    private String status;
    private String action;
    private Long validPeriod;
    private List<ShipmentLineDto> shipmentLineDto;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(Long validPeriod) {
        this.validPeriod = validPeriod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getShipmentHdrId() {
        return shipmentHdrId;
    }

    public void setShipmentHdrId(int shipmentHdrId) {
        this.shipmentHdrId = shipmentHdrId;
    }

    public String getConsignmentType() {
        return consignmentType;
    }

    public void setConsignmentType(String consignmentType) {
        this.consignmentType = consignmentType;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getTransporter() {
        return transporter;
    }

    public void setTransporter(String transporter) {
        this.transporter = transporter;
    }

    public Integer getLrNum() {
        return lrNum;
    }

    public void setLrNum(Integer lrNum) {
        this.lrNum = lrNum;
    }

    public Date getLrDate() {
        return lrDate;
    }

    public void setLrDate(Date lrDate) {
        this.lrDate = lrDate;
    }

    public String getOfsNo() {
        return ofsNo;
    }

    public void setOfsNo(String ofsNo) {
        this.ofsNo = ofsNo;
    }

    public Integer getDepotId() {
        return depotId;
    }

    public void setDepotId(Integer depotId) {
        this.depotId = depotId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<ShipmentLineDto> getShipmentLineDto() {
        return shipmentLineDto;
    }

    public void setShipmentLineDto(List<ShipmentLineDto> shipmentLineDto) {
        this.shipmentLineDto = shipmentLineDto;
    }

}
