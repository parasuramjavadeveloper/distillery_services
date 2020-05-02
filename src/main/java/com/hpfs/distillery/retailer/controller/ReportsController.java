package com.hpfs.distillery.retailer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.model.TblShortageDetails;
import com.hpfs.distillery.retailer.service.ShortageDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=100000L) 
@RequestMapping("/api/report")
public class ReportsController {

    @Autowired
    ShortageDetailsService shortageDetailsService;

    @ApiOperation(value = "getdistellryStockDetails", notes = "getdistellryStockDetails", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchshortageDts")
    public Response<List<TblShortageDetails>> fetchdistellryStockInfoDts(){
        List<TblShortageDetails> responseData = shortageDetailsService.fetchShortageInfoData();
        return new Response<List<TblShortageDetails>>(new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST),
                responseData);
    }
    }