package com.hpfs.distillery.retailer.service;

import java.util.List;

import com.hpfs.distillery.retailer.model.TblDistiInvM;
import com.hpfs.distillery.retailer.model.TblVehicleM;

public interface DistilleryService {

	List<TblVehicleM> fetchActiveVehDts();

	TblDistiInvM scanCaseBarNo(TblDistiInvM search);

}
