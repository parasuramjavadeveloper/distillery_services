package com.hpfs.distillery.retailer.service;

import java.util.List;

import com.hpfs.distillery.retailer.model.ProductionLineDetails;
import com.hpfs.distillery.retailer.model.TblLineInfo;

public interface ReportService {

	 List<TblLineInfo> fetchLineData();

	    ProductionLineDetails saveProductLine(ProductionLineDetails productionLineDetails);
}
