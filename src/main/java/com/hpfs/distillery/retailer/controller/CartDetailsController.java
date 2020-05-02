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

import com.hpfs.distillery.retailer.dto.CartDetailsDto;
import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.dto.VehicleRouteDto;
import com.hpfs.distillery.retailer.model.GridIndentMgtDts;
import com.hpfs.distillery.retailer.model.TblBrandsM;
import com.hpfs.distillery.retailer.model.TblCartDetails;
import com.hpfs.distillery.retailer.model.TblIndent_M;
import com.hpfs.distillery.retailer.model.TblPurchaseOrders;
import com.hpfs.distillery.retailer.model.TblRetailerPaymentDetails;
import com.hpfs.distillery.retailer.model.TblWallet;
import com.hpfs.distillery.retailer.model.VehicleRoute;
import com.hpfs.distillery.retailer.service.CartDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * @author Vamsi Alla
 *
 */
@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=100000L) 
@RequestMapping("/api/cart")
public class CartDetailsController {
	
	public static final Logger logger = LoggerFactory.getLogger(CartDetailsController.class);
	
	@Autowired
	CartDetailsService cartDetailsService;

	@ApiOperation(value="CartDetailsfor selected Item",notes="fetchAllCartDetails for Selected Item",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchAllCartDetails")
	public Response<List<TblRetailerPaymentDetails>> fetchCartDetails(){
		List<TblRetailerPaymentDetails> responseDataList = cartDetailsService.fetchCartDetails();
		return new Response<List<TblRetailerPaymentDetails>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}


	@ApiOperation(value="createCartDetails",notes="createCartDetails",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/cartInsert")
	public Response<TblCartDetails> cartDetailsInsert(@RequestBody Request<CartDetailsDto> request){
		
		UserDetails userDetails = new UserDetails();
		TblCartDetails msg = cartDetailsService.saveCartDts(null!=request ? request.getRequestData(): null,userDetails);
		return new Response<TblCartDetails> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				msg);
	}
	

	private PageInfo getPageInfo(@RequestBody(required=false) Request request){
		PageInfo pageInfo = new PageInfo();
		if(request!=null && request.getPageInfo()!=null){
			pageInfo = (PageInfo) request.getPageInfo();
		}
		return pageInfo;
	}
	
}