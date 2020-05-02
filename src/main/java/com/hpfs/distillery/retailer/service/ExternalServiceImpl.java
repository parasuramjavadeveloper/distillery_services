package com.hpfs.distillery.retailer.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hpfs.distillery.retailer.model.TblBarcodeM;
import com.hpfs.distillery.retailer.model.TblBrandsM;
import com.hpfs.distillery.retailer.repository.TblBarcodeMRepository;
import com.hpfs.distillery.retailer.repository.TblBrandsMRepository;
import com.hpfs.distillery.retailer.utils.ApplicationConstants;
import com.hpfs.distillery.retailer.utils.XmlReader;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class ExternalServiceImpl implements ExternalService {

	@Resource
	TblBarcodeMRepository tblBarcodeMRepository;


	@Override
	@Transactional
	public String xmlBarCodeRead() {
		String msg= "FAILURE";
		int count=0;
		List<TblBarcodeM> list = XmlReader.readXMLFileData();
		
		if(list!=null && list.size()>0) {
			for(TblBarcodeM model : list) {
				TblBarcodeM m = tblBarcodeMRepository.save(model);
				if(m!=null && m.getId()>0) {
					count++;
				}
				
			}
			if(count==list.size()) {
				msg="SUCCESSFULLY XML Barcodes Data inserted";
			}
		}
		return msg;
	}


	@Override
	public TblBarcodeM scanBarcode(TblBarcodeM search) {
		if(search!= null && search.getBarcodeNumber()!=null && search.getBarcodeNumber()!="") {
			return tblBarcodeMRepository.findByBarcodeNumber(search.getBarcodeNumber());
		}
		return null;
	}
	
	

	
}
