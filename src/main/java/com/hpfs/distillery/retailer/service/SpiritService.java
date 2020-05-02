package com.hpfs.distillery.retailer.service;

import java.util.List;

import com.hpfs.distillery.retailer.dto.ApproveDtsDto;
import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.ReceiptsDts;
import com.hpfs.distillery.retailer.model.TblPurchaseOrders;
import com.hpfs.distillery.retailer.model.TblReceipts;
import com.hpfs.distillery.retailer.model.TblSpiritTypes;
import com.hpfs.distillery.retailer.model.TblSupplierM;

public interface SpiritService {

	List<TblSpiritTypes> fetchActiveReqTypes();

	List<TblSupplierM> fetchActSuppliers();

	String saveOrUpdateProcReq(TblPurchaseOrders requestData);

	List<TblPurchaseOrders> fetchDtWiseProcurementDts(TblPurchaseOrders search, PageInfo pageInfo);

	String approveStatusByReqIds(ApproveDtsDto dto);

	String saveOrUpdateReceiptDts(ReceiptsDts requestData);

	TblReceipts fetchInvoiceDtsByReceptId(TblReceipts requestData);

	String saveInvoiceReceiptDts(TblReceipts requestData);

	List<TblReceipts> fetchAllReceipts();

	List<TblReceipts> fetchdateWiseReceiptStmts(String startDate, String endDate);

}
