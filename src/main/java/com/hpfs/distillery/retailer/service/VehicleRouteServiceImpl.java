package com.hpfs.distillery.retailer.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hpfs.distillery.retailer.dto.VehicleRouteDto;
import com.hpfs.distillery.retailer.dto.VehicleTrackingDto;
import com.hpfs.distillery.retailer.model.VehicleRoute;
import com.hpfs.distillery.retailer.model.VehicleTracking;
import com.hpfs.distillery.retailer.repository.VehicleRouteRepository;
import com.hpfs.distillery.retailer.repository.VehicleTrackingRepository;
import com.hpfs.distillery.retailer.utils.DateFormatUtils;
import com.hpfs.distillery.retailer.utils.DtoToModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VehicleRouteServiceImpl implements VehicleRouteService {

	@Resource
	private VehicleRouteRepository vehicleRouteRepository;
	
	@Resource
	private VehicleTrackingRepository vehicleTrackingRepository;

	DtoToModel dtoToModel = new DtoToModel();

	@Override
	public VehicleRoute saveVehicleRoute(VehicleRouteDto vehicleRouteDto) {

		// VehicleRoute vehicleRoute = dtoToModel.toVehicleRoute(vehicleRouteDto);
		return vehicleRouteRepository.save(dtoToModel.toVehicleRoute(vehicleRouteDto));
	}

	@Override
	public VehicleTracking saveVehicleLongitudeAndLatitude(VehicleTracking vehicleTracking) {
		return vehicleTrackingRepository.save(vehicleTracking);
	}

	@Override
	public VehicleTracking fetchVehicleLongitudeAndLatitudes(String vehicleNum) {
		return vehicleTrackingRepository.findByVehicleNum(vehicleNum); 
	}

	@Override
	public List<VehicleRoute> fetchDestinationsAndVehicleNumBySource(VehicleRouteDto vehicleRouteDto) {
		return vehicleRouteRepository.findAll(new VehicleRouteSpecification(vehicleRouteDto));
	}

	@Override
	public String addVehicleTracking(VehicleTrackingDto dto) {
		String msg ="FAILURE";
		if(dto!=null) {
			int i=0;
			for(String routeName :dto.getRouteName()) {
				
				VehicleTracking tracking = new VehicleTracking();
				tracking.setCases(dto.getCases());
				tracking.setTpVehicleNumber(dto.getTpVehicleNumber());
				tracking.setVehicleNum(dto.getVehicleNum());
				tracking.setDistilleryName(dto.getDistilleryName());
				tracking.setDestination(dto.getDestination());
				tracking.setRouteName(routeName);
				tracking.setCreationDate(DateFormatUtils.DateToString());
				VehicleTracking vt = vehicleTrackingRepository.save(tracking);
				if(vt!=null) {
					i++;
				}
			}
			if(i==dto.getRouteName().size()) {
				msg="SUCCESSFULLY ADDED";
			}
		}
		return msg;
	}
	
	@Override
	public List<String> fetchDistSourceList() {
		List<String> distSrcList =null;
		{
			distSrcList = vehicleRouteRepository.fetchDistSourceList();
		}
		
		return distSrcList;
	}

	@Override
	public List<String> fetchIntermediateRouteList() {
		List<String> purposeList =null;
		{
			purposeList = vehicleRouteRepository.fetchIntermediateRouteList();
		}
		
		return purposeList;
	}

}