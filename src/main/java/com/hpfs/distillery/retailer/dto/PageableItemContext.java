package com.hpfs.distillery.retailer.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class PageableItemContext<T> {
	
	List<T> count;
	Long totalItems;
}
