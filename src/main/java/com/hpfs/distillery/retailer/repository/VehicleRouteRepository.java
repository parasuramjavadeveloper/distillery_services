/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.VehicleRoute;

/**
 * @author ram
 *
 */
public interface VehicleRouteRepository extends JpaRepository<VehicleRoute,String> {

	String DIST_SOURCE_QUERY = "select distinct source_disti from distillery.route_details";
	String INTERMEDIATE_ROUTE_QUERY = "select distinct intermediate_depots from distillery.route_details";
	
	@Query(value = DIST_SOURCE_QUERY, nativeQuery = true)
	List<String> fetchDistSourceList();

	@Query(value = INTERMEDIATE_ROUTE_QUERY, nativeQuery = true)
	List<String> fetchIntermediateRouteList();
	
}
