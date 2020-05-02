package com.hpfs.distillery.retailer.controller;

import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.model.ProductionLineDetails;
import com.hpfs.distillery.retailer.model.TblLineInfo;
import com.hpfs.distillery.retailer.service.LineInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge=100000L)
@RequestMapping("/api/product")
public class ProductManagementController {

    @Autowired
    LineInfoService lineInfoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/fetchLineInfoDts")
    public Response<List<TblLineInfo>> fetchLineInfoDts(){
        List<TblLineInfo> responseData = lineInfoService.fetchLineData();
        return new Response<List<TblLineInfo>>(new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST),
                responseData);

    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path="/saveProductLine")
    public Response<ProductionLineDetails> saveProductLine(@RequestBody ProductionLineDetails productionLineDetails)
    {
        ProductionLineDetails productionLineDetails1=lineInfoService.saveProductLine(productionLineDetails);
        return new Response<ProductionLineDetails>(new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE),
                productionLineDetails1);
    }
}
