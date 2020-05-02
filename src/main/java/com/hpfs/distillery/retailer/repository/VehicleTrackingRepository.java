/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpfs.distillery.retailer.model.VehicleTracking;

/**
 * @author ram
 *
 */
public interface VehicleTrackingRepository extends JpaRepository<VehicleTracking,Long> {

	VehicleTracking findByVehicleNum(String vehicleNum);
	
}
