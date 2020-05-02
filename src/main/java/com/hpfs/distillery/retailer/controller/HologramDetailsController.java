package com.hpfs.distillery.retailer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hpfs.distillery.retailer.dto.HologramDetailsDto;
import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.model.GridIndentMgtDts;
import com.hpfs.distillery.retailer.model.TblHologramDetails;
import com.hpfs.distillery.retailer.service.HologramDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 100000L)
@RequestMapping("/api/hologram")
public class HologramDetailsController {
	
	public static final Logger logger = LoggerFactory.getLogger(HologramDetailsController.class);

	@Autowired
	HologramDetailsService hologramDetailsService;

	// Save HologramHealDailyIndent details into DB
	
	@ApiOperation(value = "createHologramHealDailyIndent", notes = "createHologramHealDailyIndent", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/saveIndentDts")
	public Response<TblHologramDetails> saveHealDailyIndentDetails(@RequestBody Request<HologramDetailsDto> request) {
		UserDetails userDetails = new UserDetails();
		// userDetails.setSid("E12345");
		TblHologramDetails tblHologramMDts = hologramDetailsService
				.saveHealDailyIndentDetails(null != request ? request.getRequestData() : null, userDetails);
		return new Response<TblHologramDetails>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE),
				tblHologramMDts);
	}
	
	// Save HealPurchaseIndent details into DB
	@ApiOperation(value = "createHealPurchaseIndent", notes = "createHealPurchaseIndent", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/saveHealPurchaseIndDts")
	public Response<TblHologramDetails> saveHealPurchaseIndentDetails(@RequestBody Request<HologramDetailsDto> request) {
		UserDetails userDetails = new UserDetails();
		// userDetails.setSid("E12345");
		TblHologramDetails tblHologramMDts = hologramDetailsService
				.saveHealPurchaseIndentDetails(null != request ? request.getRequestData() : null, userDetails);
		return new Response<TblHologramDetails>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE),
				tblHologramMDts);
	}
	
	//fetch Purpose Details in the Create HealPurchaseIndent Screen
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchPurposeDts")
	public Response<List<String>> fetchHealPurchaseIndentPurposeList(){
		List<String> responseData = hologramDetailsService.fetchHealPurchaseIndentPurposeList();
		return new Response<List<String>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseData);

	}
	
	
	//To Search Details in the HealDailyIndent API Screen With Pagination Mechanism
	
	@ApiOperation(value="fetchHealDailyIndentDts",notes="fetchHealDailyIndentDts List dts",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchHealDailyIndentDts")
	public Response<HologramDetailsDto> getHealDailyIndentDts(@RequestBody Request<HologramDetailsDto> request){
			PageInfo  pageInfo = getPageInfo(request);
		List<HologramDetailsDto> responseDataList = hologramDetailsService.getHealDailyIndentDtsas
				(null!=request ? request.getRequestData(): null, pageInfo);
		return new Response<HologramDetailsDto> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}


	//To Search Details in the HealDailyIndent API Screen WithOut Pagination Mechanism
	@ApiOperation(value = "fetchHologramHealDailyIndentsDetails", notes = "fetchHologramHealDailyIndentsDetails", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchHologramHealDailyIndentsDts")
	public Response<TblHologramDetails> getHologramHealDailyIndentsDetails(){
		
		List<TblHologramDetails> responseDataList = hologramDetailsService.fetchHealDailyIndentDetails();
		return new Response<TblHologramDetails> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}
	
	//To Search Details in the HealDailyIndent API Details Based on the IdentNum
	
	@ApiOperation(value = "fetchHologramHealDailyIndentsByIdentNo", notes = "fetchHologramHealDailyIndentsByIdentNo", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchHologramHealDailyIndentsByIdentNo/{indentNum}")
	public Response<TblHologramDetails> getHologramHealDailyIndentsByIdentNo(@PathVariable("indentNum") Long indentNo) {
		List<TblHologramDetails> responseDataList = hologramDetailsService.fetchHealDailyIndentDetailsByIndentNo(indentNo);
		return new Response<TblHologramDetails>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), responseDataList);

	}
	
	
//To Search the Date Wise Statements in the HealDailyIndent API and Purchase Indent Screens
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/hologramDateWiseStmts")
	public Response<List<TblHologramDetails>> getDateWiseStmts(@Param(value = "startDate") String startDate,@Param(value="endDate") String endDate ){
		List<TblHologramDetails> responseDataList = hologramDetailsService.fetchDateWiseStmts(startDate,endDate);
		return new Response<List<TblHologramDetails>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}

	private PageInfo getPageInfo(@RequestBody(required = false) Request request) {
		PageInfo pageInfo = new PageInfo();
		if (request != null && request.getPageInfo() != null) {
			pageInfo = (PageInfo) request.getPageInfo();
		}
		return pageInfo;
	}

}
