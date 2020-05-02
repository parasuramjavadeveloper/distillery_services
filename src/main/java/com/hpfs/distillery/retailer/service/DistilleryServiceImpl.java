package com.hpfs.distillery.retailer.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hpfs.distillery.retailer.model.TblDistiInvM;
import com.hpfs.distillery.retailer.model.TblVehicleM;
import com.hpfs.distillery.retailer.repository.DistiInvMRepository;
import com.hpfs.distillery.retailer.repository.TblVehicleMRepository;
import com.hpfs.distillery.retailer.utils.ApplicationConstants;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class DistilleryServiceImpl implements DistilleryService {

	@Resource
	TblVehicleMRepository tblVehicleMRepository;
	
	@Resource
	DistiInvMRepository distiInvMRepository;

	@Override
	public List<TblVehicleM> fetchActiveVehDts() {
		return tblVehicleMRepository.findAllByStatus(ApplicationConstants.ACTIVE_STATUS);
	}

	@Override
	public TblDistiInvM scanCaseBarNo(TblDistiInvM search) {
		if(search!= null && search.getCaseBarNo()!=null && search.getCaseBarNo()!="") {
			return distiInvMRepository.findByCaseBarNo(search.getCaseBarNo());
		}
		return null;
	}

}
