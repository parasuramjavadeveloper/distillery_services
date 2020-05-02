/**
 * 
 */
package com.hpfs.distillery.retailer.dto;

/**
 * @author babasaheb
 *
 */
public class PermissionsDto {
	
	public Long permissionId;
	public Long roleId;
	public String path;
	public Long isView;
	public Long isEdit;
	public Long isDelete;
	public Long isAdd;
	
	public Long getIsAdd() {
		return isAdd;
	}
	public void setIsAdd(Long isAdd) {
		this.isAdd = isAdd;
	}
	public Long getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Long getIsView() {
		return isView;
	}
	public void setIsView(Long isView) {
		this.isView = isView;
	}
	public Long getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(Long isEdit) {
		this.isEdit = isEdit;
	}
	public Long getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Long isDelete) {
		this.isDelete = isDelete;
	}
	
	
	
}
