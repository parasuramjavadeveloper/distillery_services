/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.TblPurchaseOrders;

/**
 * @author babasaheb
 *
 */
public interface TblPurchaseOrdersRepository extends JpaRepository<TblPurchaseOrders,Long> {
	
	String PROCUREMENT_FROM="FROM "+SCHEMA+"purchase_orders ";
	String DATES_BETWEEN= "WHERE date(requested_date) >= ?1 and date(requested_date)< ?2 ";
	
	@Query(value= "SELECT * "+PROCUREMENT_FROM+" #{#pageable}",
            countQuery="SELECT COUNT(1) "+"FROM "+SCHEMA+"purchase_orders ",nativeQuery=true)
	Page<TblPurchaseOrders> fetchAllProcurementDts(Pageable pageable);
	
	@Query(value= "SELECT * "+PROCUREMENT_FROM + DATES_BETWEEN +"  #{#pageable}",
	            countQuery="SELECT COUNT(1) "+PROCUREMENT_FROM + DATES_BETWEEN,nativeQuery=true)
	Page<TblPurchaseOrders> fetchProcureDtsByDateWise(String startDt,String endDt,Pageable pageable);

	TblPurchaseOrders findByRequestId(Long reqId);
	
	
	
}
