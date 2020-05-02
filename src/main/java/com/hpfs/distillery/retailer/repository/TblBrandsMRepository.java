/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpfs.distillery.retailer.model.TblBrandsM;

/**
 * @author babasaheb
 *
 */
public interface TblBrandsMRepository extends JpaRepository<TblBrandsM,Long> {
	
	List<TblBrandsM> findAllBrandsByStatus(String status);
}
