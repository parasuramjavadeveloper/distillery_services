package com.hpfs.distillery.retailer.service;

import java.util.List;

import com.hpfs.distillery.retailer.model.TblSupplierM;

public interface SupplierService {
	
	public List<TblSupplierM> getSupplierByType(String type);

}
