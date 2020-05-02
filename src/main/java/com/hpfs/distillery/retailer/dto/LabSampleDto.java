package com.hpfs.distillery.retailer.dto;

import java.util.Date;
import java.util.List;

public class LabSampleDto {

	private int labSampleId;

	private String sampleType;

	private String referenceNum;

	private String sentThrough;

	private byte[] signature;

	private String signatureFile;

	private Date creationDate;

	private String createdBy;

	private Date updatedDate;

	private String updatedBy;

	private List<LabInformationDto> labInformation;

	public int getLabSampleId() {
		return labSampleId;
	}

	public void setLabSampleId(int labSampleId) {
		this.labSampleId = labSampleId;
	}

	public String getSampleType() {
		return sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}

	public String getReferenceNum() {
		return referenceNum;
	}

	public void setReferenceNum(String referenceNum) {
		this.referenceNum = referenceNum;
	}

	public String getSentThrough() {
		return sentThrough;
	}

	public void setSentThrough(String sentThrough) {
		this.sentThrough = sentThrough;
	}

	public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
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

	public List<LabInformationDto> getLabInformation() {
		return labInformation;
	}

	public void setLabInformation(List<LabInformationDto> labInformation) {
		this.labInformation = labInformation;
	}

	public String getSignatureFile() {
		return signatureFile;
	}

	public void setSignatureFile(String signatureFile) {
		this.signatureFile = signatureFile;
	}

	/*
	 * public List<LabInformation> getLabInformation() { return labInformation; }
	 * 
	 * public void setLabInformation(List<LabInformation> labInformation) {
	 * this.labInformation = labInformation; }
	 */

}
