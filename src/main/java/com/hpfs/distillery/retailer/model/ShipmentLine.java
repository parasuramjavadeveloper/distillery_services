package com.hpfs.distillery.retailer.model;

import com.hpfs.distillery.retailer.repository.IDGenerator;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "shipment_line")
public class ShipmentLine {

	@Id
	@GeneratedValue(generator = IDGenerator.generatorName)
	@GenericGenerator(name = IDGenerator.generatorName, strategy = "com.hpfs.distillery.retailer.repository.LineIDGenerator")
	@Column(name = "shipment_line_id", nullable = false, length = 15)
	private String shipmentLineId;
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
	@Column(name = "excise_duty")
	private Float exciseDuty;

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

	public String getShipmentLineId() {
		return shipmentLineId;
	}

	public void setShipmentLineId(String shipmentLineId) {
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
