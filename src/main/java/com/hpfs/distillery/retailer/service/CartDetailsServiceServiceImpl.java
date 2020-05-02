package com.hpfs.distillery.retailer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hpfs.distillery.retailer.dto.CartDetailsDto;
import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.model.TblCartDetails;
import com.hpfs.distillery.retailer.model.TblRetailerPaymentDetails;
import com.hpfs.distillery.retailer.repository.CartDetailsDRepository;
import com.hpfs.distillery.retailer.repository.CartDetailsRepository;
import com.hpfs.distillery.retailer.utils.DtoToModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CartDetailsServiceServiceImpl implements CartDetailsService {
	
	@Resource
	CartDetailsRepository tblCartDetailsMRepository;

	@Resource
	CartDetailsDRepository tblCartDetailsDRepository;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional
	public TblCartDetails saveCartDts(CartDetailsDto requestData, UserDetails us) {
		TblCartDetails tblCartMDts = null;
		DtoToModel dtoToModel = new DtoToModel();
		// TblIndent_D tblIndentDDts = null;
		if (null != requestData) {
			tblCartMDts = dtoToModel.toTblCartdetails(requestData, us);
			tblCartMDts = tblCartDetailsMRepository.save(tblCartMDts);
			List<TblRetailerPaymentDetails> list = dtoToModel.toTblCartdetailsList(requestData, us);
			if (tblCartMDts.getId() != 0) {
				if (null != list && list.size() > 0) {
					List<TblRetailerPaymentDetails> returnList = new ArrayList<>();
					for (TblRetailerPaymentDetails tblIndentDDts : list) {
						tblIndentDDts.setRetailerCode(tblCartMDts.getRetailerCode());
						tblIndentDDts = tblCartDetailsDRepository.save(tblIndentDDts);
						returnList.add(tblIndentDDts);

					}
					if (null != returnList && returnList.size() == list.size()) {
						return tblCartMDts;
					}
				} else {
					return tblCartMDts;
				}

			}
		}
		return tblCartMDts;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public List<TblRetailerPaymentDetails> getCartRetailDts(TblRetailerPaymentDetails search, PageInfo pageInfo) {
		Page<TblRetailerPaymentDetails> pageList =null;
		List<TblRetailerPaymentDetails> gridList = null;
		if(null!=search){
			pageList = tblCartDetailsDRepository.fetchCartRetailDtsBy(
					search.getRetailerCode(),search.getStatus(),search.getPaymentDate(),search.getPaymentType(),search.getAmount(),
					PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize(), new Sort(pageInfo.getSortBy())));
//			pageList = tblCartDetailsDRepository.fetchCartRetailDtsBy(search.getRetailerPaymentId(),
//					search.getRetailerCode(),search.getPaymentDate(),search.getPaymentType(),search.getStatus(),search.getAmount(),search.getChequeNumber(),
//					search.getCreationDate(),search.getCreatedBy(),
//					PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize(), new Sort(pageInfo.getSortBy())));
			
		}else{
			
			pageList = tblCartDetailsDRepository.fetchAllStockDts(PageRequest.of(0, 5, new Sort(pageInfo.getSortBy())));
			//pageList = tblCartDetailsDRepository.fetchAllStockDts(PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize(), new Sort(pageInfo.getSortBy())));
			System.out.println("pageList is" + pageList.getSize());
		}
		if(Objects.nonNull(pageList)){
			gridList =  pageList.getContent();
			pageInfo.setTotalElements(pageList.getTotalElements());
			pageInfo.setTotalPages(pageList.getTotalPages());
		}
		return gridList;
	}


	@Override
	public List<TblRetailerPaymentDetails> fetchCartDetails() {
			return tblCartDetailsDRepository.fetchAllCartDetails();
		}

}
