/**
 * 
 */
package com.hpfs.distillery.retailer.dto;

import java.util.List;

/**
 * @author babasaheb
 *
 */
public class RolePermissionsDto {
	
	private Long roleId;
	private String roleName;
	private String roleDescription;
	private String roleType;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	private List<PermissionsDto> permissionsList;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public List<PermissionsDto> getPermissionsList() {
		return permissionsList;
	}
	public void setPermissionsList(List<PermissionsDto> permissionsList) {
		this.permissionsList = permissionsList;
	}
	
	
	
	
}
