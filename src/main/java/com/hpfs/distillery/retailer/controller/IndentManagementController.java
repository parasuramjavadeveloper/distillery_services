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

import com.hpfs.distillery.retailer.dto.IndentCreationDto;
import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.dto.TblDistilleryInvMDto;
import com.hpfs.distillery.retailer.model.TblUsers;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.model.CreateIndentMgtDts;
import com.hpfs.distillery.retailer.model.GridIndentMgtDts;
import com.hpfs.distillery.retailer.model.TblDepot_M;
import com.hpfs.distillery.retailer.model.TblDistilleries;
import com.hpfs.distillery.retailer.model.TblIndent_D;
import com.hpfs.distillery.retailer.model.TblIndent_M;
import com.hpfs.distillery.retailer.model.TblProductsM;
import com.hpfs.distillery.retailer.model.TblRetailers_M;
import com.hpfs.distillery.retailer.service.IndentMgmService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=100000L) 
@RequestMapping("/api/imgt")
public class IndentManagementController {
	
	//public static final Logger logger = LoggerFactory.getLogger(IndentManagementController.class);
	
	@Autowired
	IndentMgmService indentMgmService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fethDistilleryInvMgmDts")
	public Response<TblDistilleryInvMDto> getDistelleryInvMgmDts(@RequestBody Request<TblDistilleryInvMDto> request){
		PageInfo  pageInfo = getPageInfo(request);
		List<TblDistilleryInvMDto> responseDataList = indentMgmService.getDistelleryInvMgmDts(null!=request ? request.getRequestData(): null, pageInfo);
		return new Response<TblDistilleryInvMDto> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				pageInfo,responseDataList);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchIndentMgmDts")
	public Response<GridIndentMgtDts> getIndentMgmDts(@RequestBody Request<GridIndentMgtDts> request){
		PageInfo  pageInfo = getPageInfo(request);
		List<GridIndentMgtDts> responseDataList = indentMgmService.getIndentMgmDts(null!=request ? request.getRequestData(): null, pageInfo);
		return new Response<GridIndentMgtDts> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				pageInfo,responseDataList);

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/lastThirtyDays")
	public Response<List<GridIndentMgtDts>> getLastThiryDaysIndentMgmDts(){
		List<GridIndentMgtDts> responseDataList = indentMgmService.getLastThiryDaysIndentMgmDts();
		return new Response<List<GridIndentMgtDts>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/dateWiseStmts")
	public Response<List<GridIndentMgtDts>> getDateWiseStmts(@Param(value = "startDate") String startDate,@Param(value="endDate") String endDate ){
		List<GridIndentMgtDts> responseDataList = indentMgmService.fetchDateWiseStmts(startDate,endDate);
		return new Response<List<GridIndentMgtDts>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/oldArchives")
	public Response<List<GridIndentMgtDts>> fetchOldArchives(){
		List<GridIndentMgtDts> responseDataList = indentMgmService.fetchOldArchives();
		return new Response<List<GridIndentMgtDts>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/indentAutoPopulDts")
	public Response<CreateIndentMgtDts> createIndentAutoPopulDts(@RequestBody Request<TblUsers> request){
		PageInfo  pageInfo = getPageInfo(request);
		CreateIndentMgtDts responseData = indentMgmService.fetchIndentDtsByUserId(request.getRequestData().getUserId());
		return new Response<CreateIndentMgtDts> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				responseData);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fethInvMgmDts")
	public Response<TblIndent_D> getInvMgmDts(@RequestBody Request<TblIndent_D> request){
		PageInfo  pageInfo = getPageInfo(request);
		List<TblIndent_D> responseDataList = indentMgmService.getInvMgmDts(null!=request ? request.getRequestData(): null, pageInfo);
		return new Response<TblIndent_D> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				pageInfo,responseDataList);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/saveIndentDts")
	public Response <TblIndent_M> saveIndentDts(@RequestBody Request<IndentCreationDto> request){
		UserDetails userDetails = new UserDetails();
		TblIndent_M tblIndentMDts = indentMgmService.saveIndentDts(null!=request ? request.getRequestData(): null,userDetails);
		return new Response<TblIndent_M> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				tblIndentMDts);

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchDepotDts")
	public Response<TblDepot_M> getDepotDetails(){
		List<TblDepot_M> responseDataList = indentMgmService.getDepotDts();
		return new Response<TblDepot_M> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchDistilleries")
	public Response<TblDistilleries> getDistilleries(){
		List<TblDistilleries> responseDataList = indentMgmService.getDistilleries();
		return new Response<TblDistilleries> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchRetailersMDts")
	public Response<TblRetailers_M> getRetailersMDts(){
		List<TblRetailers_M> responseDataList = indentMgmService.getRetailersMDts();
		return new Response<TblRetailers_M> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}
	
	// CSV reading file details and saving into the disto_inv_m table
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/insertDistFlatFileDts")
	public Response<String> insertDistFlatFileDts(){
		String msg = indentMgmService.insertDistFlatFileDts();
		return new Response<String> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				msg);

	}

	
	// Fetching depot names like search - elastic search
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/showDepotNames")
	public Response<TblDepot_M> showDepotNames(@RequestBody Request<TblDepot_M> request){
		List<TblDepot_M> responseDataList = indentMgmService.showDepotName(request);
		return new Response<TblDepot_M> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}
	
	//fetch depot name by exact name
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchDptDtsByDepotName")
	public Response<TblDepot_M> fetchDptDtsByDepotName(@RequestBody Request<TblDepot_M> request){
		TblDepot_M responseData = indentMgmService.fetchDptDtsByDepotName(request);
		return new Response<TblDepot_M> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.SINGLE),
				responseData);

	}
	//end
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchProductDts")
	public Response<List<TblProductsM>> fetchProductDts(){
		List<TblProductsM> responseData = indentMgmService.fetchProductDts();
		return new Response<List<TblProductsM>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseData);

	}

	private PageInfo getPageInfo(@RequestBody(required=false) Request request){
		PageInfo pageInfo = new PageInfo();
		if(request!=null && request.getPageInfo()!=null){
			pageInfo = (PageInfo) request.getPageInfo();
		}
		return pageInfo;
	}
	
}