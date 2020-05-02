/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.TblDistilleryInvM;
import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

/**
 * @author babasaheb
 *
 */
public interface DistilleryInvMRepository extends JpaRepository<TblDistilleryInvM,Long> {
	
	@Query(value="SELECT * FROM "+SCHEMA+"distillery_inv_m  #{#pageable}",
	countQuery="SELECT COUNT(1) FROM "+SCHEMA+"distillery_inv_m",nativeQuery=true)
	Page<TblDistilleryInvM> fetchAllInvMgmDts(Pageable pageable);
	

}
