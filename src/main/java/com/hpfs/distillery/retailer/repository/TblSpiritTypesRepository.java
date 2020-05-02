/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpfs.distillery.retailer.model.TblRoleMapping;
import com.hpfs.distillery.retailer.model.TblRoles;
import com.hpfs.distillery.retailer.model.TblSpiritTypes;

/**
 * @author babasaheb
 *
 */
public interface TblSpiritTypesRepository extends JpaRepository<TblSpiritTypes,Long> {
	
	List<TblSpiritTypes> findAllByStatus(String status);
	
	
}
