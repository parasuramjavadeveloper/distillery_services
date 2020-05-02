package com.hpfs.distillery.retailer.service;


import java.util.List;

import com.hpfs.distillery.retailer.dto.WalletAmountupdDto;
import com.hpfs.distillery.retailer.dto.WalletDetailsDto;
import com.hpfs.distillery.retailer.model.TblRetailers_M;
import com.hpfs.distillery.retailer.model.TblWallet;

public interface WalletService {

	String walletCsvDataRead();

	String walletInsert(TblWallet tblWallet);
	
	String saveWalletDts(TblWallet tblWallet);


	WalletDetailsDto getWalletData(Long userId);

	List<TblRetailers_M> getRetailersMDtsByDepot(Long depotId);

	TblWallet addAmountToWallet(WalletAmountupdDto walletAmountupdDto);


	
}
