package com.hpfs.distillery.retailer.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hpfs.distillery.retailer.dto.WalletAmountupdDto;
import com.hpfs.distillery.retailer.dto.WalletDetailsDto;
import com.hpfs.distillery.retailer.model.TblRetailers_M;
import com.hpfs.distillery.retailer.model.TblWallet;
import com.hpfs.distillery.retailer.model.TblWalletTransactions;
import com.hpfs.distillery.retailer.repository.RetailersMRepository;
import com.hpfs.distillery.retailer.repository.TblWalletRepository;
import com.hpfs.distillery.retailer.repository.WalletTransactionsRepository;
import com.hpfs.distillery.retailer.utils.CsvUtils;
import com.hpfs.distillery.retailer.utils.DateFormatUtils;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class WalletServiceImpl implements WalletService {

	@Resource
	TblWalletRepository tblWalletRepository;
	
	@Resource
	RetailersMRepository retailersMRepository;
	
	@Resource
	WalletTransactionsRepository tblwalletTransactionsRepository;
	


	@Override	
	@Transactional
	public String walletCsvDataRead() {
		String msg= "FAILURE";
		int count=0;
		List<TblWallet> list;
		try {
			list = CsvUtils.readCSVWalletData();
			if(list!=null && list.size()>0) {
				for(TblWallet model : list) {
					TblWallet m = tblWalletRepository.save(model);
					if(m!=null && m.getWalletId()>0) {
						count++;
					}
				}
				if(count==list.size()) {
					msg="SUCCESSFULLY WALLET CSV DATA inserted";
				}
			}
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}


	@Override
	@Transactional
	public String walletInsert(TblWallet requestData) {
		String msg ="FAILURE";
		TblWallet wallet=new TblWallet();
		try {
			if(requestData!=null && requestData.getWalletId()!=null) {
				wallet = tblWalletRepository.findByWalletId(requestData.getWalletId());
				wallet.setRetailerCode(requestData.getRetailerCode());
				wallet.setAmountAdded(requestData.getAmountAdded());
				wallet.setAvailableBalance(requestData.getAvailableBalance());
				wallet.setWalletAmount(requestData.getWalletAmount());
				wallet.setAddedDate(requestData.getAddedDate());
				wallet.setTxnRefNum(requestData.getTxnRefNum());
				wallet.setUserId(requestData.getUserId());
				wallet.setUpdatedDate(DateFormatUtils.DateToString());
				if(tblWalletRepository.save(wallet)!=null) {
					msg="SUCCESSFULLY updated";
				}
			}else if(requestData!=null && requestData.getWalletId()==null) {
				wallet.setRetailerCode(requestData.getRetailerCode());
				wallet.setAmountAdded(requestData.getAmountAdded());
				wallet.setAvailableBalance(requestData.getAvailableBalance());
				wallet.setWalletAmount(requestData.getWalletAmount());
				wallet.setAddedDate(requestData.getAddedDate());
				wallet.setTxnRefNum(requestData.getTxnRefNum());
				wallet.setUserId(requestData.getUserId());
				wallet.setCreationDate(DateFormatUtils.DateToString());
				if(tblWalletRepository.save(wallet)!=null) {
					msg="SUCCESSFULLY saved";
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return msg;
	}


	@Override
	public String saveWalletDts(TblWallet requestData) {
		String msg ="FAILURE";
		TblWallet wallet=new TblWallet();
		try {
			if(requestData!=null && requestData.getWalletId()!=null) {
				//wallet = tblWalletRepository.findByWalletId(requestData.getWalletId());
				wallet.setRetailerCode(requestData.getRetailerCode());
				wallet.setAmountAdded(requestData.getAmountAdded());
				wallet.setAvailableBalance(requestData.getAvailableBalance());
				wallet.setWalletAmount(requestData.getWalletAmount());
				wallet.setAddedDate(requestData.getAddedDate());
				wallet.setTxnRefNum(requestData.getTxnRefNum());
				wallet.setUserId(requestData.getUserId());
				wallet.setUpdatedDate(DateFormatUtils.DateToString());
				//Newly added
				wallet.setRetailerName(requestData.getRetailerName());
				wallet.setRetailerType(requestData.getRetailerType());
				wallet.setStatus(requestData.getStatus());
				wallet.setChallanNumber(requestData.getChallanNumber());
				wallet.setBankName(requestData.getBankName());
				wallet.setChallan_Place(requestData.getChallan_Place());
				wallet.setDate(requestData.getDate());
				wallet.setDepositAmount(requestData.getDepositAmount());
				wallet.setFileName(requestData.getFileName());
				wallet.setUpdatedBy(requestData.getUpdatedBy());
				if(tblWalletRepository.save(wallet)!=null) {
					msg="SUCCESSFULLY updated";
				}
			}else if(requestData!=null && requestData.getWalletId()==null) {
				wallet.setRetailerCode(requestData.getRetailerCode());
				wallet.setAmountAdded(requestData.getAmountAdded());
				wallet.setAvailableBalance(requestData.getAvailableBalance());
				wallet.setWalletAmount(requestData.getWalletAmount());
				wallet.setAddedDate(requestData.getAddedDate());
				wallet.setTxnRefNum(requestData.getTxnRefNum());
				wallet.setUserId(requestData.getUserId());
				wallet.setCreationDate(DateFormatUtils.DateToString());
				wallet.setRetailerName(requestData.getRetailerName());
				wallet.setRetailerType(requestData.getRetailerType());
				wallet.setStatus(requestData.getStatus());
				wallet.setChallanNumber(requestData.getChallanNumber());
				wallet.setBankName(requestData.getBankName());
				wallet.setChallan_Place(requestData.getChallan_Place());
				wallet.setDate(requestData.getDate());
				wallet.setDepositAmount(requestData.getDepositAmount());
				wallet.setFileName(requestData.getFileName());
				wallet.setCreatedBy(requestData.getCreatedBy());
				if(tblWalletRepository.save(wallet)!=null) {
					msg="SUCCESSFULLY saved";
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return msg;
	}


	@Override
	public WalletDetailsDto getWalletData(Long userId) {
		List<TblWalletTransactions>	tblWalletTransactionsList=null;
		WalletDetailsDto walletDetailsDto=new WalletDetailsDto();
		TblWallet tblWallet=tblWalletRepository.fetchAvailableBalanceAndPreviousBalance(userId);
		walletDetailsDto.setTblWallet(tblWallet);
		tblWalletTransactionsList=tblwalletTransactionsRepository.fetchAllTransactions(userId);
	walletDetailsDto.setTransactionList(tblWalletTransactionsList);
			
		return walletDetailsDto;
	}


	@Override
	public List<TblRetailers_M> getRetailersMDtsByDepot(Long depotId) {
		List<TblRetailers_M> tblRetailers_MList=  retailersMRepository.findBydepotId(depotId);
		return tblRetailers_MList;
	}


	@Override
	public TblWallet addAmountToWallet(WalletAmountupdDto walletAmountupdDto) {
	
		if(walletAmountupdDto!=null) {
			String retailerCode=walletAmountupdDto.getRetailerCode();
			TblWallet wallet=tblWalletRepository.findByretailerCode(retailerCode);
			if(wallet!=null) {
			if(walletAmountupdDto.getTransactionType().equals("credit"))
			{
			
				wallet.setPreviousBalance(wallet.getAvailableBalance());
				Long availableBalance=wallet.getAvailableBalance()+walletAmountupdDto.getAmount();
				wallet.setAvailableBalance(availableBalance);
				wallet.setUpdatedDate(DateFormatUtils.DateToString());
				wallet.setUpdatedBy(walletAmountupdDto.getUpdatedBy());
				wallet=tblWalletRepository.save(wallet);
				
				if(wallet!=null)
				{
					TblWalletTransactions tblWalletTransactions=new TblWalletTransactions();
					tblWalletTransactions.setRetailerCode(walletAmountupdDto.getRetailerCode());
					tblWalletTransactions.setUserId(walletAmountupdDto.getUser_Id());
					tblWalletTransactions.setType("Credited");
					tblWalletTransactions.setAmount(walletAmountupdDto.getAmount());
					tblWalletTransactions.setIndentId(walletAmountupdDto.getIndentId());
					tblWalletTransactions.setChallanNumber(walletAmountupdDto.getChallanNumber());
					tblWalletTransactions.setChallanDate(walletAmountupdDto.getChallanDate());
					tblWalletTransactions.setBankName(walletAmountupdDto.getBankName());
					tblWalletTransactions.setBankLocation(walletAmountupdDto.getBankLocation());
					tblWalletTransactions.setTransactionDate(DateFormatUtils.DateToString());
					tblwalletTransactionsRepository.save(tblWalletTransactions);
					
				}
			}
			else if(walletAmountupdDto.getTransactionType().equals("debit")) {
				wallet.setPreviousBalance(wallet.getAvailableBalance());
				Long availableBalance=wallet.getAvailableBalance()-walletAmountupdDto.getAmount();
				wallet.setAvailableBalance(availableBalance);
				wallet.setUpdatedDate(DateFormatUtils.DateToString());
				wallet.setUpdatedBy(walletAmountupdDto.getUpdatedBy());
				wallet=tblWalletRepository.save(wallet);
				
				if(wallet!=null)
				{
					TblWalletTransactions tblWalletTransactions=new TblWalletTransactions();
					tblWalletTransactions.setRetailerCode(walletAmountupdDto.getRetailerCode());
					tblWalletTransactions.setUserId(walletAmountupdDto.getUser_Id());
					tblWalletTransactions.setType("Debited");
					tblWalletTransactions.setAmount(walletAmountupdDto.getAmount());
					tblWalletTransactions.setIndentId(walletAmountupdDto.getIndentId());
					tblWalletTransactions.setChallanNumber(walletAmountupdDto.getChallanNumber());
					tblWalletTransactions.setChallanDate(walletAmountupdDto.getChallanDate());
					tblWalletTransactions.setBankName(walletAmountupdDto.getBankName());
					tblWalletTransactions.setBankLocation(walletAmountupdDto.getBankLocation());
					tblWalletTransactions.setTransactionDate(DateFormatUtils.DateToString());
					tblwalletTransactionsRepository.save(tblWalletTransactions);
					
				}
			}
				
				return wallet;
			
}
		}
		return null;	
	}
}
