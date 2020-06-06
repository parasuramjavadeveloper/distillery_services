/**
 *
 */
package com.hpfs.distillery.retailer.dto;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author ram
 *
 */
public class IFSDto {

    private String ifsNo;

    private String ifsType;

    private String consignmentType;

    private Long distilleryId;

    private Long depotId;

    private String status;

    private String indentDate;

    private List<IFSProductsDto> iFSProducts;

    private String creationDate;

    private String createdBy;

    private String updatedDate;

    private String updatedBy;

    public List<IFSProductsDto> getiFSProducts() {
        return iFSProducts;
    }

    public void setiFSProducts(List<IFSProductsDto> iFSProducts) {
        this.iFSProducts = iFSProducts;
    }

    public String getIfsNo() {
        return ifsNo;
    }

    public void setIfsNo(String ifsNo) {
        this.ifsNo = ifsNo;
    }

    public Long getDistilleryId() {
        return distilleryId;
    }

    public void setDistilleryId(Long distilleryId) {
        this.distilleryId = distilleryId;
    }

    public Long getDepotId() {
        return depotId;
    }

    public void setDepotId(Long depotId) {
        this.depotId = depotId;
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

    public String getIfsType() {
        return ifsType;
    }

    public void setIfsType(String ifsType) {
        this.ifsType = ifsType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConsignmentType() {
        return consignmentType;
    }

    public void setConsignmentType(String consignmentType) {
        this.consignmentType = consignmentType;
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
}
