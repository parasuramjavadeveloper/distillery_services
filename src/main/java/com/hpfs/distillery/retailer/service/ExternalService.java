package com.hpfs.distillery.retailer.service;

import com.hpfs.distillery.retailer.model.TblBarcodeM;

public interface ExternalService {

	String xmlBarCodeRead();

	TblBarcodeM scanBarcode(TblBarcodeM object);

	
}
