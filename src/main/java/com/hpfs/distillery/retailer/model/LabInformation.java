package com.hpfs.distillery.retailer.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "lab_details_d")
public class LabInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lab_det_id")
	private int labInformationId;
	@Column(name = "description")
	private String description;
	@Column(name = "lot_no")
	private String lotNo;
	@Column(name = "sample_qty")
	private Integer sampleQnty;
	/*
	 * @Lob
	 * 
	 * @Column(name = "seal") private Blob seal;
	 */
	@Lob
	@Column(name = "seal", length = 100000)
	private byte[] data;
	@Column(name = "brand_name")
	public String brandName;
	@Column(name = "brand_num")
	public String brandNumber;
	@Column(name = "segment")
	public String segment;
	@Column(name = "batch_num")
	public String batchNum;
	@Column(name = "status")
	public String status;

	
	public String getDataFile() {
		return dataFile;
	}

	public void setDataFile(String dataFile) {
		this.dataFile = dataFile;
	}

	@Transient
	private String dataFile;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_date")
	private Date updatedDate;

	@Column(name = "updated_by")
	private String updatedBy;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "lab_id", nullable = false) private LabSample labSample;
	 */
//	@Column(name = "senders_facsMile_File")
//	public File sendersFacsMileAttachment;

	public int getLabInformationId() {
		return labInformationId;
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

//	public Blob getSeal() {
//		return seal;
//	}
//
//	public void setSeal(Blob seal) {
//		this.seal = seal;
//	}

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

	/*
	 * public LabSample getLabSample() { return labSample; }
	 * 
	 * public void setLabSample(LabSample labSample) { this.labSample = labSample; }
	 */
	public void setLabInformationId(int labInformationId) {
		this.labInformationId = labInformationId;
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

}
