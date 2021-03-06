package com.hpfs.distillery.retailer.model;

import com.hpfs.distillery.retailer.repository.IDGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shipment_hdr")
public class ShipmentHeader {


	@Id
	@GeneratedValue(generator = IDGenerator.generatorName)
	@GenericGenerator(name = IDGenerator.generatorName, strategy = "com.hpfs.distillery.retailer.repository.IDGenerator")
	@Column(name = "shipment_hdr_id", nullable = false, length = 15)
	private String shipmentHdrId;

	@Column(name = "consignment_type")
	private String consignmentType;

	@Column(name = "route")
	private String route;

	@Column(name = "vehicle_num")
	private String vehicleNum;

	@Column(name = "transporter")
	private String transporter;

	@Column(name = "lr_num")
	private Integer lrNum;

	@Column(name = "lr_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lrDate;

	@Column(name = "ofs_no")
	private String ofsNo;

	@Column(name = "depot_id")
	private Integer depotId;

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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "shipment_hdr_id")
	private List<ShipmentLine> shipmentLine = new ArrayList<>();

	public String getShipmentHdrId() {
		return shipmentHdrId;
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

	public String getConsignmentType() {
		return consignmentType;
	}

	public void setConsignmentType(String consignmentType) {
		this.consignmentType = consignmentType;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public String getTransporter() {
		return transporter;
	}

	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}

	public Integer getLrNum() {
		return lrNum;
	}

	public void setLrNum(Integer lrNum) {
		this.lrNum = lrNum;
	}

	public Date getLrDate() {
		return lrDate;
	}

	public void setLrDate(Date lrDate) {
		this.lrDate = lrDate;
	}

	public String getOfsNo() {
		return ofsNo;
	}

	public void setOfsNo(String ofsNo) {
		this.ofsNo = ofsNo;
	}

	public Integer getDepotId() {
		return depotId;
	}

	public void setDepotId(Integer depotId) {
		this.depotId = depotId;
	}

	public List<ShipmentLine> getShipmentLine() {
		return shipmentLine;
	}

	public void setShipmentLine(List<ShipmentLine> shipmentLine) {
		this.shipmentLine = shipmentLine;
	}

	public void setShipmentHdrId(String shipmentHdrId) {
		this.shipmentHdrId = shipmentHdrId;
	}
}
