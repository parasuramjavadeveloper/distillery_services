package com.hpfs.distillery.retailer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.dto.VehicleRouteDto;
import com.hpfs.distillery.retailer.dto.VehicleTrackingDto;
import com.hpfs.distillery.retailer.model.VehicleRoute;
import com.hpfs.distillery.retailer.model.VehicleTracking;
import com.hpfs.distillery.retailer.service.VehicleRouteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=100000L) 
@RequestMapping("/api/dist")
public class VehicleTrackingController {
	
	public static final Logger logger = LoggerFactory.getLogger(VehicleTrackingController.class);
	
	@Autowired
	VehicleRouteService vehicleRouteService;

	/*@ApiOperation(value="fetchActiveVehileDts",notes="fetch fetchActiveVehileDts Price List dts",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchActVehicleDts")
	public Response<List<TblVehicleM>> fetchActiveVehDts(){
		List<TblVehicleM> responseDataList = distilleryService.fetchActiveVehDts();
		return new Response<List<TblVehicleM>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);
	}*/
	
	@ApiOperation(value="saveRouteDetails",notes="fetch fetchActscanCaseBarNo dts",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/saveRouteDetails")
	public Response<VehicleRoute> saveRouteDetails(@RequestBody Request<VehicleRouteDto> request){
		VehicleRoute responseData = vehicleRouteService.saveVehicleRoute(null!=request ? request.getRequestData(): null);
		return new Response<VehicleRoute> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				responseData);

	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/saveVehicleLongitudeAndLatitude")
	public Response<VehicleTracking> saveVehicleLongitudeAndLatitude(@RequestBody Request<VehicleTracking> request){
		VehicleTracking responseData = vehicleRouteService.saveVehicleLongitudeAndLatitude(null!=request ? request.getRequestData(): null);
		return new Response<VehicleTracking> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				responseData);

	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchActVehicleLongitudeAndLatitudes")
	public Response<VehicleTracking> fetchVehicleLongitudeAndLatitudes(@Param(value = "vehicleNum") String vehicleNum){
		VehicleTracking responseDataList = vehicleRouteService.fetchVehicleLongitudeAndLatitudes(vehicleNum);
		return new Response<VehicleTracking> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchDestinationsAndVehicleNumBySource")
	public Response<List<VehicleRoute> > fetchDestinationsAndVehicleNumBySource(@Param(value = "source")String source,@Param(value = "vehicleNum")String vehicleNum){
		VehicleRouteDto vehicleRouteDto = new VehicleRouteDto(source,vehicleNum);
		List<VehicleRoute>  responseDataList = vehicleRouteService.fetchDestinationsAndVehicleNumBySource(vehicleRouteDto);
		return new Response<List<VehicleRoute> > (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/addVehicleTracking")
	public Response<String> addVehicleTracking(@RequestBody Request<VehicleTrackingDto> request){
		String responseDataList = vehicleRouteService.addVehicleTracking(null!=request ? request.getRequestData(): null);
		return new Response<String> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				responseDataList);

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchDistSourceList")
	public Response<List<String>> fetchDistSourceList(){
		List<String> responseData = vehicleRouteService.fetchDistSourceList();
		return new Response<List<String>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseData);

	}
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchIntermediateRouteList")
	public Response<List<String>> fetchIntermediateRouteList(){
		List<String> responseData = vehicleRouteService.fetchIntermediateRouteList();
		return new Response<List<String>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseData);

	}
		
}