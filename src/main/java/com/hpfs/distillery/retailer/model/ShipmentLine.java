package com.hpfs.distillery.retailer.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shipment_line")
public class ShipmentLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shipment_line_id")
    private Integer shipmentLineId;
    @Column(name = "product_code")
    private String productCode;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "size")
    private Integer size;
    @Column(name = "ofs_qty")
    private Integer ofsQnty;
    @Column(name = "allocated_qty")
    private Integer allocatedQnty;
    @Column(name = "shipment_qty")
    private Integer shipmentQty;
    @Column(name = "balance_qty")
    private Integer balanceQty;
    @Column(name = "excise_duty")
    private Float exciseDuty;
    @Column(name = "challan_no")
    private String challanNum;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;
    public Integer getShipmentQty() {
        return shipmentQty;
    }
    public void setShipmentQty(Integer shipmentQty) {
        this.shipmentQty = shipmentQty;
    }

    public Integer getBalanceQty() {
        return balanceQty;
    }

    public void setBalanceQty(Integer balanceQty) {
        this.balanceQty = balanceQty;
    }

    public String getChallanNum() {
        return challanNum;
    }

    public void setChallanNum(String challanNum) {
        this.challanNum = challanNum;
    }

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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
