package com.hpfs.distillery.retailer.repository;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.TblShortageDetails;

public interface TblShortageInfoRepository extends JpaRepository<TblShortageDetails,Long> {
	 
	String SHRTGE_D_MAINQUERY="SELECT * FROM "+SCHEMA+"shortages_d bd ";
	String DATES_BETWEEN= "WHERE date(bd.creation_date) >= ?1 and date(bd.creation_date)< ?2 ";
	
	List<TblShortageDetails> findAll();

	 @Query(value=SHRTGE_D_MAINQUERY+DATES_BETWEEN,nativeQuery=true)
	List<TblShortageDetails> fetchDateWiseStmts(String startDate, String endDate);
}
