/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpfs.distillery.retailer.model.TblSupplierM;

/**
 * @author babasaheb
 *
 */
public interface TblSupplierMRepository extends JpaRepository<TblSupplierM,Long> {
	
	List<TblSupplierM> findAllByStatus(String status);
	
	List<TblSupplierM> findByStatename(String statename);
	
	List<TblSupplierM> findByStatenameNot(String statename);
	
	List<TblSupplierM> findByCountrynameNot(String statename);
	
}
