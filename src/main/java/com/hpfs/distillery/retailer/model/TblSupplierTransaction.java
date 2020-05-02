package com.hpfs.distillery.retailer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Durga Prasad Gummadi
 *
 */
@Entity
@Table(name = "supplier_transaction_details")
public class TblSupplierTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long id;

	@Column(name = "supplier_no")
	public Long supplierNo;

	@Column(name = "supplier_name")
	public String supplierName;

	@Column(name = "quantity")
	public Long quantity;

	@Column(name = "quantity_part")
	public String quantityPart;

	@Column(name = "total")
	public Long total;

	@Column(name = "processfee")
	public double processFee;

	@Column(name = "grn_processfee")
	public double grnProcessFee;

	@Column(name = "paymentclaim_processfee")
	public double paymentClaimProcessFee;

	@Column(name = "penality")
	public double penality;

	@Column(name = "automaticdeduction")
	public double automaticDeduction;

	@Column(name = "addition")
	public double addition;

	@Column(name = "deduction")
	public double deduction;

	@Column(name = "netamount")
	public double netAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "processdate")
	public Date processDate;

	@Column(name = "discount")
	public double discount;

	@Column(name = "transactiondate")
	public Date transactionDate;

	@Column(name = "createdby")
	public String createdBy;
	
	@Column(name = "grn_no")
	public String grnNo;
	
	@Column(name="process_status")
	public String processStatus;

	public Long getSupplierNo() {
		return supplierNo;
	}

	public void setSupplierNo(Long supplierNo) {
		this.supplierNo = supplierNo;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getQuantityPart() {
		return quantityPart;
	}

	public void setQuantityPart(String quantityPart) {
		this.quantityPart = quantityPart;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public double getProcessFee() {
		return processFee;
	}

	public void setProcessFee(double processFee) {
		this.processFee = processFee;
	}

	public double getGrnProcessFee() {
		return grnProcessFee;
	}

	public void setGrnProcessFee(double grnProcessFee) {
		this.grnProcessFee = grnProcessFee;
	}

	public double getPaymentClaimProcessFee() {
		return paymentClaimProcessFee;
	}

	public void setPaymentClaimProcessFee(double paymentClaimProcessFee) {
		this.paymentClaimProcessFee = paymentClaimProcessFee;
	}

	public double getPenality() {
		return penality;
	}

	public void setPenality(double penality) {
		this.penality = penality;
	}

	public double getAutomaticDeduction() {
		return automaticDeduction;
	}

	public void setAutomaticDeduction(double automaticDeduction) {
		this.automaticDeduction = automaticDeduction;
	}

	public double getAddition() {
		return addition;
	}

	public void setAddition(double addition) {
		this.addition = addition;
	}

	public double getDeduction() {
		return deduction;
	}

	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getGrnNo() {
		return grnNo;
	}

	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	
	

	
}
