/**
 * 
 */
package com.hpfs.distillery.retailer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author babasaheb
 *
 */
@Entity
public class TblUserPermissions {
	
	

	@Id
	@Column(name="permission_id")
	public Long permissionId;
	
	@Column(name="user_id")
	public Long userId;

	@Column(name="user_name")
	public String userName;
	
	@Column(name="first_name")
	public String firstName;

	@Column(name="last_name")
	public String lastName;

	@Column(name="mobile_number")
	public Long mobileNumber;
	
	@Column(name="email_id")
	public String emailId;

	@Column(name="password")
	public String password;

	@Column(name="user_status")
	public String userStatus;
	
	@Column(name="role_id")
	public Long roleId;
	
	@Column(name="role_name")
	public String roleName;
	
	@Column(name="role_map_status")
	public String roleMapStatus;

	@Column(name="path")
	public String path;
	
	@Column(name="isview")
	public Long isView;
	
	@Column(name="isedit")
	public Long isEdit;
	
	@Column(name="isdelete")
	public Long isDelete;

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
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

	public String getRoleMapStatus() {
		return roleMapStatus;
	}

	public void setRoleMapStatus(String roleMapStatus) {
		this.roleMapStatus = roleMapStatus;
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
	
	@Override
	public String toString() {
		return "TblUserPermissions [permissionId=" + permissionId + ", userId=" + userId + ", userName=" + userName
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + ", password=" + password + ", userStatus=" + userStatus + ", roleId="
				+ roleId + ", roleName=" + roleName + ", roleMapStatus=" + roleMapStatus + ", path=" + path
				+ ", isView=" + isView + ", isEdit=" + isEdit + ", isDelete=" + isDelete + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((isDelete == null) ? 0 : isDelete.hashCode());
		result = prime * result + ((isEdit == null) ? 0 : isEdit.hashCode());
		result = prime * result + ((isView == null) ? 0 : isView.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((permissionId == null) ? 0 : permissionId.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((roleMapStatus == null) ? 0 : roleMapStatus.hashCode());
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userStatus == null) ? 0 : userStatus.hashCode());
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
		TblUserPermissions other = (TblUserPermissions) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
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
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleMapStatus == null) {
			if (other.roleMapStatus != null)
				return false;
		} else if (!roleMapStatus.equals(other.roleMapStatus))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userStatus == null) {
			if (other.userStatus != null)
				return false;
		} else if (!userStatus.equals(other.userStatus))
			return false;
		return true;
	}
	
}
