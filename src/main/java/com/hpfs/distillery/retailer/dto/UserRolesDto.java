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
}
