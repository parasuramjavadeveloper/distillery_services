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
import com.hpfs.distillery.retailer.dto.GridStockDtsDto;
import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.model.GridStockDts;
import com.hpfs.distillery.retailer.repository.GridStockDtsRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class RetailersStockServiceImpl implements RetailersStockService {

	@Resource
	GridStockDtsRepository gridStockDtsRepository;

	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<GridStockDtsDto> getRetailersStockDtsas(GridStockDtsDto search, PageInfo pageInfo) {
		Page<com.hpfs.distillery.retailer.model.GridStockDts> pageList =null;
		List<GridStockDtsDto> gridList = null;
		if(null!=search){
			pageList = gridStockDtsRepository.fetchStockDtsBy(search.getDepotInvId(),search.getProductCode(),
					search.getProductType(),search.getBrandName(),search.getOpeningBalance(),
					search.getSales(),search.getClosingBalance(),search.getBreakages(),search.getShortages(),
					PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize()));
		}else{
			pageList = gridStockDtsRepository.fetchAllStockDts(PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize()));
		}
		if(Objects.nonNull(pageList)){
			List<GridStockDts> reportList =  pageList.getContent();
			gridList = reportList.stream().map(entity-> modelMapper.map(entity,GridStockDtsDto.class)).collect(Collectors.toList());
			pageInfo.setTotalElements(pageList.getTotalElements());
			pageInfo.setTotalPages(pageList.getTotalPages());
		}
		return gridList;
	}

}
