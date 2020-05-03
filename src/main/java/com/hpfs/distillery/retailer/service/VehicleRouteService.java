package com.hpfs.distillery.retailer.service;

import java.util.List;

import com.hpfs.distillery.retailer.dto.VehicleRouteDto;
import com.hpfs.distillery.retailer.dto.VehicleTrackingDto;
import com.hpfs.distillery.retailer.model.VehicleRoute;
import com.hpfs.distillery.retailer.model.VehicleTracking;

public interface VehicleRouteService {


	VehicleRoute saveVehicleRoute(VehicleRouteDto vehicleRouteDto);
	
	VehicleTracking saveVehicleLongitudeAndLatitude(VehicleTracking vehicleTracking);
	
	VehicleTracking fetchVehicleLongitudeAndLatitudes(String vehicleNum);
	
	List<VehicleRoute> fetchDestinationsAndVehicleNumBySource(String source);

	String addVehicleTracking(VehicleTrackingDto dto);

	List<String> fetchDistSourceList();

	List<String> fetchIntermediateRouteList();

}
