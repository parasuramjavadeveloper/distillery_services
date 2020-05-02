/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.GridLicenseDts;

/**
 * @author babasaheb
 *
 */
public interface GridLicenseDtsRepository extends JpaRepository<GridLicenseDts,Long> {
	String LICENSE_DTS_FROM=" FROM "+SCHEMA+"license_details l " + 
			" INNER JOIN "+SCHEMA+"retailers_m  r on l.retailer_code = r.retailer_code " + 
			" INNER JOIN "+SCHEMA+"depot_m  d on r.depot_id = d.depot_id " + 
			" INNER JOIN "+SCHEMA+"users u on r.user_id = u.user_id ";
	String LICENSE_DTS_MAINQUERY="SELECT l.license_detail_id,l.issued_date,l.expiry_date, l.retailer_code," + 
			"r.shop_name, d.depot_id, d.depot_name, u.user_id, u.mobile_number, u.email_id "+
			LICENSE_DTS_FROM;
	String LICENSE_DTS_CONDITION="WHERE ((?1 is null or (?1 is not null and l.license_detail_id = ?1)))"+
	            "AND ((?2 is  null or (?2 is not null and issued_date like '%'||upper(?2)||'%' ) ))"+
	            "AND ((?3 is null or (?3 is not null and l.expiry_date like '%'||upper(?3)||'%' ) ))"+
	            "AND ((?4 is null or (?4 is not null and l.retailer_code like '%'||upper(?4)||'%' ) ))"+
	            "AND ((?5 is null or (?5 is not null and r.shop_name like '%'||upper(?5)||'%' ) ))"+
	            "AND ((?6 is null or (?6 is not null and d.depot_id = ?6) ))"+
	            "AND ((?7 is null or (?7 is not null and d.depot_name like '%'||upper(?7)||'%' ) ))"+
	            "AND ((?8 is null or (?8 is not null and u.user_id =?8) ))"+
	            "AND ((?9 is null or (?9 is not null and u.mobile_number =?9) ))"+
				"AND ((?10 is null or (?10 is not null and u.email_id like '%'||upper(?10)||'%' ) ))";

	    @Query(value= LICENSE_DTS_MAINQUERY+" #{#pageable}",
	            countQuery="SELECT COUNT(1) "+LICENSE_DTS_FROM,nativeQuery=true)
	    Page<GridLicenseDts> fetchAllLicenseDts(Pageable pageable);

	    @Query(value=LICENSE_DTS_MAINQUERY+LICENSE_DTS_CONDITION+"  #{#pageable}",
	            countQuery="SELECT COUNT(1) "+LICENSE_DTS_MAINQUERY+LICENSE_DTS_CONDITION,nativeQuery=true)
	    Page<GridLicenseDts> fetchLicenseDtsBy(Long licenseDetailId,
									    		String issuedDate,String expiryDate,
									    		String retailerCode,String shopName,
									    		Long depotId,String depotName,
									    		Long userId,String mobileNumber,String emailId, Pageable pageable);
}
