package com.hpfs.distillery.retailer.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.hpfs.distillery.retailer.model.*;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hpfs.distillery.retailer.dto.IndentCreationDto;
import com.hpfs.distillery.retailer.dto.PageInfo;
import com.hpfs.distillery.retailer.dto.Request;
import com.hpfs.distillery.retailer.dto.TblDistilleryInvMDto;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.repository.CreateDistiInvMRepository;
import com.hpfs.distillery.retailer.repository.DepotMRepository;
import com.hpfs.distillery.retailer.repository.DistiInvDRepository;
import com.hpfs.distillery.retailer.repository.DistiInvMRepository;
import com.hpfs.distillery.retailer.repository.DistilleryInvMRepository;
import com.hpfs.distillery.retailer.repository.DistilleryRepository;
import com.hpfs.distillery.retailer.repository.GridIndentMgtDtsRepository;
import com.hpfs.distillery.retailer.repository.IndentDRepository;
import com.hpfs.distillery.retailer.repository.IndentMRepository;
import com.hpfs.distillery.retailer.repository.RetailersMRepository;
import com.hpfs.distillery.retailer.repository.TblProductsMRepository;
import com.hpfs.distillery.retailer.utils.ApplicationConstants;
import com.hpfs.distillery.retailer.utils.DateUtils;
import com.hpfs.distillery.retailer.utils.DtoToModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IndentMgmServiceImpl implements IndentMgmService {

	@Resource
	DistilleryInvMRepository distilleryInvMRepository;

	@Resource
	IndentMRepository indentMRepository;

	@Resource
	DepotMRepository depotMRepository;
	
	@Resource
	DistilleryRepository distilleryRepository;

	@Resource
	RetailersMRepository retailersMRepository;

	@Resource
	IndentDRepository indentDRepository;

	@Resource
	GridIndentMgtDtsRepository gridIndentMgtDtsRepository;

	@Resource
	DistiInvMRepository distiInvMRepository;

	@Resource
	DistiInvDRepository distiInvDRepository;

	@Resource
	CreateDistiInvMRepository createDistiInvMRepository;

	@Resource
	TblProductsMRepository tblProductsMRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;

	DtoToModel dtoToModel = new DtoToModel();

	ModelMapper modelMapper = new ModelMapper();

	@Value("${csv.disti.loc}")
	private String loc;

	public static final Logger logger = LoggerFactory.getLogger(IndentMgmServiceImpl.class);

	@Override
	public List<TblDistilleryInvMDto> findAllTblDistillery() {
		List<TblDistilleryInvM> list = new ArrayList<>();
		List<TblDistilleryInvMDto> dtolist = new ArrayList<>();
		list = distilleryInvMRepository.findAll();
		if (null != list) {
			dtolist = list.stream().map(entity -> modelMapper.map(entity, TblDistilleryInvMDto.class))
					.collect(Collectors.toList());
		}
		return dtolist;
	}

	@Override
	public List<TblDistilleryInvMDto> getDistelleryInvMgmDts(TblDistilleryInvMDto search, PageInfo pageInfo) {
		Page<TblDistilleryInvM> pageList = null;
		List<TblDistilleryInvMDto> dtoList = null;
		if (search == null) {
			pageList = distilleryInvMRepository.fetchAllInvMgmDts(
					PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize(), new Sort(pageInfo.getSortBy())));
			// ,new Sort(Sort.DEFAULT_DIRECTION,pageInfo.getSortBy())
		}
		if (Objects.nonNull(pageList)) {
			List<TblDistilleryInvM> reportList = pageList.getContent();
			dtoList = reportList.stream().map(entity -> modelMapper.map(entity, TblDistilleryInvMDto.class))
					.collect(Collectors.toList());
			pageInfo.setTotalElements(pageList.getTotalElements());
			pageInfo.setTotalPages(pageList.getTotalPages());
		}
		return dtoList;
	}

	@Override
	@Transactional
	public TblIndent_M saveIndentDts(IndentCreationDto requestData, UserDetails us) {
		TblIndent_M tblIndentMDts = null;
		// TblIndent_D tblIndentDDts = null;
		if (null != requestData) {
			tblIndentMDts = dtoToModel.toTblIndentM(requestData, us);
			tblIndentMDts = indentMRepository.save(tblIndentMDts);
			List<TblIndent_D> list = dtoToModel.toTblIndentD(requestData, us);
			if (tblIndentMDts.getIndentId() != 0) {
				if (null != list && list.size() > 0) {
					List<TblIndent_D> returnList = new ArrayList<>();
					for (TblIndent_D tblIndentDDts : list) {
						tblIndentDDts.setIndentId(tblIndentMDts.getIndentId());
						tblIndentDDts = indentDRepository.save(tblIndentDDts);
						returnList.add(tblIndentDDts);

					}
					if (null != returnList && returnList.size() == list.size()) {
						return tblIndentMDts;
					}
				} else {
					return tblIndentMDts;
				}
				sendEmail("durgaprasad.java2013@gmail.com");
			}
		}
		return tblIndentMDts;
	}

	@Override
	public List<GridIndentMgtDts> getIndentMgmDts(GridIndentMgtDts search, PageInfo pageInfo) {
		Page<GridIndentMgtDts> pageList = null;
		List<GridIndentMgtDts> gridList = null;
		if (null != search) {
			pageList = gridIndentMgtDtsRepository.fetchIndentMgmDtsBy(search.getShopName(), search.getDepotName(),
					search.getDepotId(), search.getLocation(), search.getDistrict(), search.getIndentCreationDate(),
					search.getAuthorisedPerson(),
					PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize(), new Sort(pageInfo.getSortBy())));
		} else {
			pageList = gridIndentMgtDtsRepository.fetchAllIndentMgmDts(
					PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize(), new Sort(pageInfo.getSortBy())));
		}
		if (Objects.nonNull(pageList)) {
			List<GridIndentMgtDts> reportList = pageList.getContent();
			gridList = reportList.stream().map(entity -> modelMapper.map(entity, GridIndentMgtDts.class))
					.collect(Collectors.toList());
			pageInfo.setTotalElements(pageList.getTotalElements());
			pageInfo.setTotalPages(pageList.getTotalPages());
		}
		return gridList;
	}

	@Override
	public List<TblIndent_D> getInvMgmDts(TblIndent_D search, PageInfo pageInfo) {
		Page<TblIndent_D> pageList = null;
		List<TblIndent_D> gridList = null;
		if (null != search) {
			pageList = indentDRepository.fetchInvMgmDtsBy(search.getProductCode(), search.getBarCode(),
					search.getIndentId(), search.getTotalPrice(),
					PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize(), new Sort(pageInfo.getSortBy())));
		} else {
			pageList = indentDRepository.fetchAllInvMgmDts(
					PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize(), new Sort(pageInfo.getSortBy())));
		}
		if (Objects.nonNull(pageList)) {
			gridList = pageList.getContent();
			pageInfo.setTotalElements(pageList.getTotalElements());
			pageInfo.setTotalPages(pageList.getTotalPages());
		}
		return gridList;
	}

	@Override
	public List<TblDepot_M> getDepotDts() {
		return depotMRepository.findAll();
	}

	@Override
	public List<DepotNames> getDepots() {
		List<TblDepot_M> depos= depotMRepository.findAll();
		List<DepotNames> deposList = new ArrayList<>();
		depos.forEach(tblDepot_m -> {
			DepotNames depotNames = new DepotNames();
			depotNames.setDepotId(tblDepot_m.getDepotId());
			depotNames.setDepotName(tblDepot_m.getDepotName());
			deposList.add(depotNames);
		});
		return deposList;
	}

	@Override
	public List<TblRetailers_M> getRetailersMDts() {
		return retailersMRepository.findAll();
	}

	@Override
	public CreateIndentMgtDts fetchIndentDtsByUserId(Long userId) {
		return createDistiInvMRepository.fetchIndentDtsByUserId(userId);
	}

	@Override
	public List<GridIndentMgtDts> getLastThiryDaysIndentMgmDts() {
		System.out.println("lastThiry Days" + DateUtils.LastThirtyDaysDateToString());
		return gridIndentMgtDtsRepository.fetchLast30DaysGridIndDts(DateUtils.LastThirtyDaysDateToString());
	}

	@Override
	public List<GridIndentMgtDts> fetchDateWiseStmts(String startDate, String endDate) {
		System.out.println("fetchDateWiseStmts Days" + "'" + startDate + "'" + "'" + endDate + "'");
		return gridIndentMgtDtsRepository.fetchDateWiseStmts(startDate, endDate);
	}

	@Override
	public List<GridIndentMgtDts> fetchOldArchives() {
		return gridIndentMgtDtsRepository.fetchOldArchives();
	}

	@Override
	@Transactional
	public String insertDistFlatFileDts() {
		String msg = "";
		List<List<String>> records = new ArrayList<>();
		List<TblDistiInvM> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(loc))) {
			String line;
			int lineCount = 0;
			int count = 0;
			Long inventoryId = 0l;
			while ((line = br.readLine()) != null) {
				String lineDt = line;
				if (lineDt.trim().length() == 32) {
					System.out.println("IF --" + lineDt);
					lineCount++;
					TblDistiInvM distInvM = new TblDistiInvM();
					distInvM.setCaseBarNo(lineDt.trim());
					distInvM.setCountryCode(Long.valueOf(line.substring(0, 3)));
					distInvM.setSupplierCode(Long.valueOf(line.substring(3, 7)));
					distInvM.setProductCode(line.substring(3, 7));
					distInvM.setSegment(line.substring(7, 12));
					distInvM.setPackType(line.substring(12, 13));
					distInvM.setSize(line.substring(13, 15));
					distInvM.setBatchNo(line.substring(15, 19));
					distInvM.setMfgDate(line.substring(19, 25));
					distInvM.setLineId(Long.valueOf(line.substring(25, 27)));
					distInvM.setCaseSequenceNum(Long.valueOf(line.substring(27, 32)));
					distInvM.setCreationDate(DateUtils.DateToString());
					distInvM.setCreatedBy("Babasaheb");
					System.out.println(
							"CountryCode:" + distInvM.getCountryCode() + "-SupplierCode:" + distInvM.getSupplierCode());
					System.out.println("Segment:" + distInvM.getSegment() + "-Packtype:" + distInvM.getPackType());
					System.out.println("Size:" + distInvM.getSize() + "-BatchNo:" + distInvM.getBatchNo());
					System.out.println("MfgDate:" + distInvM.getMfgDate() + "-LineId" + distInvM.getLineId());
					System.out.println("case Seq Num:" + distInvM.getCaseSequenceNum());
					TblDistiInvM distInvMDts = distiInvMRepository.save(distInvM);
					if (distInvMDts != null && distInvMDts.getInventoryId() != 0) {
						inventoryId = distInvMDts.getInventoryId();
						System.out.println(inventoryId + "saved Inventory Id:" + distInvMDts.getInventoryId());
						count++;
					}
				} else if (lineDt.trim().length() == 17 && inventoryId != 0) {
					System.out.println("else --" + lineDt);
					lineCount++;
					TblDistiInvD distInvD = new TblDistiInvD();
					distInvD.setCreationDate(DateUtils.DateToString());
					distInvD.setInventoryId(inventoryId);
					distInvD.setHealNumber(Long.valueOf(lineDt.trim()));
					TblDistiInvD distInvDDts = distiInvDRepository.save(distInvD);
					if (distInvDDts != null && distInvDDts.getInventoryDetId() != 0) {
						count++;
					}
				}
			}
			if (lineCount == count) {
				return msg = "SUCCESS";
			} else {
				return msg = "FAILURE";
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<TblDepot_M> showDepotName(Request<TblDepot_M> request) {
		List<TblDepot_M> depotNamesList = null;
		if (null != request) {
			depotNamesList = depotMRepository.fetchByDepotNames(request.getRequestData().getDepotName().toUpperCase());
		}
		// TODO Auto-generated method stub
		return depotNamesList;
	}

	@Override
	public TblDepot_M fetchDptDtsByDepotName(Request<TblDepot_M> request) {
		return depotMRepository.findByDepotNameAndStatus(request.getRequestData().getDepotName().toUpperCase(),
				ApplicationConstants.ACTIVE);// TODO Auto-generated method stub

	}

	@Override
	public List<TblProductsM> fetchProductDts() {
		return tblProductsMRepository.findAllProductsByStatus(ApplicationConstants.ACTIVE_STATUS);
	}

	void sendEmail(String to) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);

		msg.setSubject("Indent Creation!");
		msg.setText("Indent Created Successfully!");

		javaMailSender.send(msg);

	}

	@Override
	public List<TblDistilleries> getDistilleries() {
		return distilleryRepository.findAll();
	}

	@Override
	public List<DistilleryNames> getDistilleryNames() {
		List<TblDistilleries>  distilleryUnits= distilleryRepository.findAll();
		List<DistilleryNames>  distilleryNamesList = new ArrayList<>();
		distilleryUnits.forEach(distillery -> {
			DistilleryNames distilleryName = new DistilleryNames();
			distilleryName.setId(distillery.getDestilleryId());
			distilleryName.setName(distillery.getDestilleryName());
			distilleryNamesList.add(distilleryName);
		});
		return distilleryNamesList;
	}

}
