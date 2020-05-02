package com.hpfs.distillery.retailer.service;

import java.util.List;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hpfs.distillery.retailer.dto.ShortageDetailsDto;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.model.TblShortageDetails;
import com.hpfs.distillery.retailer.repository.TblShortageInfoRepository;
import com.hpfs.distillery.retailer.utils.DtoToModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ShortageDetailsServiceImpl implements ShortageDetailsService {

	@Resource
	private TblShortageInfoRepository tblShortageInfoRepository;

	DtoToModel dtoToModel = new DtoToModel();
	ModelMapper modelMapper = new ModelMapper();

	public List<TblShortageDetails> fetchShortageInfoData() {
		return tblShortageInfoRepository.findAll();
	}

	@Override
	@Transactional
	public TblShortageDetails saveShortageDts(ShortageDetailsDto requestData, UserDetails us) {
		return tblShortageInfoRepository.save(dtoToModel.toShortageDetails(requestData, us));
	}

	@Override
	public List<TblShortageDetails> fetchDateWiseStmts(String startDate, String endDate) {
		return tblShortageInfoRepository.fetchDateWiseStmts(startDate,endDate);
	}

}
