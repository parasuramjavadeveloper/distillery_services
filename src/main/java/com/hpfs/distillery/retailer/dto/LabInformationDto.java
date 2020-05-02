package com.hpfs.distillery.retailer.dto;

import java.util.Date;

public class LabInformationDto {

	private int labInformationId;
	private String description;
	private String lotNo;
	private Integer sampleQnty;
	private byte[] data;
	public String brandName;
	public String brandNumber;
	public String segment;
	public String batchNum;
	public String status;
	private Date creationDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private String dataFile;
	
	
	
	public int getLabInformationId() {
		return labInformationId;
	}
	public void setLabInformationId(int labInformationId) {
		this.labInformationId = labInformationId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLotNo() {
		return lotNo;
	}
	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}
	public Integer getSampleQnty() {
		return sampleQnty;
	}
	public void setSampleQnty(Integer sampleQnty) {
		this.sampleQnty = sampleQnty;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandNumber() {
		return brandNumber;
	}
	public void setBrandNumber(String brandNumber) {
		this.brandNumber = brandNumber;
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	public String getBatchNum() {
		return batchNum;
	}
	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getDataFile() {
		return dataFile;
	}
	public void setDataFile(String dataFile) {
		this.dataFile = dataFile;
	}
	
	
	

}
