/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.hpfs.distillery.retailer.model.TblDistiInvM;

/**
 * @author babasaheb
 *
 */
public interface DistiInvMRepository extends JpaRepository<TblDistiInvM,String> {
	
	TblDistiInvM findByCaseBarNo(String caseBarNo);
}
