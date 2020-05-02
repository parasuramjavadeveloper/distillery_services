package com.hpfs.distillery.retailer.repository;
import com.hpfs.distillery.retailer.model.TblExciseDuty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

import java.util.List;

public interface ExciseDutyRepository extends JpaRepository<TblExciseDuty,String> {

	String BRKGE_D_MAINQUERY="SELECT * FROM "+SCHEMA+"excise_duty bd ";
	String DATES_BETWEEN= "WHERE date(bd.creation_date) >= ?1 and date(bd.creation_date)< ?2 ";

	String CHALLAN_TYPE_QRY="SELECT DISTINCT challan_type FROM "+SCHEMA+"excise_duty bd ";
	
  String qry="SELECT * FROM distillery.excise_duty where challan_type=?1";
    @Query(value = qry,nativeQuery = true)
    List<TblExciseDuty> fetchwithParams(String challanType);


    List<TblExciseDuty> findAll();

    @Query(value=BRKGE_D_MAINQUERY+DATES_BETWEEN,nativeQuery=true)
	List<TblExciseDuty> fetchDateWiseStmts(String startDate, String endDate);

    @Query(value=CHALLAN_TYPE_QRY,nativeQuery=true)
	List<String> fetchChallanTypeList();


}