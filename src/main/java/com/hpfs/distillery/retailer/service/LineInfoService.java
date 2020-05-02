package com.hpfs.distillery.retailer.service;

import com.hpfs.distillery.retailer.model.ProductionLineDetails;
import com.hpfs.distillery.retailer.model.TblLineInfo;

import java.util.List;

public interface LineInfoService {

    List<TblLineInfo> fetchLineData();

    ProductionLineDetails saveProductLine(ProductionLineDetails productionLineDetails);
}
