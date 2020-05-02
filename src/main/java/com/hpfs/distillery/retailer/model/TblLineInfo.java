package com.hpfs.distillery.retailer.model;


import javax.persistence.*;

@Entity
@Table(name="line_information")
public class TblLineInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="sno")
    public Long sno;

    @Column(name="production_type")
    public String productType;

    @Column(name="heal_start_code")
    public String healStartCode;

    @Column(name="brand_code")
    public String brandCode;

    @Column(name="brand_name")
    public String brandName;

    @Column(name="size")
    public String size;


    @Column(name="pack_type")
    public String packType;

    @Column(name="product_code")
    public String productCode;

    @Column(name="units_per_case")
    public String unitsPerCase;


    @Column(name="mrp")
    public String mrp;

    @Column(name="base_price")
    public String basePrice;

    @Column(name="excise_duty")
    public String exciseDuty;

    @Column(name="segment")
    public String segment;


    @Column(name="batch_no")
    public String batchNo;


    @Column(name="manufacture_date")
    public String manafactureDate;

    @Column(name="operator")
    public String operator;

    @Column(name="line_id")
    public String lineId;

    @Column(name="creation_date")
    public String creationDate;

    @Column(name="created_by")
    public String createdBy;

    @Column(name="updated_date")
    public String updatedDate;


    @Column(name="updated_by")
    public String updatedBy;

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getHealStartCode() {
        return healStartCode;
    }

    public void setHealStartCode(String healStartCode) {
        this.healStartCode = healStartCode;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPackType() {
        return packType;
    }

    public void setPackType(String packType) {
        this.packType = packType;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getUnitsPerCase() {
        return unitsPerCase;
    }

    public void setUnitsPerCase(String unitsPerCase) {
        this.unitsPerCase = unitsPerCase;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public String getExciseDuty() {
        return exciseDuty;
    }

    public void setExciseDuty(String exciseDuty) {
        this.exciseDuty = exciseDuty;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getManafactureDate() {
        return manafactureDate;
    }

    public void setManafactureDate(String manafactureDate) {
        this.manafactureDate = manafactureDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
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

