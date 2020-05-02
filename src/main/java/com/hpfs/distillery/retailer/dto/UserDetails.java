package com.hpfs.distillery.retailer.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserDetails {

	private String emailOrNum;
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmailOrNum() {
		return emailOrNum;
	}

	public void setEmailOrNum(String emailOrNum) {
		this.emailOrNum = emailOrNum;
	}
	
}
