package com.hpfs.distillery.retailer.service;

import com.hpfs.distillery.retailer.model.TblExciseDuty;
import com.hpfs.distillery.retailer.repository.ExciseDutyRepository;
import com.hpfs.distillery.retailer.utils.UTIL;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ExciseDutyServiceImpl implements ExciseDutyService {

    @Resource
    private ExciseDutyRepository exciseDutyRepository;

    private EntityManager entityManager;

    @Override
    public List<TblExciseDuty> fetchExciseData(String challanType) {


        List<TblExciseDuty> ted=null;

         if (null !=challanType && challanType.length()>0)
             ted =exciseDutyRepository.fetchwithParams(challanType);
         else
             ted =exciseDutyRepository.findAll();

         if (ted!=null && ted.size()>0)
         {
             for (TblExciseDuty t:ted)
             {
               t.setChallanDate(UTIL.timestampToString(t.getDbChallaDate()));
             }
         }
         return ted;
    }



    @Override
    @Transactional
    public String saveExciseData(TblExciseDuty requestData) {
        String msg = "FAILURE";
        if(requestData!=null) {

            requestData.setCreationDate(new Timestamp(System.currentTimeMillis()));
            requestData.setDbChallaDate(UTIL.stringToTimestamp(requestData.getChallanDate()));

//        TblExciseDuty exciseDuty = new TblExciseDuty();
//
//        System.out.println(requestData+"requestData");
//        exciseDuty.setDateAndTime(requestData.getDateAndTime());
//        exciseDuty.setChallnOrTransNumber(requestData.getChallnOrTransNumber());
//        exciseDuty.setBalance(requestData.getBalance());
//        exciseDuty.setChallanOrTransDate(requestData.getChallanOrTransDate());
//        exciseDuty.setDebit(requestData.getDebit());
//        exciseDuty.setCredit(requestData.getCredit());
//        exciseDuty.setTransactionType(requestData.getTransactionType());
//        exciseDuty.setOpeningBal(requestData.getOpeningBal());
//        exciseDuty.setDescription(DateFormatUtils.DateToString());
//        exciseDuty.setBankName(requestData.getBankName());
            TblExciseDuty orderDts = exciseDutyRepository.save(requestData);
            if (orderDts != null) {
                msg = "SUCCESSFULLY SAVED";
            } else {
                msg = "FAILURE";
            }
        }
        return msg;
    }



	@Override
	public List<TblExciseDuty> fetchDateWiseStmts(String startDate, String endDate) {
		return exciseDutyRepository.fetchDateWiseStmts(startDate,endDate);
	}


	@Override
	public List<String> fetchChallanTypeList() {
		return exciseDutyRepository.fetchChallanTypeList();
	}

	

}


