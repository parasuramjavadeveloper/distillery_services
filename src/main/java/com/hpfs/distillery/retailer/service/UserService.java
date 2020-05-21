/**
 * 
 */
package com.hpfs.distillery.retailer.service;

import java.util.List;

import com.hpfs.distillery.retailer.dto.PermissionsDto;
import com.hpfs.distillery.retailer.dto.RolePermissionsDto;
import com.hpfs.distillery.retailer.dto.UserChangePwd;
import com.hpfs.distillery.retailer.dto.UserRolesDto;
import com.hpfs.distillery.retailer.model.TblPermissions;
import com.hpfs.distillery.retailer.model.TblRoles;
import com.hpfs.distillery.retailer.model.TblUserPermissions;
import com.hpfs.distillery.retailer.model.TblUsers;


/**
 * @author cnk's
 *
 */
public interface UserService {
	
	String saveOrUpdateUserRolesMap(UserRolesDto requestData);
	String saveRolePermissions(RolePermissionsDto requestData);
	UserRolesDto fetchUserRolePermByUserId(TblUsers requestData);

	//String saveUserRolesMap(UserRolesDto requestData);
	Long isUserExists(String userName);
	UserRolesDto login(String userName, String password);
	TblUsers validateEmailNum(String emailOrNum);
	TblUsers generateOTP(Long userId, String emailOrNum);
	String createNewPwd(UserChangePwd requestData);
	List<TblRoles> fetchActiveRoles();
	String changePwd(UserChangePwd requestData);
	TblUsers updateUserDts(TblUsers requestData);
	TblUsers userMlogin(String userName, String password);
	List<TblUserPermissions> userOTPLogin(TblUsers requestData);
	TblUsers loginWithMobile(TblUsers requestData);
	List<TblUsers> fetchActiveUsers();
	List<TblPermissions> fetchPermissionByRoleId(Long roleId);
	List<TblPermissions> fetchAllPermissionsDts();
	String spLastLogin(TblUsers requestData);
	String spLastLoginForWeb(TblUsers requestData);
	TblUsers fetchUserDtsByUserId(TblUsers requestData);
	TblUsers addToFavourites(TblUsers requestData);
	
	

	
}
