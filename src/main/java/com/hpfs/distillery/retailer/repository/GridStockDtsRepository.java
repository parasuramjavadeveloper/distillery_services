/**
 * /**
 * @author babasaheb
 *
 */
 
package com.hpfs.distillery.retailer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.GridStockDts;
import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;


public interface GridStockDtsRepository extends JpaRepository<GridStockDts,Long> {
	
	String STOCK_DTS_FROM="FROM "+SCHEMA+"depot_inventory_m dm \n" + 
			"LEFT JOIN depot_transactions dt \n" + 
			"ON dm.depot_id=dt.depot_id ";
	
	String STOCK_DTS_MAINQUERY="SELECT dm.depot_inv_id,dm.product_code,\n" + 
			"               dm.product_type,\n" + 
			"               dm.brand_name,\n" + 
			"               COALESCE(dt.opening_balance,dm.available_qty) as opening_balance,\n" + 
			"               COALESCE(dt.sales,10) as sales,\n" + 
			"               COALESCE(dt.closing_balance,dm.available_qty) as closing_balance,\n" + 
			"               COALESCE(dt.breakages,0) as breakages, \n" + 
			"               COALESCE(dt.shortages,0) as shortages "+
			STOCK_DTS_FROM;
	String STOCK_DTS_CONDITION="WHERE ((?1 is null) or (?1 is not null and dm.depot_inv_id = ?1))"+
	            "AND ((?2 is  null) or (?2 is not null and dm.product_type like '%'||upper(?2)||'%'))"+
	            "AND ((?3 is null) or (?3 is not null and dm.brand_name like '%'||upper(?3)||'%'))"+
	            "AND ((?4 is null) or (?4 is not null and COALESCE(dt.opening_balance,dm.available_qty) = ?4))"+
	            "AND ((?5 is null) or (?5 is not null and  COALESCE(dt.sales,10) = ?5))"+
	            "AND ((?6 is null) or (?6 is not null and COALESCE(dt.closing_balance,dm.available_qty) = ?6 ))"+
	            "AND ((?7 is null) or (?7 is not null and COALESCE(dt.breakages,0) = ?7))"+
	            "AND ((?8 is null) or (?8 is not null and COALESCE(dt.shortages,0) =?8))";

	    @Query(value= STOCK_DTS_MAINQUERY+" #{#pageable}",
	            countQuery="SELECT COUNT(1) "+STOCK_DTS_FROM,nativeQuery=true)
	    Page<GridStockDts> fetchAllStockDts(Pageable pageable);

	    @Query(value=STOCK_DTS_MAINQUERY+STOCK_DTS_CONDITION+"  #{#pageable}",
	            countQuery="SELECT COUNT(1) "+STOCK_DTS_MAINQUERY+STOCK_DTS_CONDITION,nativeQuery=true)
	    Page<GridStockDts> fetchStockDtsBy(Long depotInvId,String productCode,
									    		String productType,String brandName,
									    		Long openingBalance,Long sales,
									    		Long closingBalance,Long breakages,
									    		Long shortages,Pageable pageable);
}
