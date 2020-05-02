package com.hpfs.distillery.retailer.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hpfs.distillery.retailer.dto.GridLicenseDtsDto;
import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.model.GridLicenseDts;
import com.hpfs.distillery.retailer.repository.GridLicenseDtsRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class RetailersLicenseServiceImpl implements RetailersLicenseService {

	@Resource
	GridLicenseDtsRepository gridLicenseDtsRepository;

	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<GridLicenseDtsDto> getRetLicDts(GridLicenseDtsDto search, PageInfo pageInfo) {
		Page<GridLicenseDts> pageList =null;
		List<GridLicenseDtsDto> gridList = null;
		if(null!=search){
			pageList = gridLicenseDtsRepository.fetchLicenseDtsBy(search.getLicenseDetailId(),search.getIssuedDate(),
			search.getExpiryDate(),search.getRetailerCode(),search.getShopName(),search.getDepotId(),
			search.getDepotName(),search.getUserId(),search.getMobileNumber(),search.getEmailId(),
					PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize(), new Sort(pageInfo.getSortBy())));
		}else{
			pageList = gridLicenseDtsRepository.fetchAllLicenseDts(PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize(), new Sort(pageInfo.getSortBy())));
		}
		if(Objects.nonNull(pageList)){
			List<GridLicenseDts> reportList =  pageList.getContent();
			gridList = reportList.stream().map(entity-> modelMapper.map(entity,GridLicenseDtsDto.class)).collect(Collectors.toList());
			pageInfo.setTotalElements(pageList.getTotalElements());
			pageInfo.setTotalPages(pageList.getTotalPages());
		}
		return gridList;
	}

}
