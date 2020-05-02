package com.hpfs.distillery.retailer.repository;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.TblSupplierTransaction;

public interface SupplierTransactionRepository extends JpaRepository<TblSupplierTransaction, Long> {
	
	String SUPPLIER_TXN_QUERY= "SELECT std.id, std.supplier_no, std.supplier_name, std.quantity, std.quantity_part, std.total, std.processfee,std.grn_no, std.grn_processfee, "
			+ "std.paymentclaim_processfee, std.penality, std.automaticdeduction, std.addition, std.deduction, std.netamount, std.processdate, std.process_status, std.discount, std.transactiondate, std.createdby FROM "+SCHEMA+"supplier_transaction_details std ";
	
	String SUPPLIER_TXN_CONDITION=" WHERE (std.transactiondate BETWEEN ?1 AND ?2) AND (std.processdate BETWEEN ?3 AND ?4) AND ((?4 is null or (?5 is not null and std.supplier_name = ?5 )))";
		
	String SUPPLIER_ROLLBACKTXN_CONDITION=" WHERE (std.processdate BETWEEN ?1 AND ?2) AND ((?3 is null or (?3 is not null and std.supplier_name = ?3 )))";
	
	String SUPPLIER_GRN_CONDITION=" WHERE (std.transactiondate BETWEEN ?1 AND ?2) AND ((?3 is null or (?3 is not null and std.supplier_name = ?3 )))";
	
	String SUPPLIER_MISPAYMENT_CONDITION=" WHERE (std.transactiondate BETWEEN ?1 AND ?2) AND ((?3 is null or (?3 is not null and std.supplier_name = ?3 ))) AND ((?4 is null or (?4 is not null and std.process_status = ?4 )))";
	
	String SUPPLIER_PROCESSFEE_CONDITION=" WHERE std.transactiondate BETWEEN ?1 AND ?2";
	
	@Query(value= SUPPLIER_TXN_QUERY+SUPPLIER_TXN_CONDITION,nativeQuery=true)
	List<TblSupplierTransaction> findBySupplierName(Date fd, Date td, Date pdFrom,Date pdTo, String supplier);
	
	@Query(value= SUPPLIER_TXN_QUERY+SUPPLIER_ROLLBACKTXN_CONDITION,nativeQuery=true)
	List<TblSupplierTransaction> findByProcessDateandSupplierName(Date pd1, Date pd2, String supplier);
	
	
	@Query(value= SUPPLIER_TXN_QUERY+SUPPLIER_GRN_CONDITION,nativeQuery=true)
	List<TblSupplierTransaction> findByGRNTxns(Date fd, Date td, String supplier);
	
	@Query(value= SUPPLIER_TXN_QUERY+SUPPLIER_MISPAYMENT_CONDITION,nativeQuery=true)
	List<TblSupplierTransaction> findByMISPaymentTxns(Date fd, Date td, String supplier, String status);
	
	@Query(value= SUPPLIER_TXN_QUERY+SUPPLIER_GRN_CONDITION,nativeQuery=true)
	List<TblSupplierTransaction> findByGRNPaymentTxns(Date fd, Date td, String supplier);
	
	@Query(value= SUPPLIER_TXN_QUERY+SUPPLIER_PROCESSFEE_CONDITION,nativeQuery=true)
	List<TblSupplierTransaction> findByProcessFeeTxns(Date fd, Date td);

}
