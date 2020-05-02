package com.hpfs.distillery.retailer.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.dto.ShipmentHeaderDto;
import com.hpfs.distillery.retailer.model.ShipmentHeader;
import com.hpfs.distillery.retailer.service.LabDetailsService;
import com.hpfs.distillery.retailer.service.ShipmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 100000L)
@RequestMapping("/api/shipment")
public class ShipmentController {

	@Autowired
	LabDetailsService labDetailsService;
	
	@Autowired
	ShipmentService shipmentService;

	@ApiOperation(value = "saveTransportPermitRequest", notes = "saveTransportPermitRequest", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/saveTransportPermitRequest")
	public Response<ShipmentHeader> saveTransportPermitRequest(@RequestBody Request<ShipmentHeaderDto> request)
			throws SerialException, SQLException, IOException {
		ShipmentHeader shipmentHeader = shipmentService.saveTransportPermitRequest(request.getRequestData());
		return new Response<ShipmentHeader>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), shipmentHeader);

	}

	/*@ApiOperation(value = "getAllSamples", notes = "getAllSamples", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getAllSamples")
	public Response<List<LabSample>> getAllSamples() throws IOException {
		List<LabSample> labSampleList = labDetailsService.fetchAllSamples();
		return new Response<List<LabSample>>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), labSampleList);

	}

	@ApiOperation(value = "updateStatus", notes = "updateStatus", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/updateStatus")
	public Response<LabInformation> updateStatus(@Param(value = "labInfoId") int labInfoId,
			@Param(value = "status") String status) {
		LabInformation responseDataList = labDetailsService.updateStatus(labInfoId, status);
		return new Response<LabInformation>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), responseDataList);

	}*/

}