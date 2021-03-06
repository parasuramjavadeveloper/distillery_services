package com.hpfs.distillery.retailer.service;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.model.TblDepotInventoryM;
import com.hpfs.distillery.retailer.repository.DepotInventoryMRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class RetailersPriceServiceImpl implements RetailersPriceService {

	@Resource
	DepotInventoryMRepository depotInventoryMRepository;


	@Override
	public List<TblDepotInventoryM> getDportInvMDts(TblDepotInventoryM search, PageInfo pageInfo) {
		Page<TblDepotInventoryM> pageList =null;
		List<TblDepotInventoryM> returnList  = null;
		if(null==search){
			pageList = depotInventoryMRepository.findAll(PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize()));
		}
		if(Objects.nonNull(pageList)){
			returnList =  pageList.getContent();
			pageInfo.setTotalElements(pageList.getTotalElements());
			pageInfo.setTotalPages(pageList.getTotalPages());
		}
		return returnList;
	}
}
