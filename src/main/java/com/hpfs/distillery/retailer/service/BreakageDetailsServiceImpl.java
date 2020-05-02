package com.hpfs.distillery.retailer.service;

import java.util.List;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hpfs.distillery.retailer.dto.BreakageDetailsDto;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.model.TblBreakageDetails;
import com.hpfs.distillery.retailer.repository.TblBreakageInfoRepository;
import com.hpfs.distillery.retailer.utils.DtoToModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BreakageDetailsServiceImpl implements BreakageDetailsService {

	@Resource
	private TblBreakageInfoRepository tblBreakageInfoRepository;

	DtoToModel dtoToModel = new DtoToModel();
	ModelMapper modelMapper = new ModelMapper();
	public List<TblBreakageDetails> fetchBreakageInfoData() {
		return tblBreakageInfoRepository.findAll();
	}


	@Override
	@Transactional
	public TblBreakageDetails saveBreakageDts(BreakageDetailsDto requestData, UserDetails us) {
		return  tblBreakageInfoRepository.save(dtoToModel.toBreakageDetails(requestData, us));
	}


	@Override
	public List<TblBreakageDetails> fetchDateWiseStmts(String startDate, String endDate) {
		
		return tblBreakageInfoRepository.fetchDateWiseStmts(startDate,endDate);
	}


	@Override
	public List<String> fetchProductTypeList() {
		return tblBreakageInfoRepository.fetchProductTypeList();	}

	}