package com.hpfs.distillery.retailer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hpfs.distillery.retailer.dto.GridStockDtsDto;
import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.dto.TblDistilleryInvMDto;
import com.hpfs.distillery.retailer.model.TblBarcodeM;
import com.hpfs.distillery.retailer.model.TblBrandsM;
import com.hpfs.distillery.retailer.model.TblDistiInvM;
import com.hpfs.distillery.retailer.model.TblVehicleM;
import com.hpfs.distillery.retailer.service.BlendStockService;
import com.hpfs.distillery.retailer.service.DistilleryService;
import com.hpfs.distillery.retailer.service.ExternalService;
import com.hpfs.distillery.retailer.service.RetailersStockService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=100000L) 
@RequestMapping("/api/ext")
public class ExternalAPIsController {
	
	public static final Logger logger = LoggerFactory.getLogger(ExternalAPIsController.class);
	
	@Autowired
	ExternalService exernalService;

	@ApiOperation(value="xml read data",notes="xml read data",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/xmlBarCodeRead")
	public Response<String> xmlBarCodeRead(){
		String msg = exernalService.xmlBarCodeRead();
		return new Response<String> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				msg);
	}
	
	
	@ApiOperation(value="scanCaseBarNo",notes="fetch fetchActscanCaseBarNo dts",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/scanBarcode")
	public Response<TblBarcodeM> scanBarcode(@RequestBody Request<TblBarcodeM> request){
		TblBarcodeM responseData = exernalService.scanBarcode(null!=request ? request.getRequestData(): null);
		return new Response<TblBarcodeM> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				responseData);

	}

	private PageInfo getPageInfo(@RequestBody(required=false) Request request){
		PageInfo pageInfo = new PageInfo();
		if(request!=null && request.getPageInfo()!=null){
			pageInfo = (PageInfo) request.getPageInfo();
		}
		return pageInfo;
	}
	
}