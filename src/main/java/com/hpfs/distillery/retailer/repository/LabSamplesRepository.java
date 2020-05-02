package com.hpfs.distillery.retailer.repository;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpfs.distillery.retailer.model.LabSample;

public interface LabSamplesRepository extends JpaRepository<LabSample, Long> {

	//String SHRTGE_D_MAINQUERY = "SELECT * FROM " + SCHEMA + "shortages_d bd ";
	//String DATES_BETWEEN = "WHERE date(bd.creation_date) >= ?1 and date(bd.creation_date)< ?2 ";

	List<LabSample> findAll();

	// @Query(value=SHRTGE_D_MAINQUERY+DATES_BETWEEN,nativeQuery=true)
	// List<LabSample> fetchDateWiseStmts(String startDate, String endDate);

}
