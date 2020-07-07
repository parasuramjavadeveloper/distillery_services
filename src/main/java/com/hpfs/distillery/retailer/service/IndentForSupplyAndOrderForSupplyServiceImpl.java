package com.hpfs.distillery.retailer.service;

import com.hpfs.distillery.retailer.dto.*;
import com.hpfs.distillery.retailer.model.*;
import com.hpfs.distillery.retailer.repository.*;
import com.hpfs.distillery.retailer.utils.DateUtils;
import com.hpfs.distillery.retailer.utils.DtoToModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class IndentForSupplyAndOrderForSupplyServiceImpl implements IndentForSupplyAndOrderForSupplyService {
	private static AtomicInteger at = new AtomicInteger(0);

	public int getNextCountValue() {
		return at.incrementAndGet();
	}

	@Resource
	TblProductsMRepository tblProductsMRepository;

	@Resource
	IndentForSupplyRepository indentForSupplyRepository;

	@Resource
	IFSRepository iFSRepository;

	@Resource
	IFSProductRepository iFSProductRepository;

	@Resource
	OrderForSupplyRepository orderForSupplyRepository;

	DtoToModel dtoToModel = new DtoToModel();

	@Override
	public List<TblProductsM> fetchProdDtsByProdName(Request<TblProductsM> request) {
		return tblProductsMRepository.fetchByProductNames(request.getRequestData().getProductName().toUpperCase());// TODO
																													// Auto-generated
																													// method
																													// stub
	}

	@Override
	@Transactional
	public TblIndentForSupply saveIFS(IndentForSupplyDts supplyDts) {

		TblIndentForSupply ifs = new TblIndentForSupply();
		ifs.setIndentNo("IFS" + getNextCountValue());
		ifs.setDistilleryId(supplyDts.getDistilleryId());
		ifs.setDepotId(supplyDts.getDepotId());
		ifs.setProductCode(supplyDts.getProductCode());
		ifs.setBrandName(supplyDts.getBrandName());
		ifs.setSize(supplyDts.getSize());
		ifs.setQtyInCases(supplyDts.getQtyInCases());
		ifs.setRatePerCase(supplyDts.getRatePerCase());
		ifs.setTotalAmount(supplyDts.getTotalAmount());
		ifs.setStatus("SUBMITTED");
		ifs.setIndentDate(DateUtils.DateToString());
		ifs.setCreatedBy(supplyDts.getUserId().toString());
		ifs.setCreationDate(DateUtils.DateToString());
		return indentForSupplyRepository.save(ifs);
	}

	@Override
	public IFS saveIndentTypes(IFSDto saveIfsType) throws ParseException, SQLException, IOException {
		IFS ifs = iFSRepository.save(dtoToModel.toIFS(saveIfsType));
		return ifs;
	}

	@Override
	public List<TblIndentForSupply> fetchAllIFS() {
		return indentForSupplyRepository.findAll();
	}

	@Override
	public List<TblIndentForSupply> getTblIndentForSupplyByDistilleryId(Long distillerId) {
		return indentForSupplyRepository.getTblIndentForSupplyByDistilleryId(distillerId);
	}

	@Override
	public TblOrderForSupply orderForSupply(OrderForSupplyDts requestData) {

		TblOrderForSupply ofs = new TblOrderForSupply();
		ofs.setOfsNo("OFS" + getNextCountValue());
		ofs.setOfsRefNo(requestData.getOfsRefNo());
		ofs.setDistilleryId(requestData.getDistilleryId());
		ofs.setDepotId(requestData.getDepotId());
		ofs.setProductCode(requestData.getProductCode());
		ofs.setBrandName(requestData.getBrandName());
		ofs.setSize(requestData.getSize());
		ofs.setRatePerCase(requestData.getRatePerCase());
		ofs.setTotalAmount(requestData.getTotalAmount());
		ofs.setStatus(requestData.getStatus());
		ofs.setApprovedBy(requestData.getApprovedBy());
		ofs.setCreatedBy(requestData.getCreatedBy());
		ofs.setUpdatedBy(requestData.getUpdatedBy());
		ofs.setCreationDate(DateUtils.DateToString());
		return orderForSupplyRepository.save(ofs);
	}

	@Override
	public List<TblOrderForSupply> getOrderForSupplyRecordsByDistilleryId(Long distillerId) {
		return orderForSupplyRepository.getTblOrderForSupplyByDistilleryId(distillerId);
	}

	@Override
	public TblIndentForSupply getSingleIFSByIndentNoAndDistilleryId(String indentNo, Long distillerId) {
		return indentForSupplyRepository.fetchIndentForSupplyByIndentNoAndDistilleryId(indentNo, distillerId);
	}

	@Override
	public TblOrderForSupply getSingleOFSByDistilleryId(Long distillerId) {
		return null;
	}

	@Override
	public TblOrderForSupply getSingleOFSByIndentNoAndDistilleryId(String ofsNo, Long distillerId) {
		return orderForSupplyRepository.fetchOrderForSupplyByOfsNoAndDistilleryId(ofsNo, distillerId);
	}

	@Override
	public List<TblOrderForSupply> fetchAllOFS() {
		return orderForSupplyRepository.findAll();
	}

	@Override
	public List<TblOrderForSupply> getOfsDetails(String ofsNo, Long distillerId, Long depotId) {

		List<TblOrderForSupply> ofsDetails = new ArrayList<TblOrderForSupply>();
		if (ofsNo != null && distillerId == null && depotId == null) {
			Optional<TblOrderForSupply> tblIndentForSupply = orderForSupplyRepository.findById(ofsNo);
			if (tblIndentForSupply.isPresent()) {
				ofsDetails.add(tblIndentForSupply.get());
			}
			return ofsDetails;
		} else if (ofsNo != null && distillerId != null && depotId == null) {

			TblOrderForSupply tblOrderForSupply = orderForSupplyRepository
					.fetchOrderForSupplyByOfsNoAndDistilleryId(ofsNo, distillerId);
			ofsDetails.add(tblOrderForSupply);

			return ofsDetails;
		} else if (ofsNo != null && distillerId != null && depotId != null) {

			ofsDetails = orderForSupplyRepository.fetchOFSByDepoIdAndDisilleryIdAndByOfsNo(ofsNo, depotId, distillerId);

			return ofsDetails;
		} else if (ofsNo != null && distillerId == null && depotId != null) {
			List<TblOrderForSupply> tblOrderForSupply = orderForSupplyRepository
					.fetchOrderForSupplyByOfsNoAndDepoId(ofsNo, depotId);

			return tblOrderForSupply;
		} else if (depotId != null && ofsNo == null && distillerId == null) {

			ofsDetails = orderForSupplyRepository.fetchOFSByDepoId(depotId);

			return ofsDetails;
		} else if (depotId != null && ofsNo == null && distillerId != null) {

			ofsDetails = orderForSupplyRepository.fetchOFSByDepoIdAndDistilleryId(depotId, distillerId);

			return ofsDetails;
		} else if (depotId == null && ofsNo == null && distillerId != null) {

			ofsDetails = orderForSupplyRepository.fetchOFSByDisilleryId(distillerId);

			return ofsDetails;
		}

		return ofsDetails;
	}

	@Override
	public List<TblIndentForSupply> getIfsDetails(String indentNo, Long distillerId, Long depotId) {

		List<TblIndentForSupply> indentForSupplyDetails = new ArrayList<TblIndentForSupply>();
		if (indentNo != null && distillerId == null && depotId == null) {

			Optional<TblIndentForSupply> tblIndentForSupply = indentForSupplyRepository.findById(indentNo);
			if (tblIndentForSupply.isPresent()) {
				indentForSupplyDetails.add(tblIndentForSupply.get());
			}

			return indentForSupplyDetails;
		} else if (indentNo != null && distillerId != null && depotId != null) {

			indentForSupplyDetails = indentForSupplyRepository.fetchIFSByDepoIdAndDisilleryIdAndByOfsNo(indentNo,
					depotId, distillerId);

			return indentForSupplyDetails;
		} else if (indentNo != null && distillerId == null && depotId != null) {
			TblIndentForSupply tblOrderForSupply = indentForSupplyRepository
					.fetchIndentForSupplyByIndentNoAndDepotId(indentNo, depotId);
			indentForSupplyDetails.add(tblOrderForSupply);
			return indentForSupplyDetails;
		} else if (indentNo != null && distillerId != null && depotId == null) {
			TblIndentForSupply tblOrderForSupply = indentForSupplyRepository
					.fetchIndentForSupplyByIndentNoAndDistilleryId(indentNo, distillerId);
			indentForSupplyDetails.add(tblOrderForSupply);
			return indentForSupplyDetails;
		} else if (depotId != null && indentNo == null && distillerId == null) {
			indentForSupplyDetails = indentForSupplyRepository.fetchIFSByDepoId(depotId);
			return indentForSupplyDetails;
		} else if (depotId != null && indentNo == null && distillerId != null) {
			indentForSupplyDetails = indentForSupplyRepository.fetchIFSByDepoIdAndDistilleryId(depotId, distillerId);
			return indentForSupplyDetails;
		} else if (depotId == null && indentNo == null && distillerId != null) {
			indentForSupplyDetails = indentForSupplyRepository.fetchIFSByDisilleryId(distillerId);
			return indentForSupplyDetails;
		}

		return indentForSupplyDetails;
	}

	@Override
	public TblIndentForSupply updateIFS(IndentForSupplyDts requestData) {
		
		Optional<TblIndentForSupply> TblIndentForSupply = indentForSupplyRepository.findById(requestData.getIndentNo()); 
		TblIndentForSupply tblIndentForSupply = null; 
		if(TblIndentForSupply.isPresent()) {
			tblIndentForSupply  = TblIndentForSupply.get();
			tblIndentForSupply.setBrandName(requestData.getBrandName()); 
			tblIndentForSupply.setDepotId(requestData.getDepotId());
			tblIndentForSupply.setDistilleryId(requestData.getDistilleryId());
			tblIndentForSupply.setProductCode(requestData.getProductCode());
			tblIndentForSupply.setQtyInCases(requestData.getQtyInCases()); 
			tblIndentForSupply.setSize(requestData.getSize()); 
			tblIndentForSupply.setCreatedBy(requestData.getCreatedBy());
			tblIndentForSupply.setCreationDate(requestData.getCreationDate());
			tblIndentForSupply.setUpdatedBy(requestData.getUpdatedBy());
			tblIndentForSupply.setUpdatedDate(requestData.getUpdatedDate());
			tblIndentForSupply.setRatePerCase(requestData.getRatePerCase());
			tblIndentForSupply.setStatus(requestData.getStatus());
			tblIndentForSupply.setTotalAmount(requestData.getTotalAmount());
			tblIndentForSupply.setIndentDate(requestData.getIndentDate());
			}
		
		  tblIndentForSupply = indentForSupplyRepository.save(tblIndentForSupply);
		return tblIndentForSupply;
	}

	@Override
	public Boolean deleteIFSByIndentNo(String indentNo) {



		Optional<TblIndentForSupply> ifsOptionalObj = indentForSupplyRepository.findById(indentNo);
		
		if(ifsOptionalObj.isPresent()) {
			TblIndentForSupply ifsObj = ifsOptionalObj.get();
			
			indentForSupplyRepository.delete(ifsObj); 
		}
		
		Optional<TblIndentForSupply> ifsOptionalObjExists = indentForSupplyRepository.findById(indentNo);
		
		if(!ifsOptionalObjExists.isPresent()) {
					
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean deleteIFS(String ifsNo) {

		IFS ifs = getIFSByIFSNo(ifsNo);
		iFSRepository.delete(ifs);

		return true;
	}

	@Override
	public List<IFS> getAllIFS() {
		return iFSRepository.findAll();
	}

    @Override
    public IFS getIFSByIFSNo(String ifsNo) {
		IFS ifs = iFSRepository.getOne(ifsNo);
        return ifs;
    }

	@Override
	public IFSDto updateIFSTypes(IFSDto requestData) throws ParseException {
        IFS ifs = buildIFs(requestData);
		return null;
	}

	@Override
	public IFSProductsDto getPrdctByIfsPid(final Integer ifsPid) {

		IFSProducts iFSProduct = iFSProductRepository.getOne(ifsPid);
		IFSProductsDto iFSProductsDto= new IFSProductsDto();
		iFSProductsDto.setIndentDate(DateUtils.getDateAsString(iFSProduct.getIndentDate()));
		iFSProductsDto.setCreationDate(DateUtils.getDateAsString(iFSProduct.getCreationDate()));
		iFSProductsDto.setUpdatedDate(DateUtils.getDateAsString(iFSProduct.getUpdatedDate()));
		String[] excludedProperties = {"indentDate","creationDate","updatedDate"};
		BeanUtils.copyProperties(iFSProduct, iFSProductsDto, excludedProperties);
		return  iFSProductsDto;
	}

	@Override
	public String updateIFSProduct(final IFSProductsDto iFSProductsDto) throws ParseException {
		final Integer pk = iFSProductsDto.getIfsPid();
		String message = null;
		IFSProducts iFSProduct = iFSProductRepository.getOne(pk);
		if (iFSProduct != null) {
			iFSProduct.setIndentDate(DateUtils.getDateFromString(iFSProductsDto.getIndentDate()));
			iFSProduct.setCreationDate(DateUtils.getDateFromString(iFSProductsDto.getCreationDate()));
			iFSProduct.setUpdatedDate(DateUtils.getDateFromString(iFSProductsDto.getUpdatedDate()));
			String[] excludedProperties = {"indentDate","creationDate","updatedDate","ifsNum"};
			BeanUtils.copyProperties(iFSProductsDto, iFSProduct, excludedProperties);
			iFSProduct = iFSProductRepository.save(iFSProduct);
			if(iFSProduct!=null){
				message= "IFSProduct Updated Successfully";
			}else{
				message= "IFSProduct Not Updated Successfully";
			}
		}
		return message;
	}

	@Override
	public String deleteIfsProduct(Integer ifsPid) {
		IFSProducts iFSProduct = iFSProductRepository.getOne(ifsPid);
		if (iFSProduct != null) {
			iFSProductRepository.delete(iFSProduct);
			return "SUCCESS";
		}
		return "FAILURE";
	}

	private IFS buildIFs(IFSDto ifsDto) throws ParseException {
		IFS ifs = getIFSByIFSNo(ifsDto.getIfsNo());
		ifs.setIndentDate(DateUtils.getDateFromString(ifsDto.getIndentDate()));
		ifs.setCreationDate(DateUtils.getDateFromString(ifsDto.getCreationDate()));
		ifs.setUpdatedDate(DateUtils.getDateFromString(ifsDto.getUpdatedDate()));
		String[] excludedProperties = {"indentDate","creationDate","updatedDate"};
		BeanUtils.copyProperties(ifsDto, ifs, excludedProperties);
		return iFSRepository.save(ifs);
	}

}
