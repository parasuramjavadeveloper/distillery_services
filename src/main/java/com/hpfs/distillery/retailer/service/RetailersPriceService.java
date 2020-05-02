/**
 * 
 */
package com.hpfs.distillery.retailer.service;

import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.model.TblDepotInventoryM;

import java.util.List;


/**
 * @author cnk's
 *
 */
public interface RetailersPriceService {


	List<TblDepotInventoryM> getDportInvMDts(TblDepotInventoryM search, PageInfo pageInfo);
}
