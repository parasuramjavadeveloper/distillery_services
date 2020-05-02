package com.hpfs.distillery.retailer.service;

import java.util.List;

import com.hpfs.distillery.retailer.dto.CartDetailsDto;
import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.model.TblCartDetails;
import com.hpfs.distillery.retailer.model.TblRetailerPaymentDetails;

public interface CartDetailsService {

	TblCartDetails saveCartDts(CartDetailsDto requestData, UserDetails us);
	List<TblRetailerPaymentDetails> fetchCartDetails();
	//TblCartDetails saveCartDts(CartDetailsDto requestData);
//	TblCartDetails saveCartDts(CartDetailsDto requestData, UserDetails us);

	List<TblRetailerPaymentDetails> getCartRetailDts(TblRetailerPaymentDetails search, PageInfo pageInfo);

	//List<TblRetailerPaymentDetails> getCartRetailDts(Object search, PageInfo pageInfo);

	//TblCartDetails saveCartDetails(TblCartDetails cartDetailsDto);
	//TblCartDetails saveCartDts(Object object);
	//TblCartDetails saveCartDts(TblCartDetails requestData, UserDetails userDetails);

	

}
