package com.hpfs.distillery.retailer.repository;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.TblRetailerPaymentDetails;

public interface CartDetailsDRepository extends JpaRepository<TblRetailerPaymentDetails, Long> {
	
	
	String INDENT_MGT_FROMQUERY= " FROM "+SCHEMA+"cart_details im " + 
			" INNER JOIN "+SCHEMA+"retailer_payment_d rm ON im.retailer_code=rm.retailer_code ";
	
	String INDENT_MGT_MAINQUERY="SELECT rm.retailer_payment_id,rm.cheque_number,rm.payment_date,rm.payment_type,rm.status,rm.retailer_code," + 
			"               rm.creation_date," + 
			"               rm.status," + 
			"               rm.amount,rm.creation_date,rm.created_by,rm.updated_date,rm.updated_by "+ INDENT_MGT_FROMQUERY;
			
			
	   @Query(value=INDENT_MGT_MAINQUERY,nativeQuery=true)
	    List<TblRetailerPaymentDetails> fetchAllCartDetails();
	
	String STOCK_DTS_FROM="FROM "+SCHEMA+"cart_details dm \n" + 
			"INNER JOIN retailer_payment_d dt \n" + 
			"ON dm.retailer_code=dt.retailer_code ";
	
	String STOCK_DTS_MAINQUERY="SELECT dm.retailer_code,dm.size,\n" + 
			"               dt.status,\n" + 
			STOCK_DTS_FROM;
	

	    @Query(value= STOCK_DTS_MAINQUERY+" #{#pageable}",
	            countQuery="SELECT COUNT(1) "+STOCK_DTS_FROM,nativeQuery=true)
	    Page<TblRetailerPaymentDetails> fetchAllStockDts(Pageable pageable);
	    
	String INDENT_DTS_CONDITION = "WHERE ((?1 is null or (?1 is not null and retailer_code=?1)))"
			+ "AND ((?2 is  null or (?2 is not null and status=?2 ) ))"
			+ "AND ((?3 is null or (?3 is not null and payment_date = ?3 ) ))"
			+ "AND ((?4 is null or (?4 is not null and paymentType = ?4 ) ))"
			+ "AND ((?5 is null or (?5 is not null and amount = ?5 ) ))";
//			+ "AND ((?6 is null or (?6 is not null and amount = ?6 ) ))";
//			+ "AND ((?7 is null or (?7 is not null and chequeNumber = ?7 ) ))"
//			+ "AND ((?8 is null or (?8 is not null and creationDate = ?8 ) ))";


	@Query(value = "SELECT * FROM " + SCHEMA + "retailer_payment_d " + INDENT_DTS_CONDITION
			+ "  #{#pageable}", countQuery = "SELECT COUNT(1) FROM " + SCHEMA + "retailer_payment_d "
					+ INDENT_DTS_CONDITION, nativeQuery = true)
	Page<TblRetailerPaymentDetails> fetchCartRetailDtsBy(String retailerCode,  String status,Date paymentDate,
			String paymentType, double amount, Pageable pageable);
}
//	Page<TblRetailerPaymentDetails> fetchCartRetailDtsBy(int retailerPaymentId, String retailerCode, Date paymentDate,
//			String paymentType, String status, double amount, String chequeNumber, String creationDate,
//			String createdBy, PageRequest of);
//}
