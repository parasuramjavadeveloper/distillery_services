package com.hpfs.distillery.retailer.model;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class TPGenerator implements IdentifierGenerator {

    public static final String generatorName = "myGenerator";
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {


     StringBuffer tp = new StringBuffer("TP");
     String randomNum = UUID.randomUUID().toString().replace("-", "");
        tp.append(randomNum).append("").toString();

        return tp;
    }
}
