package com.hpfs.distillery.retailer.controller;

import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.dto.Response;
import com.hpfs.distillery.retailer.dto.ResponseHeader;
import com.hpfs.distillery.retailer.dto.ShipmentHeaderDto;
import com.hpfs.distillery.retailer.model.ShipmentHeader;
import com.hpfs.distillery.retailer.service.LabDetailsService;
import com.hpfs.distillery.retailer.service.ShipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;


@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 100000L)
@RequestMapping("/api/shipment")
public class ShipmentController {

    @Autowired
    LabDetailsService labDetailsService;

    @Autowired
    ShipmentService shipmentService;

    private static final String NOT_FOUND = "TPR not found";

    @ApiOperation(value = "saveTransportPermitRequest", notes = "saveTransportPermitRequest", response = Response.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
            @ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
            @ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
            @ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class),})
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/saveTransportPermitRequest")
    public Response<ShipmentHeader> saveTransportPermitRequest(@RequestBody Request<ShipmentHeaderDto> request)
            throws SerialException, SQLException, IOException, ParseException {
        ShipmentHeader shipmentHeader = shipmentService.saveTransportPermitRequest(request.getRequestData());
        return new Response<ShipmentHeader>(
                new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.SINGLE), shipmentHeader);

    }

    @ApiOperation(value = "getAllTPR", notes = "getAllTPR", response = Response.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "INVALID_REQUEST", response = Response.class),
            @ApiResponse(code = 401, message = "NOT_AUTHORISED", response = Response.class),
            @ApiResponse(code = 404, message = "REQUEST_NOT_FOUND", response = Response.class),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = Response.class),
            @ApiResponse(code = 503, message = "SERVER_NOT_AVAILABLE", response = Response.class),})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getAllTPR")
    public Response<List<ShipmentHeader>> getAllTPR() throws IOException {
        List<ShipmentHeader> fetchAllTPR = shipmentService.fetchAllTPR();
        return new Response<List<ShipmentHeader>>(
                new ResponseHeader(ResponseHeader.Status.SUCCESS, ResponseHeader.ResultSetType.LIST), fetchAllTPR);

    }

    @GetMapping("{tprid}")
    public ResponseEntity<ShipmentHeaderDto> getTPR(@PathVariable("tprid") String tprid) {
        final ShipmentHeaderDto tpr = shipmentService.getTPR(tprid);
        if (tpr == null) {
            return new ResponseEntity<>((ShipmentHeaderDto) null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tpr, HttpStatus.OK);
    }


}