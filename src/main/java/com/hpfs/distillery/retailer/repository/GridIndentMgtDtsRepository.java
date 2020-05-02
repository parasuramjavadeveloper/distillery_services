/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hpfs.distillery.retailer.model.GridIndentMgtDts;

/**
 * @author babasaheb
 *
 */
public interface GridIndentMgtDtsRepository extends JpaRepository<GridIndentMgtDts,Long> {
	
	String INDENT_MGT_FROMQUERY= " FROM "+SCHEMA+"indent_m im " + 
			" INNER JOIN "+SCHEMA+"retailers_m rm ON im.retailer_code=rm.retailer_code " + 
			" INNER JOIN "+SCHEMA+"depot_m dm ON rm.depot_id=dm.depot_id ";
	
	String INDENT_MGT_MAINQUERY="SELECT dm.depot_id,rm.shop_name," + 
			"               dm.depot_name," + 
			"               dm.location," + 
			"               dm.district," + 
			"               im.indent_creation_date," + 
			"               im.authorised_person,im.creation_date,im.created_by "+ INDENT_MGT_FROMQUERY;
	
	String INDENT_MGT_DTS_CONDITION="WHERE ((?1 is null or (?1 is not null and shop_name like '%'||upper(?1)||'%')))"+
	            "AND ((?2 is  null or (?2 is not null and depot_name like '%'||upper(?2)||'%' ) ))"+
	            "AND ((?3 is null or (?3 is not null and dm.depot_id = ?3 ) ))"+
	            "AND ((?4 is null or (?4 is not null and dm.location like '%'||upper(?4)||'%' ) ))"+
	            "AND ((?5 is null or (?5 is not null and dm.district like '%'||upper(?5)||'%' ) ))"+
	            "AND ((?6 is null or (?6 is not null and im.indent_creation_date like '%'||upper(?6)||'%' ) ))"+
	            "AND ((?7 is null or (?7 is not null and im.authorised_person like '%'||upper(?7)||'%' ) ))";
	
	String INDENT_MGT_30DAYS= "WHERE im.indent_creation_date > ?1";
	
	String DATES_BETWEEN= "WHERE date(im.indent_creation_date) >= ?1 and date(im.indent_creation_date)< ?2 ";

	    @Query(value= INDENT_MGT_MAINQUERY+" #{#pageable}",
	            countQuery="SELECT COUNT(1) "+INDENT_MGT_FROMQUERY,nativeQuery=true)
	    Page<GridIndentMgtDts> fetchAllIndentMgmDts(Pageable pageable);

	    @Query(value=INDENT_MGT_MAINQUERY+INDENT_MGT_DTS_CONDITION+"  #{#pageable}",
	            countQuery="SELECT COUNT(1) "+INDENT_MGT_FROMQUERY+INDENT_MGT_DTS_CONDITION,nativeQuery=true)
	    Page<GridIndentMgtDts> fetchIndentMgmDtsBy(String shopName,String depotName,Long depotId,
	    		String location,String district,String indentCreationDate,String authorisedPerson,Pageable pageable);
	    
	    @Query(value=INDENT_MGT_MAINQUERY+DATES_BETWEEN,nativeQuery=true)
	    List<GridIndentMgtDts> fetchDateWiseStmts(String startDate,String endDate);
	    
	    @Query(value=INDENT_MGT_MAINQUERY+INDENT_MGT_30DAYS,nativeQuery=true)
	    List<GridIndentMgtDts> fetchLast30DaysGridIndDts(String lastMonth);
	    
	    @Query(value=INDENT_MGT_MAINQUERY,nativeQuery=true)
	    List<GridIndentMgtDts> fetchOldArchives();
}
