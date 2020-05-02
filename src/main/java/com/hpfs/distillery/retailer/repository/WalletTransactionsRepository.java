package com.hpfs.distillery.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.TblWalletTransactions;

/**
 * @author manikanta
 *
 */

public interface WalletTransactionsRepository extends JpaRepository<TblWalletTransactions,Long> {

	
String WALLET_TRANSACTIONS_LIST="select * from wallet_transactions where user_id=?1 order by trans_date desc limit 10 ";

	
	
	@Query(value=WALLET_TRANSACTIONS_LIST,nativeQuery=true)
	List<TblWalletTransactions> fetchAllTransactions(Long userId);
}
