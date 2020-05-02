package com.hpfs.distillery.retailer.service;

import com.hpfs.distillery.retailer.model.ProductionLineDetails;
import com.hpfs.distillery.retailer.model.TblLineInfo;
import com.hpfs.distillery.retailer.repository.ProductionLineInfoRepository;
import com.hpfs.distillery.retailer.repository.TblLineInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class LineInfoServiceImpl implements LineInfoService {

    @Resource
    private TblLineInfoRepository tblLineInfoRepository;
    @Resource
    private ProductionLineInfoRepository productionLineInfoRepository;

    @Override
    public List<TblLineInfo> fetchLineData() {
        return tblLineInfoRepository.findAll();
    }

    @Override
    public ProductionLineDetails saveProductLine(ProductionLineDetails productionLineDetails) {
        Date date=new Date();
       Timestamp ts=new Timestamp(date.getTime());
        productionLineDetails.setCreationDate(ts);
        return productionLineInfoRepository.saveAndFlush(productionLineDetails);
    }


}
