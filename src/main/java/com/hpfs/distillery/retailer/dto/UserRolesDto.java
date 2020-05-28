/**
 * 
 */
package com.hpfs.distillery.retailer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.mapping.Array;

/**
 * @author babasaheb
 *
 */
@Getter
@Setter
public class UserRolesDto {
	
	
	public Long userId;
	public String userName;
	public String firstName;
	public String lastName;
	public Long mobileNumber;
	public String emailId;
	public String password;
	public String status;
	public String favourites ;
	public List<Long> roleIds;
	public String department;
	public String isDistillery;
	public String isDepo;
	public Long deptId;

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

	public List<RolesDto> rolesList;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	public List<RolesDto> getRolesList() {
		return rolesList;
	}

	public void setRolesList(List<RolesDto> rolesList) {
		this.rolesList = rolesList;
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

	public String getFavourites() {
		return favourites;
	}

	public void setFavourites(String favourites) {
		this.favourites = favourites;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getIsDistillery() {
		return isDistillery;
	}

	public void setIsDistillery(String isDistillery) {
		this.isDistillery = isDistillery;
	}

	public String getIsDepo() {
		return isDepo;
	}

	public void setIsDepo(String isDepo) {
		this.isDepo = isDepo;
	}
}
