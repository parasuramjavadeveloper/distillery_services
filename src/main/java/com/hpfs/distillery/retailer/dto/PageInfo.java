package com.hpfs.distillery.retailer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
@ApiModel(description="PageInfo")
public class PageInfo {
	
	@ApiModelProperty(notes="pageNumber")
	private int pageNumber=0;
	
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	@ApiModelProperty(notes="pageSize")
	private int pageSize=0;
	
	@ApiModelProperty(notes="totalElements")
	private long totalElements=0l;
	
	@ApiModelProperty(notes="totalPages")
	private int totalPages=0;
	
	@ApiModelProperty(notes="direction")
	private String direction="";
	
	@ApiModelProperty(notes="sortBy")
	private String sortBy="";
	

}
