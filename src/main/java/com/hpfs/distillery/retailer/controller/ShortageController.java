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

import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.dto.ShortageDetailsDto;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.model.TblBreakageDetails;
import com.hpfs.distillery.retailer.model.TblShortageDetails;
import com.hpfs.distillery.retailer.service.ShortageDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=100000L) 
@RequestMapping("/api/shortage")
public class ShortageController {

    @Autowired
    ShortageDetailsService shortageDetailsService;

    @ApiOperation(value = "getshortageDetails", notes = "getshortageDetails", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchshortageDts")
    public Response<List<TblShortageDetails>> fetchshortageInfoDts(){
        List<TblShortageDetails> responseData = shortageDetailsService.fetchShortageInfoData();
        return new Response<List<TblShortageDetails>>(new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST),
                responseData);

    }

    @ApiOperation(value = "createShortageDetails", notes = "createShortageDetails", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path="/saveShortageDts")
    public Response<TblShortageDetails> saveShortageDts(@RequestBody Request<ShortageDetailsDto> request,UserDetails userDetails){
   
    	TblShortageDetails breakageDetails=shortageDetailsService.saveShortageDts(null!=request ? request.getRequestData(): null,userDetails);
        return new Response<TblShortageDetails>(new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE),
        		breakageDetails);
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/dateWiseStmts")
  	public Response<List<TblShortageDetails>> getDateWiseStmts(@Param(value = "startDate") String startDate,@Param(value="endDate") String endDate ){
  		List<TblShortageDetails> responseDataList = shortageDetailsService.fetchDateWiseStmts(startDate,endDate);
  		return new Response<List<TblShortageDetails>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
  				responseDataList);

  	}
    
    
}
