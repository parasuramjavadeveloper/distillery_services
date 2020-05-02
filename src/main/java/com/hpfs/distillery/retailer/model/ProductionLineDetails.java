package com.hpfs.distillery.retailer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="production_line_det")
public class ProductionLineDetails {
    @Id
    @Column(name="line_id")
    private Long lineId;
    @Column(name="line_type")
    private String lineType;
    @Column(name="line_name")
    private String lineName;
    @Column(name="line_identity")
    private String lineIdentity;

    @Column(name="scanner_type")
    private String scannerType;
    @Column(name="line_path")
    private String linePath;
    @Column(name="printer_type")
    private String printerType;
    @Column(name="printer_ip")
    private String printerPort;
    @Column(name="status")
    private String status;

    @Column(name="creation_date")
    private Timestamp creationDate;
    @Column(name="created_by")
    private String createdBy;
    @Column(name="updated_date")
    private Timestamp updatedDate;
    @Column(name="updated_by")
    private String updatedBy;

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLineIdentity() {
        return lineIdentity;
    }

    public void setLineIdentity(String lineIdentity) {
        this.lineIdentity = lineIdentity;
    }

    public String getScannerType() {
        return scannerType;
    }

    public void setScannerType(String scannerType) {
        this.scannerType = scannerType;
    }

    public String getLinePath() {
        return linePath;
    }

    public void setLinePath(String linePath) {
        this.linePath = linePath;
    }

    public String getPrinterType() {
        return printerType;
    }

    public void setPrinterType(String printerType) {
        this.printerType = printerType;
    }

    public String getPrinterPort() {
        return printerPort;
    }

    public void setPrinterPort(String printerPort) {
        this.printerPort = printerPort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
