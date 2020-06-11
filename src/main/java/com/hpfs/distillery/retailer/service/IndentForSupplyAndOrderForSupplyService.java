/**
 * 
 */
package com.hpfs.distillery.retailer.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.hpfs.distillery.retailer.dto.*;
import com.hpfs.distillery.retailer.model.*;


/**
 * @author cnk's
 *
 */
public interface IndentForSupplyAndOrderForSupplyService {

	List<TblProductsM> fetchProdDtsByProdName(Request<TblProductsM> request);

	TblIndentForSupply saveIFS(IndentForSupplyDts ifs);

	IFS saveIndentTypes(IFSDto saveIfsType) throws ParseException, SQLException, IOException;

	List<TblIndentForSupply> fetchAllIFS();

	List<TblIndentForSupply> getTblIndentForSupplyByDistilleryId(Long distillerId);

	TblOrderForSupply orderForSupply(OrderForSupplyDts requestData);

	List<TblOrderForSupply> getOrderForSupplyRecordsByDistilleryId(Long distillerId);  
	
	TblIndentForSupply getSingleIFSByIndentNoAndDistilleryId(String indentNo,Long distillerId); 
	
	TblOrderForSupply getSingleOFSByDistilleryId(Long distillerId);

	TblOrderForSupply getSingleOFSByIndentNoAndDistilleryId(String ofsNo, Long distillerId);

	List<TblOrderForSupply> fetchAllOFS();

	List<TblOrderForSupply> getOfsDetails(String ofsId, Long distillerId, Long depotId);

	List<TblIndentForSupply> getIfsDetails(String ofsId, Long distillerId, Long depotId);

	TblIndentForSupply updateIFS(IndentForSupplyDts requestData);

	Boolean deleteIFSByIndentNo(String indentNo);

	Boolean deleteIFS(String ifsNo);
    List<IFS> getAllIFS();

	IFS getIFSByIFSNo(String ifsNo);

	IFSDto updateIFSTypes(IFSDto requestData) throws ParseException;

	IFSProductsDto getPrdctByIfsPid(Integer ifsPid);

	String updateIFSProduct(IFSProductsDto iFSProductsDto) throws ParseException;

	String deleteIfsProduct(Integer ifsPid);
}
