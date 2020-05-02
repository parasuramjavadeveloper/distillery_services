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
import com.hpfs.distillery.retailer.dto.WalletAmountupdDto;
import com.hpfs.distillery.retailer.dto.WalletDetailsDto;
import com.hpfs.distillery.retailer.model.TblRetailers_M;
import com.hpfs.distillery.retailer.model.TblWallet;
import com.hpfs.distillery.retailer.service.WalletService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=100000L) 
@RequestMapping("/api/wallet")
public class WalletController {
	
	public static final Logger logger = LoggerFactory.getLogger(WalletController.class);
	
	@Autowired
	WalletService walletService;
	
	@ApiOperation(value="xml read data",notes="csv read data",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/walletCSVData")
	public Response<String> walletCsvDataRead(){
		String msg = walletService.walletCsvDataRead();
		return new Response<String> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				msg);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/walletInsert")
	public Response<String> walletInsert(@RequestBody Request<TblWallet> request){
		String msg = walletService.walletInsert(null!=request ? request.getRequestData(): null);
		return new Response<String> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				msg);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/savewalletDts")
	public Response<String> savewalletDts(@RequestBody Request<TblWallet> request){
		String msg = walletService.saveWalletDts(null!=request ? request.getRequestData(): null);
		return new Response<String> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				msg);
	}
	
	@ApiOperation(value="getWalletDetailsForRetailer",notes="get wallet details and Last Ten Transactions For Retailer",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getWalletDetailsForRetailer")
	public  Response<WalletDetailsDto> getLastTenTransactionsForRetailer(@Param(value = "userId") Long userId){
		WalletDetailsDto responseData = walletService.getWalletData(userId);
		return new Response<WalletDetailsDto> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseData);
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchRetailersMDtsByDepot")
	public Response<TblRetailers_M> getRetailersMDtsByDepot(@Param(value = "depotId") Long depotId){
		List<TblRetailers_M> responseDataList = walletService.getRetailersMDtsByDepot(depotId);
		return new Response<TblRetailers_M> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}
	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/updateAmountToWallet")
	public Response<TblWallet> addAmountToWallet(@RequestBody Request<WalletAmountupdDto> request){
		TblWallet tblWallet = walletService.addAmountToWallet(null!=request ? request.getRequestData(): null);
		return new Response<TblWallet> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				tblWallet);
	}
	
	/*@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/lastThirtyDays")
	public Response<List<GridIndentMgtDts>> getLastThiryDaysIndentMgmDts(){
		List<GridIndentMgtDts> responseDataList = indentMgmService.getLastThiryDaysIndentMgmDts();
		return new Response<List<GridIndentMgtDts>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);
*/
	//}
	
}