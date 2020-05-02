package com.hpfs.distillery.retailer.controller;

import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.model.TblDepotInventoryM;
import com.hpfs.distillery.retailer.model.TblIndent_D;
import com.hpfs.distillery.retailer.service.RetailersPriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

import javax.annotation.Resource;
import java.util.List;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=100000L) 
@RequestMapping("/api/rtPri")
public class RetailersPriceController {
	
	public static final Logger logger = LoggerFactory.getLogger(RetailersPriceController.class);
	
	@Autowired
	RetailersPriceService retailersPriceService;

	@ApiOperation(value="fetchDepotInvMDts",notes="fetch Retailers Price List dts",response= Response.class)
	@ApiResponses(value={ @ApiResponse (code = 400 , message="INVALID_REQUEST",response=Response.class),
			@ApiResponse(code = 401, message="NOT_AUTHORISED",response=Response.class),
			@ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response=Response.class),
			@ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response=Response.class),
			@ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response=Response.class),
	})
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchRetailersPriceDts")
	public Response<TblDepotInventoryM> getDportInvMDts(@RequestBody Request<TblDepotInventoryM> request){
			PageInfo  pageInfo = getPageInfo(request);
		List<TblDepotInventoryM> responseDataList = retailersPriceService.getDportInvMDts(null!=request ? request.getRequestData(): null, pageInfo);
		return new Response<TblDepotInventoryM> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
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