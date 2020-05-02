package com.hpfs.distillery.retailer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hpfs.distillery.retailer.dto.HologramDetailsDto;
import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.model.TblHologramDetails;
import com.hpfs.distillery.retailer.repository.HologramDetailsRepository;
import com.hpfs.distillery.retailer.utils.DtoToModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HologramDetailsServiceImpl implements HologramDetailsService {

	public static final Logger logger = LoggerFactory.getLogger(HologramDetailsServiceImpl.class);
	@Resource
	HologramDetailsRepository hologramDetailsRepository;

	DtoToModel dtoToModel = new DtoToModel();

	ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional
	public TblHologramDetails saveHealDailyIndentDetails(HologramDetailsDto requestData, UserDetails us) {
		TblHologramDetails tblHologramDetails = null;
		if (null != requestData) {
			tblHologramDetails = dtoToModel.toTblHologramHealIndentDetails(requestData, us);
			tblHologramDetails = hologramDetailsRepository.save(tblHologramDetails);
			List<TblHologramDetails> list = dtoToModel.toTblHologramHealIndentDetailsList(requestData, us);
			if (tblHologramDetails.getIndentNum() != 0) {
				if (null != list && list.size() > 0) {
					List<TblHologramDetails> returnList = new ArrayList<>();
					for (TblHologramDetails tblIndentDDts : list) {
						tblIndentDDts.setIndentNum(tblHologramDetails.getIndentNum());
						tblIndentDDts = hologramDetailsRepository.save(tblIndentDDts);
						returnList.add(tblIndentDDts);

					}
					if (null != returnList && returnList.size() == list.size()) {
						return tblHologramDetails;
					}
				} else {
					return tblHologramDetails;
				}

			}
		}
		return tblHologramDetails;
	}
	
	//With Grid Search
	//getHealDailyIndentDtsas
	
	
	//HologramDetailsDto TblHologramDetails
	@Override
	public List<HologramDetailsDto> getHealDailyIndentDtsas(HologramDetailsDto search, PageInfo pageInfo) {
		Page<TblHologramDetails> pageList =null;
		List<HologramDetailsDto> gridList = null;
		if(null!=search){
			pageList = hologramDetailsRepository.fetchHealDailyIndentDtsBy(search.getIndentNum(),search.getChallanNum(),
					search.getChallanAmount(),search.getChallanDate(),search.getCarrierName(),
					search.getQuantity(),search.getPurpose(),search.getStoBank(),search.getStatus(),search.getCreationDate(),
					PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize()));
		}else{
			pageList = hologramDetailsRepository.fetchAllHealDailyIndentDts(PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize()));
		}
		if(Objects.nonNull(pageList)){
			List<TblHologramDetails> reportList =  pageList.getContent();
			gridList = reportList.stream().map(entity-> modelMapper.map(entity,HologramDetailsDto.class)).collect(Collectors.toList());
			pageInfo.setTotalElements(pageList.getTotalElements());
			pageInfo.setTotalPages(pageList.getTotalPages());
		}
		return gridList;
	}
	
	
	
	
	@Override
	public List<TblHologramDetails> fetchHealDailyIndentDetails() {
		 return hologramDetailsRepository.findAllHologramHealDailyIndents(null);
	}


	@Override
	public List<TblHologramDetails> fetchHealDailyIndentDetailsByIndentNo(Long IndentNo) {
		return hologramDetailsRepository.fetchHologramHealDailyIndentsByIndentNo(IndentNo);
	}

	
	@Override
	public TblHologramDetails saveHealPurchaseIndentDetails(HologramDetailsDto requestData,
			UserDetails us) {
	
		return  hologramDetailsRepository.save(dtoToModel.toTblHologramHealPurchaseIndentDetails(requestData, us));

	}
	
	@Override
	public List<String> fetchHealPurchaseIndentPurposeList() {
		List<String> purposeList =null;
		{
			purposeList = hologramDetailsRepository.fetchHealPurchaseIndentPurposeList();
		}
		
		return purposeList;
	}

	@Override
	public List<TblHologramDetails> fetchDateWiseStmts(String startDate, String endDate) {
		return hologramDetailsRepository.fetchDateWiseStmts(startDate,endDate);
	}

	

	
}
