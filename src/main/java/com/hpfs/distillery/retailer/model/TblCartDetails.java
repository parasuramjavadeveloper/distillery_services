package com.hpfs.distillery.retailer.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	/**
	 * @author Vamsi Alla
	 *
	 */
	@Entity
	@Table(name="cart_details")
	public class TblCartDetails {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="id")
		public int id;

		@Column(name="retailer_code")
		public String retailerCode;

		@Column(name="distillery_id")
		public int distilleryId;

		@Column(name="brand_name")
		public String brandName;

		@Column(name="size")
		public int size;

		@Column(name="quantity")
		public int quantity;

		@Column(name="unit_price")
		public Long unitPrice;

		@Column(name="total_price")
		public Long totalPrice;

		@Column(name="creation_date")
		public String creationDate;

		@Column(name="created_by")
		public String createdBy;

		@Column(name="updated_date")
		public String updatedDate;

		@Column(name="updated_by")
		public String updatedBy;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getRetailerCode() {
			return retailerCode;
		}

		public void setRetailerCode(String retailerCode) {
			this.retailerCode = retailerCode;
		}

		public int getDistilleryId() {
			return distilleryId;
		}

		public void setDistilleryId(int distilleryId) {
			this.distilleryId = distilleryId;
		}

		public String getBrandName() {
			return brandName;
		}

		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public Long getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(Long unitPrice) {
			this.unitPrice = unitPrice;
		}

		public Long gettotalPrice() {
			return totalPrice;
		}

		public void settotalPrice(Long totalPrice) {
			this.totalPrice = totalPrice;
		}

		public String getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(String creationDate) {
			this.creationDate = creationDate;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public String getUpdatedDate() {
			return updatedDate;
		}

		public void setUpdatedDate(String updatedDate) {
			this.updatedDate = updatedDate;
		}

		public String getUpdatedBy() {
			return updatedBy;
		}

		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}

		
		

}
