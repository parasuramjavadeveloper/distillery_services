/**
 * 
 */
package com.hpfs.distillery.retailer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.dto.WalletDetailsDto;
import com.hpfs.distillery.retailer.model.TblWallet;

/**
 * @author babasaheb
 *
 */
public interface TblWalletRepository extends JpaRepository<TblWallet,Long> {
	TblWallet findByWalletId(Long id);
	
	
	String WALLET_DATA="select * from wallet where user_id=?1";
	
	@Query(value=WALLET_DATA,nativeQuery=true)
	TblWallet fetchAvailableBalanceAndPreviousBalance(Long userId);

	TblWallet findByretailerCode(String retailerCode);
	
	
	

}
