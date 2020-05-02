/**
 * 
 */
package com.hpfs.distillery.retailer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author babasaheb
 *
 */
@Entity
@Table(name="permissions")
public class TblPermissions {
	
	@Override
	public String toString() {
		return "TblPermissions [permissionId=" + permissionId + ", path=" + path
				+ ", isView=" + isView + ", isEdit=" + isEdit + ", isDelete=" + isDelete + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="permission_id")
	public Long permissionId;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isDelete == null) ? 0 : isDelete.hashCode());
		result = prime * result + ((isEdit == null) ? 0 : isEdit.hashCode());
		result = prime * result + ((isView == null) ? 0 : isView.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((permissionId == null) ? 0 : permissionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TblPermissions other = (TblPermissions) obj;
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		if (isEdit == null) {
			if (other.isEdit != null)
				return false;
		} else if (!isEdit.equals(other.isEdit))
			return false;
		if (isView == null) {
			if (other.isView != null)
				return false;
		} else if (!isView.equals(other.isView))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (permissionId == null) {
			if (other.permissionId != null)
				return false;
		} else if (!permissionId.equals(other.permissionId))
			return false;
		
		return true;
	}

	

	@Column(name="path")
	public String path;
	
	@Column(name="isview")
	public Long isView;
	
	@Column(name="isedit")
	public Long isEdit;
	
	@Column(name="isdelete")
	public Long isDelete;
	
	@Column(name="isadd")
	public Long isAdd;
	
	@Column(name="role_id")
	public Long roleId;
	
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

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
