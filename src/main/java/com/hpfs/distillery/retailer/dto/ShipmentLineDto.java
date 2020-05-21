package com.hpfs.distillery.retailer.dto;

public class ShipmentLineDto {
    private Integer shipmentLineId;
    private String productCode;
    private String brandName;
    private Integer size;
    private Integer ofsQnty;
    private Integer allocatedQnty;
    private Float exciseDuty;
    private String creationDate;
    private String createdBy;
    private String updatedDate;
    private String updatedBy;

    public Integer getShipmentLineId() {
        return shipmentLineId;
    }

    public void setShipmentLineId(Integer shipmentLineId) {
        this.shipmentLineId = shipmentLineId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getOfsQnty() {
        return ofsQnty;
    }

    public void setOfsQnty(Integer ofsQnty) {
        this.ofsQnty = ofsQnty;
    }

    public Integer getAllocatedQnty() {
        return allocatedQnty;
    }

    public void setAllocatedQnty(Integer allocatedQnty) {
        this.allocatedQnty = allocatedQnty;
    }

    public Float getExciseDuty() {
        return exciseDuty;
    }

    public void setExciseDuty(Float exciseDuty) {
        this.exciseDuty = exciseDuty;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}
