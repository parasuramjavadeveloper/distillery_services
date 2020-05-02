package com.hpfs.distillery.retailer.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hpfs.distillery.retailer.dto.GRNTransactionDto;
import com.hpfs.distillery.retailer.dto.ProcessFeeDto;
import com.hpfs.distillery.retailer.model.TblSupplierTransaction;
import com.hpfs.distillery.retailer.repository.SupplierTransactionRepository;
import com.hpfs.distillery.retailer.utils.DtoToModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SupplierTransactionServiceImpl implements SupplierTransactionService {

	@Resource
	SupplierTransactionRepository supplierTransactionRepository;

	DtoToModel dtoToModel = new DtoToModel();

	ModelMapper modelMapper = new ModelMapper();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

	@Override
	public List<TblSupplierTransaction> getAllTxns(String fromDate, String toDate, String processDate, String supplier,
			Pageable pageRequest) {
		Date fd = null;
		Date td = null;
		Date pdFrom = null;
		Date pdTo = null;
		List<TblSupplierTransaction> suplist = null;
		try {
			if (fromDate != null) {
				fd = sdf.parse(fromDate + " 00:00:00");
			}
			if (toDate != null) {
				td = sdf.parse(toDate + " 23:59:59");
			}
			if (processDate != null) {
				pdFrom = formatter.parse(processDate + " 00:00:00");
				pdTo = formatter.parse(processDate + " 23:59:59");
			}
			suplist = supplierTransactionRepository.findBySupplierName(fd, td, pdFrom, pdTo, supplier);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("List..." + suplist.size());

		return suplist;
	}

	@Override
	public List<TblSupplierTransaction> getRollbackTxns(String processDate, String suppliername, Pageable pageRequest) {
		Date pd1 = null;
		Date pd2 = null;
		List<TblSupplierTransaction> suplist = null;
		try {

			if (processDate != null) {
				pd1 = sdf.parse(processDate+" 00:00:00");
				pd2 = sdf.parse(processDate+" 23:59:59");
			}
			suplist = supplierTransactionRepository.findByProcessDateandSupplierName(pd1, pd2, suppliername);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suplist;
	}
	
	@Override
	public List<GRNTransactionDto> getGRNTxns(String fromDate, String toDate, String supplier,
			Pageable pageRequest) {
		Date fd = null;
		Date td = null;
		List<TblSupplierTransaction> suplist = null;
		List<GRNTransactionDto> grnList = new ArrayList<GRNTransactionDto>();
		try {
			if (fromDate != null) {
				fd = sdf.parse(fromDate+" 00:00:00");
			}
			if (toDate != null) {
				td = sdf.parse(toDate+" 23:59:59");
			}

			 suplist = supplierTransactionRepository.findByGRNTxns(fd, td, supplier);
			 if(suplist != null && !suplist.isEmpty()) {
				 suplist.forEach(grn -> {
					 GRNTransactionDto grnDto = new GRNTransactionDto();
					 grnDto.setId(grn.getId());
					 grnDto.setGrnNo(grn.getGrnNo());
					 grnDto.setGrnProcessFee(grn.getGrnProcessFee());
					 grnDto.setSupplierName(grn.getSupplierName());
					 grnDto.setSupplierNo(grn.getSupplierNo());
					 grnList.add(grnDto);
				 });
				 
			 }
			 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return grnList;
	}
	
	@Override
	public List<TblSupplierTransaction> getMISPaymentTxns(String fromDate, String toDate, String supplier, String status, Pageable pageRequest)
	{
		Date fd = null;
		Date td = null;
		List<TblSupplierTransaction> missuplist = null;
		try {
			if (fromDate != null) {
				fd = sdf.parse(fromDate+" 00:00:00");
			}
			if (toDate != null) {
				td = sdf.parse(toDate+" 23:59:59");
			}

			missuplist = supplierTransactionRepository.findByMISPaymentTxns(fd, td, status, supplier);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return missuplist;
	}
	
	@Override
	public List<TblSupplierTransaction> getGRNPaymentTxns(String fromDate, String toDate, String supplier, Pageable pageRequest)
	{
		Date fd = null;
		Date td = null;
		List<TblSupplierTransaction> missuplist = null;
		try {
			if (fromDate != null) {
				fd = sdf.parse(fromDate+" 00:00:00");
			}
			if (toDate != null) {
				td = sdf.parse(toDate+" 23:59:59");
			}

			missuplist = supplierTransactionRepository.findByGRNPaymentTxns(fd, td, supplier);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return missuplist;
	}
	
	@Override
	public List<ProcessFeeDto> getProcessFeeTxns(String fromDate, String toDate, Pageable pageRequest)
	{
		Date fd = null;
		Date td = null;
		List<TblSupplierTransaction> missuplist = null;
		List<ProcessFeeDto> processFeeList = new ArrayList<ProcessFeeDto>();
		try {
			if (fromDate != null) {
				fd = sdf.parse(fromDate+" 00:00:00");
			}
			if (toDate != null) {
				td = sdf.parse(toDate+" 23:59:59");
			}

			missuplist = supplierTransactionRepository.findByProcessFeeTxns(fd, td);
			 if(missuplist != null && !missuplist.isEmpty()) {
				 missuplist.forEach(pf -> {
					 ProcessFeeDto dto = new ProcessFeeDto();
					 dto.setId(pf.getId());
					 dto.setGrnNo(pf.getGrnNo());
					 dto.setGrnProcessFee(pf.getGrnProcessFee());
					 dto.setSupplierName(pf.getSupplierName());
					 dto.setSupplierNo(pf.getSupplierNo());
					 dto.setProcessFee(pf.getProcessFee());
					 dto.setPaymentClaimProcessFee(pf.getPaymentClaimProcessFee());
					 processFeeList.add(dto);
				 });
				 
			 }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return processFeeList;
	}
	
	
}
