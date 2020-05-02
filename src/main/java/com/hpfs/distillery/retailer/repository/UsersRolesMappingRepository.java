/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpfs.distillery.retailer.model.TblRoleMapping;

/**
 * @author babasaheb
 *
 */
public interface UsersRolesMappingRepository extends JpaRepository<TblRoleMapping,Long> {
	
	
	List<TblRoleMapping> findByUserId(Long userId);
	TblRoleMapping findByUserIdAndRoleId(Long userId,Long roleId);
	
	
}
