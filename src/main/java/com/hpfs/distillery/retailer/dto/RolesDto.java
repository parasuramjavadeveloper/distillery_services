/**
 * 
 */
package com.hpfs.distillery.retailer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

/**
 * @author babasaheb
 *
 */
@Getter
@Setter
public class RolesDto {
	
	
	public Long roleId;
	public String roleName;
	public String roleType;
	public String description;
	public String status;
	public List<PermissionsDto> permissionsList;
	
	

	
	

	public List<PermissionsDto> getPermissionsList() {
		return permissionsList;
	}

	public void setPermissionsList(List<PermissionsDto> permissionsList) {
		this.permissionsList = permissionsList;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
