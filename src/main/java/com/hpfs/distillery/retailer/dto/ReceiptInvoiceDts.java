/**
 * 
 */
package com.hpfs.distillery.retailer.dto;

/**
 * @author babasaheb
 *
 */
public class ReceiptInvoiceDts {
	
	public Long requestId;
	public Long receiptId;
	public String receiptDate;
	public String supplierName;
	public String invoiceNo;
	public Float invoiceAmt;
	public Float taxAmt;
	
	
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

		
}
