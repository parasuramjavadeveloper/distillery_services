package com.hpfs.distillery.retailer.dto;

import java.util.List;

import com.hpfs.distillery.retailer.model.TblWallet;
import com.hpfs.distillery.retailer.model.TblWalletTransactions;

/**
 * @author manikanta
 *
 */
public class WalletDetailsDto {

	private TblWallet tblWallet;
	private List<TblWalletTransactions> transactionList;
	public TblWallet getTblWallet() {
		return tblWallet;
	}
	public void setTblWallet(TblWallet tblWallet) {
		this.tblWallet = tblWallet;
	}
	public List<TblWalletTransactions> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<TblWalletTransactions> transactionList) {
		this.transactionList = transactionList;
	}
	
	
	
	
	
}
