/**
 * 
 */
package com.hpfs.distillery.retailer.service;

import com.hpfs.distillery.retailer.dto.IndentCreationDto;
import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.dto.TblDistilleryInvMDto;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.model.*;

import java.util.List;


/**
 * @author cnk's
 *
 */
public interface IndentMgmService {

	List<TblDistilleryInvMDto> findAllTblDistillery();

	List<TblDistilleryInvMDto> getDistelleryInvMgmDts(TblDistilleryInvMDto search, PageInfo pageInfo);
	TblIndent_M saveIndentDts(IndentCreationDto requestData, UserDetails us);
	List<TblIndent_D> getInvMgmDts(TblIndent_D search, PageInfo pageInfo);
    List<TblDepot_M> getDepotDts();
	List<TblRetailers_M> getRetailersMDts();

	List<GridIndentMgtDts> getIndentMgmDts(GridIndentMgtDts requestData, PageInfo pageInfo);

	List<GridIndentMgtDts> getLastThiryDaysIndentMgmDts();

	List<GridIndentMgtDts> fetchDateWiseStmts(String startDate, String endDate);
	List<GridIndentMgtDts> fetchOldArchives();

	String insertDistFlatFileDts();

	List<TblDepot_M> showDepotName(Request<TblDepot_M> request);

	TblDepot_M fetchDptDtsByDepotName(Request<TblDepot_M> request);

	List<TblProductsM> fetchProductDts();

	CreateIndentMgtDts fetchIndentDtsByUserId(Long userId);

	List<TblDistilleries> getDistilleries(); 
}
