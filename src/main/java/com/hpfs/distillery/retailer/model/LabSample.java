package com.hpfs.distillery.retailer.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "lab_details_m")
public class LabSample {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lab_id")
	private int labSampleId;

	@Column(name = "sample_type")
	private String sampleType;

	@Column(name = "ref_no")
	private String referenceNum;

	@Column(name = "sent_through")
	private String sentThrough;

	@Lob
	@Column(name = "signature", length = 100000)
	private byte[] data;

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_date")
	private Date updatedDate;

	@Column(name = "updated_by")
	private String updatedBy;

	@Transient
	private String signatureFile;

	public String getSignatureFile() {
		return signatureFile;
	}

	public void setSignatureFile(String signatureFile) {
		this.signatureFile = signatureFile;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "lab_id")
	private List<LabInformation> labInformation = new ArrayList<>();

	/*
	 * public Blob getSignature() { return signature; }
	 * 
	 * public void setSignature(Blob signature) { this.signature = signature; }
	 */
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

	public int getLabSampleId() {
		return labSampleId;
	}

	public List<LabInformation> getLabInformation() {
		return labInformation;
	}

	public void setLabInformation(List<LabInformation> labInformation) {
		this.labInformation = labInformation;
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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
