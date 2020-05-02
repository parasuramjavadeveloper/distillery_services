/**
 * 
 */
package com.hpfs.distillery.retailer.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author babasaheb
 *
 */
@Getter
@Setter
public class RoleMappingDto {
	
	public Long roleMappingId;
	public Long userId;
	public Long roleId;
	public String description;
	public String creationDate;
	public String createdBy;
	public String updatedDate;
	public String updatedBy;

	public Long getRoleMappingId() {
		return roleMappingId;
	}

	public void setRoleMappingId(Long roleMappingId) {
		this.roleMappingId = roleMappingId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	

}
