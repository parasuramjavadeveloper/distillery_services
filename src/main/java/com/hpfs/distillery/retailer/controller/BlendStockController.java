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
import com.hpfs.distillery.retailer.model.TblBrandsM;
import com.hpfs.distillery.retailer.model.TblDistiInvM;
import com.hpfs.distillery.retailer.model.TblVehicleM;
import com.hpfs.distillery.retailer.service.BlendStockService;
import com.hpfs.distillery.retailer.service.DistilleryService;
import com.hpfs.distillery.retailer.service.RetailersStockService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=100000L) 
@RequestMapping("/api/blendStock")
public class BlendStockController {
	
	public static final Logger logger = LoggerFactory.getLogger(BlendStockController.class);
	
	@Autowired
	BlendStockService blendStockService;

	@ApiOperation(value="fetchBrandsFor Stock Categories",notes="fetchBrandsFor Stock Categories",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchAllBrandCatgs")
	public Response<List<TblBrandsM>> fetchAllBrandCatgs(){
		List<TblBrandsM> responseDataList = blendStockService.fetchAllBrandCatgs();
		return new Response<List<TblBrandsM>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}
	
	

	private PageInfo getPageInfo(@RequestBody(required=false) Request request){
		PageInfo pageInfo = new PageInfo();
		if(request!=null && request.getPageInfo()!=null){
			pageInfo = (PageInfo) request.getPageInfo();
		}
		return pageInfo;
	}
	
}