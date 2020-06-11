package com.hpfs.distillery.retailer.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.hpfs.distillery.retailer.dto.*;
import com.hpfs.distillery.retailer.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hpfs.distillery.retailer.service.IndentForSupplyAndOrderForSupplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 100000L)
@RequestMapping("/api/ifs")
public class IndentForSupplyAndOrderForSupplyController {

	public static final Logger logger = LoggerFactory.getLogger(IndentForSupplyAndOrderForSupplyController.class);

	@Autowired
	IndentForSupplyAndOrderForSupplyService indentForSupplyAndOrderForSupplyService;

	// fetch product name by exact name
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchProdDtsByProdName")
	public Response<List<TblProductsM>> fetchProdDtsByProdName(@RequestBody Request<TblProductsM> request) {
		List<TblProductsM> responseData = indentForSupplyAndOrderForSupplyService.fetchProdDtsByProdName(request);
		return new Response<List<TblProductsM>>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), responseData);

	}
	// end

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/saveIFS")
	public Response<TblIndentForSupply> saveIFS(@RequestBody Request<IndentForSupplyDts> request) {
		TblIndentForSupply responseData = indentForSupplyAndOrderForSupplyService.saveIFS(request.getRequestData());
		return new Response<TblIndentForSupply>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), responseData);

	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/updateIFS")
	public Response<TblIndentForSupply> updateIFS(@RequestBody Request<IndentForSupplyDts> request) {
		TblIndentForSupply responseData = indentForSupplyAndOrderForSupplyService.updateIFS(request.getRequestData());
		return new Response<TblIndentForSupply>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), responseData);

	}	
	@ApiOperation(value = "getAllIFS", notes = "getAllIFS", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getAllIFS")
	public Response<List<TblIndentForSupply>> getAllIFS() throws IOException {
		List<TblIndentForSupply> listIFS = indentForSupplyAndOrderForSupplyService.fetchAllIFS();
		return new Response<List<TblIndentForSupply>>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), listIFS);

	}
	
	@ApiOperation(value = "getAllIFSByDistilleryID", notes = "getAllIFSByDistilleryID", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getAllIFSByDistilleryID")
	public Response<List<TblIndentForSupply>> getAllIFSByDistilleryID(@Param(value = "distillerId") Long distillerId) throws IOException {
		List<TblIndentForSupply> listIFSByDistilleryId = indentForSupplyAndOrderForSupplyService.getTblIndentForSupplyByDistilleryId(distillerId);
		return new Response<List<TblIndentForSupply>>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), listIFSByDistilleryId);

	}
	
	@ApiOperation(value = "fetchSingleIFSByDistilleryId", notes = "fetchSingleIFSByDistilleryId", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchSingleIFSByDistilleryId")
	public Response<TblIndentForSupply> fetchSingleIFSByDistilleryId(@Param(value = "indentNo") String indentNo,@Param(value = "distillerId") Long distillerId) throws IOException {
		TblIndentForSupply oFSByDistilleryId = indentForSupplyAndOrderForSupplyService.getSingleIFSByIndentNoAndDistilleryId(indentNo,distillerId);
		return new Response<TblIndentForSupply>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), oFSByDistilleryId);

	}
	
	
	@ApiOperation(value = "deleteIFSByIndentNo", notes = "deleteIFSByIndentNo", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/deleteIFSByIndentNo")
	public Response<String> deleteIFSByIndentNo(@Param(value = "indentNo") String indentNo) throws IOException {
		Boolean isIfsDeleted = indentForSupplyAndOrderForSupplyService.deleteIFSByIndentNo(indentNo);
		String ifsDeleteMessage = null;
		if(isIfsDeleted) {
			ifsDeleteMessage = "IndentForSupply Record deleted Successfully";
		}
		return new Response<String>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), ifsDeleteMessage);

	}
	
	
	@ApiOperation(value = "fetchSingleOFSByDistilleryId", notes = "fetchSingleOFSByDistilleryId", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchSingleOFSByDistilleryId")
	public Response<TblOrderForSupply> fetchSingleOFSByDistilleryId(@Param(value = "ofsNo") String ofsNo,@Param(value = "distillerId") Long distillerId) throws IOException {
		TblOrderForSupply tblOrderForSupply = indentForSupplyAndOrderForSupplyService.getSingleOFSByIndentNoAndDistilleryId(ofsNo,distillerId);
		return new Response<TblOrderForSupply>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), tblOrderForSupply);

	}
	
	@ApiOperation(value = "getAllOFS", notes = "getAllOFS", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getAllOFS")
	public Response<List<TblOrderForSupply>> getAllOFS() throws IOException {
		List<TblOrderForSupply> listOFS = indentForSupplyAndOrderForSupplyService.fetchAllOFS();
		return new Response<List<TblOrderForSupply>>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), listOFS);

	}
	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/orderForSupply")
	public Response<TblOrderForSupply> orderForSupply(@RequestBody Request<OrderForSupplyDts> request) {
		TblOrderForSupply responseData = indentForSupplyAndOrderForSupplyService.orderForSupply(request.getRequestData());
		return new Response<TblOrderForSupply>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), responseData);

	}
	
	@ApiOperation(value = "getAllOFSByDistilleryID", notes = "getAllOFSByDistilleryID", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getAllOFSByDistilleryID")
	public Response<List<TblOrderForSupply>> getOrderForSupplyRecordsByDistilleryId(@Param(value = "distillerId") Long distillerId) throws IOException {
		List<TblOrderForSupply> listIFSByDistilleryId = indentForSupplyAndOrderForSupplyService.getOrderForSupplyRecordsByDistilleryId(distillerId);
		return new Response<List<TblOrderForSupply>>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), listIFSByDistilleryId);

	}

	
	@ApiOperation(value = "getOfsDetails", notes = "getOfsDetails", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getOfsDetails")
	public Response<List<TblOrderForSupply>> getOfsDetails(@Param(value = "distillerId") Long distillerId,@Param(value= "ofsId") String ofsId,@Param(value = "depotId") Long depotId) throws IOException {
		List<TblOrderForSupply> listIFSByDistilleryId = indentForSupplyAndOrderForSupplyService.getOfsDetails(ofsId,distillerId,depotId);
		return new Response<List<TblOrderForSupply>>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), listIFSByDistilleryId);

	}
	
	@ApiOperation(value = "getIfsDetails", notes = "getIfsDetails", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getIfsDetails")
	public Response<List<TblIndentForSupply>> getIfsDetails(@Param(value = "distillerId") Long distillerId,@Param(value= "indentNo") String indentNo,@Param(value = "depotId") Long depotId) throws IOException {
		List<TblIndentForSupply> listIFSByDistilleryId = indentForSupplyAndOrderForSupplyService.getIfsDetails(indentNo,distillerId,depotId);
		return new Response<List<TblIndentForSupply>>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), listIFSByDistilleryId);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/saveIndentTypes")
	public Response<IFS> saveIndentTypes(@RequestBody Request<IFSDto> request) throws ParseException, SQLException, IOException {
		IFS responseData = indentForSupplyAndOrderForSupplyService.saveIndentTypes(request.getRequestData());
		return new Response<IFS>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), responseData);

	}

	@ApiOperation(value = "fetchAllIFS", notes = "fetchAllIFS", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchAllIFS")
	public Response<List<IFS>> fetchAllIFS() throws IOException {
		List<IFS> labSampleList = indentForSupplyAndOrderForSupplyService.getAllIFS();
		return new Response<List<IFS>>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), labSampleList);

	}

	@ApiOperation(value = "fetchIFSByIFSNO", notes = "fetchIFSByIFSNO", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchIFSByIFSNO")
	public Response<IFS> getIFSByIFSNO(@Param(value= "ifsNo") String ifsNo) throws IOException {
		IFS ifs = indentForSupplyAndOrderForSupplyService.getIFSByIFSNo(ifsNo);
		return new Response<IFS>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), ifs);

	}

	@ApiOperation(value = "deleteIFS", notes = "deleteIFS", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/deleteIFS")
	public Response<String> deleteIFS(@Param(value = "ifsNo") String ifsNo) throws IOException {
		Boolean isIfsDeleted = indentForSupplyAndOrderForSupplyService.deleteIFSByIndentNo(ifsNo);
		String ifsDeleteMessage = null;
		if(isIfsDeleted) {
			ifsDeleteMessage = "IFS Record deleted Successfully";
		}
		return new Response<String>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), ifsDeleteMessage);

	}

	@ApiOperation(value = "fetchPrdctByIfsPid", notes = "fetchPrdctByIfsPid", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchPrdctByIfsPid")
	public Response<IFSProductsDto> getIfsPrdctByPid(@Param(value= "ifsPid") Integer ifsPid) throws IOException {
		IFSProductsDto product = indentForSupplyAndOrderForSupplyService.getPrdctByIfsPid(ifsPid);
		if(product==null) {
			return new Response<IFSProductsDto>(
					new ResponseHeader(ResponseHeader.Status.FAILURE, ResponseHeader.ResultSetType.SINGLE), product);
		}
		return new Response<IFSProductsDto>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), product);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/updateIFSProduct")
	public Response<String> updateIFSProduct(@RequestBody IFSProductsDto request) throws ParseException {
		String updatedProduct = indentForSupplyAndOrderForSupplyService.updateIFSProduct(request);
		return new Response<String>(
				new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), updatedProduct);

	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/deleteIFSPrdct")
	public ResponseEntity<String> deleteIfsProduct(@Param(value= "ifsPid") Integer ifsPid) {
	String deleted= indentForSupplyAndOrderForSupplyService.deleteIfsProduct(ifsPid);
		if (deleted.equalsIgnoreCase("SUCCESS")) {
			deleted="IFS Product deleted Successfully";
			return new ResponseEntity<>(deleted,HttpStatus.OK);
		} else {
			deleted="IFS Product not deleted";
			return new ResponseEntity<>(deleted,HttpStatus.NOT_FOUND);
		}
	}
	private PageInfo getPageInfo(@RequestBody(required = false) Request request) {
		PageInfo pageInfo = new PageInfo();
		if (request != null && request.getPageInfo() != null) {
			pageInfo = (PageInfo) request.getPageInfo();
		}
		return pageInfo;
	}

}