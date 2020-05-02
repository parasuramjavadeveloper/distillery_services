/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.TblUserPermissions;

/**
 * @author babasaheb
 *
 */
public interface UserPermissons extends JpaRepository<TblUserPermissions,Long> {
	
	
	String USER_PERMISSIONS_LIST="SELECT p.permission_id,u.user_id,"
			+ "u.user_name,u.first_name,u.last_name,u.email_id,u.mobile_number,u.password,u.status as user_status,rm.role_id,r.role_name,rm.status as role_map_status,p.path,"
			+ "p.isview,p.isedit,p.isdelete "
			+ "FROM "+SCHEMA+"users u INNER JOIN "+SCHEMA+"role_mapping rm ON u.user_id =rm.user_id \n"
			+ "INNER JOIN "+SCHEMA+"roles r ON rm.role_id =r.role_id \n"
			+ "INNER JOIN "+SCHEMA+"permissions  p ON rm.role_mapping_id = p.role_mapping_id \n"
			+ "WHERE u.status='ACTIVE' and rm.status='ACTIVE' and u.user_id=?1";
	
	@Query(value=USER_PERMISSIONS_LIST,nativeQuery=true)
	List<TblUserPermissions> fetchAllPermissionByUserId(Long userId);
}
