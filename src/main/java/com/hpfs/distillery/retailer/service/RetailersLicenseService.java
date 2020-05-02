/**
 * 
 */
package com.hpfs.distillery.retailer.service;

import java.util.List;

import com.hpfs.distillery.retailer.dto.GridLicenseDtsDto;
import com.hpfs.distillery.retailer.dto.PageInfo;


/**
 * @author cnk's
 *
 */
public interface RetailersLicenseService {

	List<GridLicenseDtsDto> getRetLicDts(GridLicenseDtsDto search, PageInfo pageInfo);
}
