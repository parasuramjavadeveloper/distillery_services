package com.hpfs.distillery.retailer.repository;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.TblBreakageDetails;

public interface TblBreakageInfoRepository extends JpaRepository<TblBreakageDetails,Long>  {
	
	String BRKGE_D_MAINQUERY="SELECT * FROM "+SCHEMA+"breakages_d bd ";
	String DATES_BETWEEN= "WHERE date(bd.creation_date) >= ?1 and date(bd.creation_date)< ?2 ";
	
	String PRODUCT_TYPE_QRY="SELECT DISTINCT product_type FROM "+SCHEMA+"breakages_d bd ";
	
	List<TblBreakageDetails> findAll();

	  @Query(value=BRKGE_D_MAINQUERY+DATES_BETWEEN,nativeQuery=true)
	List<TblBreakageDetails> fetchDateWiseStmts(String startDate, String endDate);

	  @Query(value=PRODUCT_TYPE_QRY,nativeQuery=true)
	List<String> fetchProductTypeList();



}
