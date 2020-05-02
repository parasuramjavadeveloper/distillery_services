package com.hpfs.distillery.retailer.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hpfs.distillery.retailer.model.TblBrandsM;
import com.hpfs.distillery.retailer.repository.TblBrandsMRepository;
import com.hpfs.distillery.retailer.utils.ApplicationConstants;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class BlendStockServiceImpl implements BlendStockService {

	@Resource
	TblBrandsMRepository tblBrandsMRepository;

	@Override
	public List<TblBrandsM> fetchAllBrandCatgs() {
		return tblBrandsMRepository.findAllBrandsByStatus(ApplicationConstants.ACTIVE_STATUS);
	}
	
	

	
}
