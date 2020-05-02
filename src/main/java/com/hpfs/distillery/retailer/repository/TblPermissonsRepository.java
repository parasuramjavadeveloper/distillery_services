/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.TblPermissions;

/**
 * @author babasaheb
 *
 */
public interface TblPermissonsRepository extends JpaRepository<TblPermissions,Long> {
	
	String DELETE_PERM_ROLEID= "DELETE FROM distillery.permissions WHERE role_id =?1 ";
	
	List<TblPermissions> findByRoleId(Long roleId);
	
	
	 @Query(value= DELETE_PERM_ROLEID,nativeQuery=true)
	 Long deletePermissionsByRoleId(Long roleId);
}
