package com.hpfs.distillery.retailer.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hpfs.distillery.retailer.dto.ApproveDtsDto;
import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.ReceiptsDts;
import com.hpfs.distillery.retailer.model.TblPurchaseOrders;
import com.hpfs.distillery.retailer.model.TblReceipts;
import com.hpfs.distillery.retailer.model.TblSpiritTypes;
import com.hpfs.distillery.retailer.model.TblSupplierM;
import com.hpfs.distillery.retailer.repository.TblPurchaseOrdersRepository;
import com.hpfs.distillery.retailer.repository.TblReceiptsRepository;
import com.hpfs.distillery.retailer.repository.TblSpiritTypesRepository;
import com.hpfs.distillery.retailer.repository.TblSupplierMRepository;
import com.hpfs.distillery.retailer.utils.ApplicationConstants;
import com.hpfs.distillery.retailer.utils.DateFormatUtils;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class SpiritServiceImpl implements SpiritService {

	@Resource
	TblSpiritTypesRepository tlSpiritTypesRepository;
	
	@Resource
	TblSupplierMRepository tblSupplierMRepository;
	
	@Resource
	TblPurchaseOrdersRepository tblPurchaseOrdersRepository;
	
	@Resource
	TblReceiptsRepository tblReceiptsRepository;
	
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<TblSpiritTypes> fetchActiveReqTypes() {
		return tlSpiritTypesRepository.findAllByStatus(ApplicationConstants.ACTIVE_STATUS);
	}

	@Override
	public List<TblSupplierM> fetchActSuppliers() {
		return tblSupplierMRepository.findAllByStatus(ApplicationConstants.ACTIVE_STATUS);
	}

	@SuppressWarnings("null")
	@Override
	public String saveOrUpdateProcReq(TblPurchaseOrders requestData) {
		String msg="FAILURE";
		TblPurchaseOrders purchaseOrder = new TblPurchaseOrders();
	
		if(Objects.isNull(requestData.getRequestId())) {
			purchaseOrder.setType(requestData.getType());
			purchaseOrder.setRequestedDate(requestData.getRequestedDate());
			purchaseOrder.setSubject(requestData.getSubject());
			purchaseOrder.setRefNum(requestData.getRefNum());
			purchaseOrder.setRefDate(requestData.getRefDate());
			purchaseOrder.setAllotedQuota(requestData.getAllotedQuota());
			purchaseOrder.setRequestedQty(requestData.getRequestedQty());
			purchaseOrder.setReceivedQty(requestData.getReceivedQty());
			purchaseOrder.setCreationDate(DateFormatUtils.DateToString());
			purchaseOrder.setStatus(ApplicationConstants.PENDING_STATUS);
			purchaseOrder.setSupplierId(requestData.getSupplierId());
			purchaseOrder.setSupplierName(requestData.getSupplierName());
			purchaseOrder.setCreatedBy("ADMIN");
			TblPurchaseOrders orderDts = tblPurchaseOrdersRepository.save(purchaseOrder);
			if(orderDts!=null) {
				msg="SUCCESSFULLY SAVED";
			}else {
				msg="FAILURE";
			}
	}
		return msg;
	}

	@Override
	public List<TblPurchaseOrders> fetchDtWiseProcurementDts(TblPurchaseOrders search,PageInfo pageInfo) {
		
		Page<TblPurchaseOrders> pageList =null;
		List<TblPurchaseOrders> gridList = null;
		if(null!=search){
			pageList = tblPurchaseOrdersRepository.fetchProcureDtsByDateWise(search.getRequestedDate(),search.getCreationDate(),
					PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize()));
		}else{
			pageList = tblPurchaseOrdersRepository.fetchAllProcurementDts(PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize()));
		}
		if(Objects.nonNull(pageList)){
			List<TblPurchaseOrders> reportList =  pageList.getContent();
			gridList = reportList.stream().map(entity-> modelMapper.map(entity,TblPurchaseOrders.class)).collect(Collectors.toList());
			pageInfo.setTotalElements(pageList.getTotalElements());
			pageInfo.setTotalPages(pageList.getTotalPages());
		}
		return gridList;
	}

	@Override
	@Transactional
	public String approveStatusByReqIds(ApproveDtsDto dto) {
		String msg="FAILURE";
		try {
		if(dto!=null) {
				TblPurchaseOrders tblPurchaseOrders = tblPurchaseOrdersRepository.findByRequestId(dto.getRequestId());
				if(tblPurchaseOrders!=null) {
					if(tblPurchaseOrders.getStatus().equalsIgnoreCase(ApplicationConstants.PENDING_STATUS)) { 
						tblPurchaseOrders.setStatus(ApplicationConstants.APPROVED_STATUS);
						tblPurchaseOrders.setApprovedBy(dto.getLoginName());
						tblPurchaseOrders.setApprovedDate(DateFormatUtils.DateToString());
						tblPurchaseOrders.setUpdatedBy(dto.getLoginName());
						tblPurchaseOrders.setUpdatedDate(DateFormatUtils.DateToString());
						TblPurchaseOrders updatedDts= tblPurchaseOrdersRepository.save(tblPurchaseOrders);
						if(updatedDts!=null) {
							msg="Procrument Request Approved SUCCESSFULLY";
						}else {
							msg="FAILURE While Procrument Approving";
						}
					}else if(tblPurchaseOrders.getStatus().equalsIgnoreCase(ApplicationConstants.APPROVED_STATUS) && tblPurchaseOrders.getReceiptId()!=null &&
							tblPurchaseOrders.getReceiptStatus().equalsIgnoreCase(ApplicationConstants.PENDING_STATUS)) {
						tblPurchaseOrders.setReceiptStatus(ApplicationConstants.APPROVED_STATUS);
						tblPurchaseOrders.setApprovedBy(dto.getLoginName());
						tblPurchaseOrders.setApprovedDate(DateFormatUtils.DateToString());
						tblPurchaseOrders.setUpdatedBy(dto.getLoginName());
						tblPurchaseOrders.setUpdatedDate(DateFormatUtils.DateToString());
						TblPurchaseOrders updatedDts= tblPurchaseOrdersRepository.save(tblPurchaseOrders);
						if(updatedDts!=null) {
							msg="Receipt Approved SUCCESSFULLY";
						}else {
							msg="FAILURE While Receipt Approving";
						}
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			return msg="FAILURE";
		}
		return msg;
	}

	@Override
	@Transactional
	public String saveOrUpdateReceiptDts(ReceiptsDts requestData) {
		String msg="FAILURE";
		if(requestData.getRequestId()!=null) {
			TblReceipts receipts = new TblReceipts();
			receipts.setCpeTpNo(requestData.getCpeTpNo());
			receipts.setCreationDate(DateFormatUtils.DateToString());
			receipts.setDip(requestData.getDip());
			receipts.setDtpNo(requestData.getDtpNo());
			receipts.setReceiptDate(requestData.getReceiptDate());
			receipts.setReceivedQty(requestData.getReceivedQty());
			receipts.setRemainingQty(requestData.getRemainingQty());
			receipts.setRemarks(requestData.getRemarks());
			receipts.setVehicleNum(requestData.getVehicleNum());
			receipts.setStorageTankNo(requestData.getStorageTankNo());
			receipts.setStrength(requestData.getStrength());
			receipts.setWastage(requestData.getWastage());
			receipts.setSupplierName(requestData.getSupplierName());
			receipts.setActualqty(requestData.getActualqty());
			TblReceipts recept = tblReceiptsRepository.save(receipts);
			if(recept!=null) {
				TblPurchaseOrders tblPurchaseOrders = tblPurchaseOrdersRepository.findByRequestId(requestData.getRequestId());
				if(tblPurchaseOrders!=null) {
					tblPurchaseOrders.setUpdatedDate(DateFormatUtils.DateToString());
					tblPurchaseOrders.setReceiptId(recept.getReceiptId());
					tblPurchaseOrders.setReceiptStatus(ApplicationConstants.PENDING_STATUS);
					TblPurchaseOrders updatedDts= tblPurchaseOrdersRepository.save(tblPurchaseOrders);
					if(updatedDts!=null) {
						msg="Receipt Created SUCCESSFULLY";
					}else {
						msg="FAILURE While Receipt Creation";
					}
				}
			}
		}
		return msg;
	}

	@Override
	public TblReceipts fetchInvoiceDtsByReceptId(TblReceipts requestData) {
		TblReceipts rec =null;
		if(requestData!=null && null!=requestData.getReceiptId()) {
			rec = tblReceiptsRepository.findByReceiptId(requestData.getReceiptId());
		}
		return rec;
	}

	@Override
	@Transactional
	public String saveInvoiceReceiptDts(TblReceipts requestData) {
		String msg="FAILURE";
		try {
			if(requestData!=null && requestData.getReceiptId()!=null) {
				TblReceipts receiptDts = tblReceiptsRepository.findByReceiptId(requestData.getReceiptId());
				if(receiptDts!=null) {
					receiptDts.setInvoiceDate(requestData.getInvoiceDate());
					receiptDts.setInvoiceNo(requestData.getInvoiceNo());
					receiptDts.setInvoiceAmt(requestData.getInvoiceAmt());
					receiptDts.setTaxAmt(requestData.getTaxAmt());
					receiptDts.setUpdatedDate(DateFormatUtils.DateToString());
					TblReceipts receipt = tblReceiptsRepository.save(receiptDts);
					if(receipt!=null) {
						msg="Invoice Details Created SUCCESSFULLY";
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			return msg;
		}
		return msg;
	}

	@Override
	public List<TblReceipts> fetchAllReceipts() {
		// TODO Auto-generated method stub
		return  tblReceiptsRepository.findAll();
	}

	@Override
	public List<TblReceipts> fetchdateWiseReceiptStmts(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return tblReceiptsRepository.fetchDateWiseStmts(startDate,endDate);
	}

}
