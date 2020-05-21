/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import java.util.List;

import com.hpfs.distillery.retailer.model.TblOrderForSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.VehicleRoute;
import org.springframework.data.repository.query.Param;

/**
 * @author ram
 *
 */
public interface VehicleRouteRepository extends JpaRepository<VehicleRoute, String>, JpaSpecificationExecutor<VehicleRoute> {

	String DIST_SOURCE_QUERY = "select distinct source_disti from distillery.route_details";
	String INTERMEDIATE_ROUTE_QUERY = "select distinct intermediate_depots from distillery.route_details";
	
	@Query(value = DIST_SOURCE_QUERY, nativeQuery = true)
	List<String> fetchDistSourceList();

	@Query(value = INTERMEDIATE_ROUTE_QUERY, nativeQuery = true)
	List<String> fetchIntermediateRouteList();

	String fetchDestinationAndVehicleNumBySource = "SELECT * FROM route_details r WHERE r.source_disti = ?1";

	@Query(value = fetchDestinationAndVehicleNumBySource, nativeQuery = true)
	List<VehicleRoute> fetchDestinationAndVehicleNumBySource(@Param("source") String source);
	
}