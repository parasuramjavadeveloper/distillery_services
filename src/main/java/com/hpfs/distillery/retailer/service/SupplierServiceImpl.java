package com.hpfs.distillery.retailer.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpfs.distillery.retailer.model.TblSupplierM;
import com.hpfs.distillery.retailer.repository.TblSupplierMRepository;
import com.hpfs.distillery.retailer.utils.ApplicationConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SupplierServiceImpl implements SupplierService {

	@Resource
	TblSupplierMRepository tblSupplierMRepository;

	@Override
	public List<TblSupplierM> getSupplierByType(String type) {
		List<TblSupplierM> list = null;
		if (type != null && type.equalsIgnoreCase(ApplicationConstants.LOCAL)) {
			list = tblSupplierMRepository.findByStatename(ApplicationConstants.LOCAL_SUPPLIER);
		} else if (type != null && type.equalsIgnoreCase(ApplicationConstants.NON_LOCAL)) {
			list = tblSupplierMRepository.findByStatenameNot(ApplicationConstants.LOCAL_SUPPLIER);
		}else if (type != null && type.equalsIgnoreCase(ApplicationConstants.FOREIGN)) {
			list = tblSupplierMRepository.findByCountrynameNot(ApplicationConstants.COUNTRY);
		}else if (type != null && type.equalsIgnoreCase(ApplicationConstants.BREWERIES)) {
			list = tblSupplierMRepository.findByStatenameNot(ApplicationConstants.LOCAL_SUPPLIER);
		}

		return list;
	}
}
