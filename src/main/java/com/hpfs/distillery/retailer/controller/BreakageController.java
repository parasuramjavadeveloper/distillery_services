package com.hpfs.distillery.retailer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hpfs.distillery.retailer.dto.BreakageDetailsDto;
import com.hpfs.distillery.retailer.dto.IndentCreationDto;
import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.model.ProductionLineDetails;
import com.hpfs.distillery.retailer.model.TblBreakageDetails;
import com.hpfs.distillery.retailer.model.TblIndent_M;
import com.hpfs.distillery.retailer.service.BreakageDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=100000L) 
@RequestMapping("/api/breakage")
public class BreakageController {

    @Autowired
    BreakageDetailsService breakageDetailsService;

    @ApiOperation(value = "getBreakageDetails", notes = "getBreakageDetails", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchbreakageDts")
    public Response<List<TblBreakageDetails>> fetchBreakageInfoDts(){
        List<TblBreakageDetails> responseData = breakageDetailsService.fetchBreakageInfoData();
        return new Response<List<TblBreakageDetails>>(new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST),
                responseData);

    }

    @ApiOperation(value = "createBreakageDetails", notes = "createBreakageDetails", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path="/saveBreakageDts")
    public Response<TblBreakageDetails> saveBreakageDts(@RequestBody Request<BreakageDetailsDto> request,UserDetails userDetails){
   
    	TblBreakageDetails breakageDetails=breakageDetailsService.saveBreakageDts(null!=request ? request.getRequestData(): null,userDetails);
        return new Response<TblBreakageDetails>(new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE),
        		breakageDetails);
    }
    @ApiOperation(value = "dateWiseStmts", notes = "dateWiseStmts", response = Response.class)
   	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
   			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
   			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
   			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
   			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/dateWiseStmts")
	public Response<List<TblBreakageDetails>> getDateWiseStmts(@Param(value = "startDate") String startDate,@Param(value="endDate") String endDate ){
		List<TblBreakageDetails> responseDataList = breakageDetailsService.fetchDateWiseStmts(startDate,endDate);
		return new Response<List<TblBreakageDetails>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}
	
    @ApiOperation(value = "fetchProductTypeList", notes = "fetchProductTypeList", response = Response.class)
   	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
   			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
   			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
   			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
   			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchProductTypeList")
  	public Response<List<String>> fetchProductTypeList(){
  		List<String> responseData = breakageDetailsService.fetchProductTypeList();
  		return new Response<List<String>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
  				responseData);

  	}

    
}
