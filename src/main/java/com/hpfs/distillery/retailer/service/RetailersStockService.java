package com.hpfs.distillery.retailer.service;

import java.util.List;

import com.hpfs.distillery.retailer.dto.GridStockDtsDto;
import com.hpfs.distillery.retailer.dto.PageInfo;

public interface RetailersStockService {

	List<GridStockDtsDto> getRetailersStockDtsas(GridStockDtsDto search, PageInfo pageInfo);

}
