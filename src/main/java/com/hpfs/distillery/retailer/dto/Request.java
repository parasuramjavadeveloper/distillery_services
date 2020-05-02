package com.hpfs.distillery.retailer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request<T> {

	private PageInfo pageInfo;
	private T requestData;
	public T getRequestData() {
		return requestData;
	}
	public void setRequestData(T requestData) {
		this.requestData = requestData;
	}
	public Object getPageInfo() {
		// TODO Auto-generated method stub
		return this.pageInfo;
	}
}
