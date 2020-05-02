/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.TblDepot_M;
import com.hpfs.distillery.retailer.model.TblProductsM;

/**
 * @author babasaheb
 *
 */
public interface TblProductsMRepository extends JpaRepository<TblProductsM,Long> {
	
	String PRD_NAME_QUERY="SELECT * from distillery.products_m where status='ACTIVE' and product_name like ?1% ";
	
	@Query(value=PRD_NAME_QUERY,nativeQuery=true)
	List<TblProductsM> fetchByProductNames(String prodName);
	
	List<TblProductsM> findAllProductsByStatus(String status);
}
