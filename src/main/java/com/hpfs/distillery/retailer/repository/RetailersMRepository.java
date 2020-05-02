/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import com.hpfs.distillery.retailer.model.TblRetailers_M;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author babasaheb
 *
 */
public interface RetailersMRepository extends JpaRepository<TblRetailers_M,Long> {

	
	List<TblRetailers_M> findBydepotId(Long depotId);
}
