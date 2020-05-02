package com.hpfs.distillery.retailer.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hpfs.distillery.retailer.dto.GRNTransactionDto;
import com.hpfs.distillery.retailer.dto.ProcessFeeDto;
import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.model.TblSupplierM;
import com.hpfs.distillery.retailer.model.TblSupplierTransaction;
import com.hpfs.distillery.retailer.service.SupplierService;
import com.hpfs.distillery.retailer.service.SupplierTransactionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Durga Prasad Gummadi
 *
 */

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 100000L)
@RequestMapping("/api/supplier")
public class SuppliersController {

	@Autowired
	SupplierTransactionService supplierTransactionService;

	@Autowired
	SupplierService supplierService;

	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class) })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getSupplierDetails")
	public Response<TblSupplierM> getSupplierDetails(@RequestParam(value = "type", required = false) String type)
			throws ParseException {
		// System.out.println("SuuplierDetails...");
		List<TblSupplierM> tblSupplierM = supplierService.getSupplierByType(type);
		return new Response<TblSupplierM>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), tblSupplierM);

	}

	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class) })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getAllTransactions")
	public Response<TblSupplierTransaction> getAllTxns(
			@RequestParam(value = "fromDate", required = false) String fromDate,
			@RequestParam(value = "toDate", required = false) String toDate,
			@RequestParam(value = "suppliername", required = false) String suppliername,
			@RequestParam(value = "processDate", required = false) String processDate) throws ParseException {
		// System.out.println("SupplierTransactions...");
		// userDetails.setSid("E12345");
		Pageable pageRequest = createPageRequest();
		List<TblSupplierTransaction> tblSupplierM = supplierTransactionService.getAllTxns(fromDate, toDate, processDate,
				suppliername, pageRequest);
		return new Response<TblSupplierTransaction>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), tblSupplierM);

	}

	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class) })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getRollbackTransactions")
	public Response<TblSupplierTransaction> getRollbackTxns(
			@RequestParam(value = "suppliername", required = false) String suppliername,
			@RequestParam(value = "processDate", required = false) String processDate) throws ParseException {
		// System.out.println("SupplierTransactions...");
		// userDetails.setSid("E12345");
		Pageable pageRequest = createPageRequest();
		List<TblSupplierTransaction> tblSupplierM = supplierTransactionService.getRollbackTxns(processDate,
				suppliername, pageRequest);
		return new Response<TblSupplierTransaction>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), tblSupplierM);

	}
	
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class) })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getGRNProcessFeeDetails")
	public Response<GRNTransactionDto> getGRNProcessFeeDetails(
			@RequestParam(value = "fromDate", required = false) String fromDate,
			@RequestParam(value = "toDate", required = false) String toDate,
			@RequestParam(value = "suppliername", required = false) String suppliername) throws ParseException {
		Pageable pageRequest = createPageRequest();
		List<GRNTransactionDto> tblSupplierM = supplierTransactionService.getGRNTxns(fromDate,toDate,	suppliername, pageRequest);
		return new Response<GRNTransactionDto>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), tblSupplierM);

	}
	
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class) })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getMISPaymentDetails")
	public Response<TblSupplierTransaction> getMISPaymentDetails(
			@RequestParam(value = "fromDate", required = false) String fromDate,
			@RequestParam(value = "toDate", required = false) String toDate,
			@RequestParam(value = "suppliername", required = false) String suppliername,
			@RequestParam(value = "processstatus", required = false) String processstatus) throws ParseException {
		Pageable pageRequest = createPageRequest();
		List<TblSupplierTransaction> tblSupplierM = supplierTransactionService.getMISPaymentTxns(fromDate,toDate, suppliername, processstatus, pageRequest);
		return new Response<TblSupplierTransaction>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), tblSupplierM);

	}
	
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class) })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getGRNPaymentDetails")
	public Response<TblSupplierTransaction> getGRNPaymentDetails(
			@RequestParam(value = "fromDate", required = false) String fromDate,
			@RequestParam(value = "toDate", required = false) String toDate,
			@RequestParam(value = "suppliername", required = false) String suppliername) throws ParseException {
		Pageable pageRequest = createPageRequest();
		List<TblSupplierTransaction> tblSupplierM = supplierTransactionService.getGRNPaymentTxns(fromDate,toDate, suppliername, pageRequest);
		return new Response<TblSupplierTransaction>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), tblSupplierM);

	}
	
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class) })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getProcessFeeDetails")
	public Response<ProcessFeeDto> getProcessFeeDetails(
			@RequestParam(value = "fromDate", required = false) String fromDate,
			@RequestParam(value = "toDate", required = false) String toDate) throws ParseException {
		Pageable pageRequest = createPageRequest();
		List<ProcessFeeDto> tblSupplierM = supplierTransactionService.getProcessFeeTxns(fromDate,toDate, pageRequest);
		return new Response<ProcessFeeDto>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), tblSupplierM);

	}

	private Pageable createPageRequest() {
		return new PageRequest(0, 10);
	}

}
