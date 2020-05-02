package com.hpfs.distillery.retailer.controller;

import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.model.TblBreakageDetails;
import com.hpfs.distillery.retailer.model.TblExciseDuty;
import com.hpfs.distillery.retailer.service.ExciseDutyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=100000L)
@RequestMapping("/api/excise")
public class ExciseDutyController {

    @Autowired
    private ExciseDutyService exciseDutyService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchExciseData")
    public Response<List<TblExciseDuty>> fetchExciseData(@RequestParam(required = false) String challantype){
        System.out.println(challantype);
        List<TblExciseDuty> responseData = exciseDutyService.fetchExciseData(challantype);
        return new Response<List<TblExciseDuty>>(new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST),
                responseData);

    }

    @ApiOperation(value="saveExciseData",notes="saveExciseData",response= Response.class)
    @ApiResponses(value={ @ApiResponse(code = 400 , message="INVALID_REQUEST",response= Response.class),
            @ApiResponse(code = 401, message="NOT_AUTHORISED",response= Response.class),
            @ApiResponse(code = 404, message="REQUEST_NOT_FOUND",response= Response.class),
            @ApiResponse(code = 500, message="INTERNAL_SERVER_ERROR",response= Response.class),
            @ApiResponse(code = 503, message="SERVER_NOT_AVAILABLE",response= Response.class),
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/saveExciseData")
    public Response<String> saveExciseData(@RequestBody TblExciseDuty request){
        String msg = exciseDutyService.saveExciseData(request);
        return new Response<String>(new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE),
                msg);


    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchChallanTypeList")
	public Response<List<String>> fetchChallanTypeList(){
		List<String> responseData = exciseDutyService.fetchChallanTypeList();
		return new Response<List<String>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseData);

	}

    private PageInfo getPageInfo(@RequestBody(required=false) Request request){
        PageInfo pageInfo = new PageInfo();
        if(request!=null && request.getPageInfo()!=null){
            pageInfo = (PageInfo) request.getPageInfo();
        }
        return pageInfo;
    }
    

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/dateWiseStmts")
	public Response<List<TblExciseDuty>> getDateWiseStmts(@Param(value = "startDate") String startDate,@Param(value="endDate") String endDate ){
		List<TblExciseDuty> responseDataList = exciseDutyService.fetchDateWiseStmts(startDate,endDate);
		return new Response<List<TblExciseDuty>> (new ResponseHeader(ResponseHeader.Status.SUCCESS,ResponseHeader.ResultSetType.LIST),
				responseDataList);

	}

    
}
