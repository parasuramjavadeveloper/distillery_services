package com.hpfs.distillery.retailer.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.hpfs.distillery.retailer.dto.GRNTransactionDto;
import com.hpfs.distillery.retailer.dto.ProcessFeeDto;
import com.hpfs.distillery.retailer.model.TblSupplierTransaction;

public interface SupplierTransactionService {

	public List<TblSupplierTransaction> getAllTxns(String fd, String td, String pd, String supplier,
			Pageable pageRequest);

	public List<TblSupplierTransaction> getRollbackTxns(String pd, String suppliername, Pageable pageRequest);
	
	public List<GRNTransactionDto> getGRNTxns(String fd, String td, String supplier,
			Pageable pageRequest);
	
	public List<TblSupplierTransaction> getMISPaymentTxns(String fd, String td, String supplier, String status, Pageable pageRequest);
	
	public List<TblSupplierTransaction> getGRNPaymentTxns(String fd, String td, String supplier, Pageable pageRequest);
	
	public List<ProcessFeeDto> getProcessFeeTxns(String fd, String td, Pageable pageRequest);
}
