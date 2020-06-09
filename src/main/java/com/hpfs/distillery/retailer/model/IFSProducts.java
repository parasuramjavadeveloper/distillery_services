/**
 * 
 */
package com.hpfs.distillery.retailer.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author ram
 *
 */
@Entity
@Table(name="ifs_products")
public class IFSProducts implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ifs_pid")
	private Integer ifsPid;

	/*@Column(name="ifs_num")
	private String ifsNum;*/

	@Column(name="indent_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date indentDate;

	@Column(name="brand_name")
	private String brandName;

	@Column(name="size")
	private Long size;

	@Column(name="qty_in_cases")
	private Long qtyInCases;

	@Column(name="rate_per_case")
	private Float ratePerCase;

	@Column(name="total_amount")
	private Float totalAmount;

	@Column(name="product_code")
	private String productCode;

	@Column(name="status")
	private String status;

	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@Column(name="updated_by")
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

	public Integer getIfsPid() {
		return ifsPid;
	}

	public void setIfsPid(Integer ifsPid) {
		this.ifsPid = ifsPid;
	}

	/*public String getIfsNum() {
		return ifsNum;
	}

	public void setIfsNum(String ifsNum) {
		this.ifsNum = ifsNum;
	}*/

	public Date getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "IFSProducts{" +
				"ifsPid=" + ifsPid +
				//", ifsNum='" + ifsNum + '\'' +
				", indentDate='" + indentDate + '\'' +
				", brandName='" + brandName + '\'' +
				", size=" + size +
				", qtyInCases=" + qtyInCases +
				", ratePerCase=" + ratePerCase +
				", totalAmount=" + totalAmount +
				", productCode='" + productCode + '\'' +
				", status='" + status + '\'' +
				", creationDate='" + creationDate + '\'' +
				", createdBy='" + createdBy + '\'' +
				", updatedDate='" + updatedDate + '\'' +
				", updatedBy='" + updatedBy + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IFSProducts that = (IFSProducts) o;
		return ifsPid.equals(that.ifsPid) &&
				//ifsNum.equals(that.ifsNum) &&
				indentDate.equals(that.indentDate) &&
				brandName.equals(that.brandName) &&
				size.equals(that.size) &&
				qtyInCases.equals(that.qtyInCases) &&
				ratePerCase.equals(that.ratePerCase) &&
				totalAmount.equals(that.totalAmount) &&
				productCode.equals(that.productCode) &&
				status.equals(that.status) &&
				creationDate.equals(that.creationDate) &&
				createdBy.equals(that.createdBy) &&
				updatedDate.equals(that.updatedDate) &&
				updatedBy.equals(that.updatedBy);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ifsPid, indentDate, brandName, size, qtyInCases, ratePerCase, totalAmount, productCode, status, creationDate, createdBy, updatedDate, updatedBy);
	}
}
