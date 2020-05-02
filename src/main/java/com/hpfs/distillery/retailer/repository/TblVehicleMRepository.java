/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpfs.distillery.retailer.model.TblVehicleM;

/**
 * @author babasaheb
 *
 */
public interface TblVehicleMRepository extends JpaRepository<TblVehicleM,Long> {
	
	List<TblVehicleM> findAllByStatus(String status);
	
	
}
