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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hpfs.distillery.retailer.dto.ApproveDtsDto;
import com.hpfs.distillery.retailer.dto.GridStockDtsDto;
import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.ReceiptsDts;
import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.dto.TblDistilleryInvMDto;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.dto.UserRolesDto;
import com.hpfs.distillery.retailer.model.GridIndentMgtDts;
import com.hpfs.distillery.retailer.model.TblBreakageDetails;
import com.hpfs.distillery.retailer.model.TblDistiInvM;
import com.hpfs.distillery.retailer.model.TblPurchaseOrders;
import com.hpfs.distillery.retailer.model.TblReceipts;
import com.hpfs.distillery.retailer.model.TblSpiritTypes;
import com.hpfs.distillery.retailer.model.TblSupplierM;
import com.hpfs.distillery.retailer.model.TblVehicleM;
import com.hpfs.distillery.retailer.service.DistilleryService;
import com.hpfs.distillery.retailer.service.RetailersStockService;
import com.hpfs.distillery.retailer.service.SpiritService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=100000L) 
@RequestMapping("/api/spirit")
public class SpiritController {
	
	public static final Logger logger = LoggerFactory.getLogger(SpiritController.class);
	
	@Autowired
	SpiritService spiritService;

	@ApiOperation(value="fetchActiveReqTypes",notes="fetch fetchActiveReqTypes dts",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchActiveReqTypes")
	public Response<List<TblSpiritTypes>> fetchActiveReqTypes(){
		List<TblSpiritTypes> responseDataList = spiritService.fetchActiveReqTypes();
		return new Response<List<TblSpiritTypes>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}
	
	@ApiOperation(value="fetchActSuppliers",notes="fetch fetchActSuppliers dts",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchActSuppliers")
	public Response<List<TblSupplierM>> fetchActSuppliers(){
		List<TblSupplierM> responseDataList = spiritService.fetchActSuppliers();
		return new Response<List<TblSupplierM>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}
	
	@ApiOperation(value="saveOrUpdateProcReq",notes="saveOrUpdateProcReq",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/saveOrUpdateProcReq")
	public Response<String> saveOrUpdateProcReq(@RequestBody Request<TblPurchaseOrders> request){
		String msg = spiritService.saveOrUpdateProcReq(request.getRequestData());
		return new Response<String> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				msg);

	}
	
	@ApiOperation(value="dateWise ProcurementStmts",notes="dateWise ProcurementStmts",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/dtWiseProcurStms")
	public Response<List<TblPurchaseOrders>> fetchDtWiseProcurementDts(@RequestBody Request<TblPurchaseOrders> request){
		PageInfo pf = getPageInfo(request);
		List<TblPurchaseOrders> responseDataList = spiritService.fetchDtWiseProcurementDts(null!=request ? request.getRequestData():null,pf);
		return new Response<List<TblPurchaseOrders>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}
	
	@ApiOperation(value="Approve Status",notes="Approve Status",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/approveStatusByReqIds")
	public Response<String> approveStatusByReqIds(@RequestBody Request<ApproveDtsDto> request){
		String msg = spiritService.approveStatusByReqIds(null!=request ? request.getRequestData():null);
		return new Response<String> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				msg);

	}
	
	@ApiOperation(value="saveOrUpdateReceiptDts",notes="saveOrUpdateReceiptDts",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/saveOrUpdateReceiptDts")
	public Response<String> saveOrUpdateReceiptDts(@RequestBody Request<ReceiptsDts> request){
		String msg = spiritService.saveOrUpdateReceiptDts(request.getRequestData());
		return new Response<String> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				msg);

	}
	
	@ApiOperation(value="fetchInvoiceDtsByReceptId",notes="fetchInvoiceDtsByReceptId",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchInvoiceDtsByReceptId")
	public Response<TblReceipts> fetchInvoiceDtsByReceptId(@RequestBody Request<TblReceipts> request){
		TblReceipts tblReceipts = spiritService.fetchInvoiceDtsByReceptId(request.getRequestData());
		return new Response<TblReceipts> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				tblReceipts);

	}
	
	@ApiOperation(value="saveInvoiceReceiptDts",notes="saveInvoiceReceiptDts",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/saveInvoiceReceiptDts")
	public Response<String> saveInvoiceReceiptDts(@RequestBody Request<TblReceipts> request){
		String msg = spiritService.saveInvoiceReceiptDts(request.getRequestData());
		return new Response<String> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				msg);

	}
	
	private PageInfo getPageInfo(@RequestBody(required=false) Request request){
		PageInfo pageInfo = new PageInfo();
		if(request!=null && request.getPageInfo()!=null){
			pageInfo = (PageInfo) request.getPageInfo();
		}
		return pageInfo;
	}
	

@ApiOperation(value="fetchAllReceipts",notes="fetchAllReceipts",response= Response.class)
@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
		@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
		@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
		@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
		@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
})
@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchAllReceipts")
public Response<List<TblReceipts>> fetchAllReceipts(){
	List<TblReceipts> responseDataList = spiritService.fetchAllReceipts();
	return new Response<List<TblReceipts>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
			responseDataList);

}
@ApiOperation(value = "dateWiseReceiptStmts", notes = "dateWiseReceiptStmts", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
			@ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
			@ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
			@ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
			@ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class), })
@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/dateWiseReceiptStmts")
public Response<List<TblReceipts>> getDateWiseStmts(@Param(value = "startDate") String startDate,@Param(value="endDate") String endDate ){
	List<TblReceipts> responseDataList = spiritService.fetchdateWiseReceiptStmts(startDate,endDate);
	return new Response<List<TblReceipts>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
			responseDataList);

}
}
