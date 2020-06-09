/**
 * 
 */
package com.hpfs.distillery.retailer.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.hpfs.distillery.retailer.dto.IFSDto;
import com.hpfs.distillery.retailer.dto.IndentForSupplyDts;
import com.hpfs.distillery.retailer.dto.OrderForSupplyDts;
import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.model.IFS;
import com.hpfs.distillery.retailer.model.TblIndentForSupply;
import com.hpfs.distillery.retailer.model.TblOrderForSupply;
import com.hpfs.distillery.retailer.model.TblProductsM;


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
}
