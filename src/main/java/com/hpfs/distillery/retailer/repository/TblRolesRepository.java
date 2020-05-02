/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpfs.distillery.retailer.model.TblRoleMapping;
import com.hpfs.distillery.retailer.model.TblRoles;

/**
 * @author babasaheb
 *
 */
public interface TblRolesRepository extends JpaRepository<TblRoles,Long> {
	
	List<TblRoles> findAllByStatus(String status);
	TblRoles findByRoleId(Long roleId);
	
	
}
