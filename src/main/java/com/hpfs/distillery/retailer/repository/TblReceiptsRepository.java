/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.TblReceipts;

/**
 * @author babasaheb
 *
 */
public interface TblReceiptsRepository extends JpaRepository<TblReceipts,Long> {
	
	String receipts_MAINQUERY="SELECT * FROM "+SCHEMA+"receipts bd ";
	String DATES_BETWEEN= "WHERE date(bd.receipt_date) >= ?1 and date(bd.receipt_date) <= ?2 ";
	TblReceipts findByReceiptId(Long receiptId);

	List<TblReceipts> findAll();
	@Query(value=receipts_MAINQUERY+DATES_BETWEEN,nativeQuery=true)
	List<TblReceipts> fetchDateWiseStmts(String startDate, String endDate);
	
}
