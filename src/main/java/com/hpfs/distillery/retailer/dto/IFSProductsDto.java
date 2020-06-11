/**
 *
 */
package com.hpfs.distillery.retailer.dto;

/**
 * @author ram
 *
 */
public class IFSProductsDto {

    private Integer ifsPid;

    private String ifsNum;

    private String indentDate;

    private String brandName;

    private Long size;

    private Long qtyInCases;

    private Float ratePerCase;

    private Float totalAmount;

    private String productCode;

    private String status;

    private String creationDate;

    private String createdBy;

    private String updatedDate;

    private String updatedBy;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getQtyInCases() {
        return qtyInCases;
    }

    public void setQtyInCases(Long qtyInCases) {
        this.qtyInCases = qtyInCases;
    }

    public Float getRatePerCase() {
        return ratePerCase;
    }

    public void setRatePerCase(Float ratePerCase) {
        this.ratePerCase = ratePerCase;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
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

    public String getIfsNum() {
        return ifsNum;
    }

    public void setIfsNum(String ifsNum) {
        this.ifsNum = ifsNum;
    }

    public String getIndentDate() {
        return indentDate;
    }

    public void setIndentDate(String indentDate) {
        this.indentDate = indentDate;
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

    public Integer getIfsPid() {
        return ifsPid;
    }

    public void setIfsPid(Integer ifsPid) {
        this.ifsPid = ifsPid;
    }
}
