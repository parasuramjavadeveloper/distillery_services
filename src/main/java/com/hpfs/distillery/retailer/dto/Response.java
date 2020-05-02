package com.hpfs.distillery.retailer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ResponseHeader;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import java.util.Collections;
import java.util.List;


@EqualsAndHashCode
@JsonIgnoreProperties
@ApiModel(description="Response")
public class Response<T> extends ResourceSupport{
	
	private ResponseHeader responseHeader;
	private PageInfo pageInfo;
	private T responseData;
	private List<T> responseDataList;
	
	public Response(final ResponseHeader responseHeader,final List<T> responseDataList){
		this.responseHeader=responseHeader;
		if(responseDataList!=null){
			this.responseDataList = Collections.unmodifiableList(responseDataList);
		}else{
			this.responseDataList =null;
		}
	}
	
	public Response(final ResponseHeader responseHeader,final PageInfo pageInfo,final List<T> responseDataList){
		this.responseHeader = responseHeader;
		this.pageInfo = pageInfo;
		if(responseDataList!=null){
			this.responseDataList = Collections.unmodifiableList(responseDataList);
		}else{
			this.responseDataList = null;
		}
	}

	public Response(final ResponseHeader responseHeader, final T responseData) {
		this.responseHeader = responseHeader;
		this.responseData = responseData;
	}

	@JsonProperty("responseHeader")
	@ApiModelProperty(notes="API response and Status")
	public ResponseHeader getResponseHeader(){
		return responseHeader;
	}
	
	@JsonProperty("responseData")
	@ApiModelProperty(notes="API response data and Status")
	public T getResponseData(){
		return responseData;
	}
	
	@JsonProperty("pageInfo")
	@ApiModelProperty(notes="API pageInfo and Status")
	public PageInfo getPageInfo(){
		return pageInfo;
	}
	
	@JsonProperty("response Date List")
	@ApiModelProperty(notes="API response Data List and Status")
	public List<T> getResponseDataList(){
		if(responseDataList==null){
			return Collections.EMPTY_LIST;
		}
		return Collections.unmodifiableList(responseDataList);
	}
	
}
