/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.TblDepot_M;

/**
 * @author babasaheb
 *
 */
public interface DepotMRepository extends JpaRepository<TblDepot_M,Long> {
	
	String DEPOT_NAME_QUERY="SELECT * from depot_m where status='Y' and depot_name like ?1% ";
	
	
	@Query(value=DEPOT_NAME_QUERY,nativeQuery=true)
	List<TblDepot_M> fetchByDepotNames(String depotName);


	TblDepot_M findByDepotNameAndStatus(String depotName,String status);
}
