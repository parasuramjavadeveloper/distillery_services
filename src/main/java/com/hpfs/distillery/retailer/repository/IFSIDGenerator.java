package com.hpfs.distillery.retailer.repository;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class IFSIDGenerator implements IdentifierGenerator {

    public static final String generatorName = "myGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {
        StringBuffer tprNo = new StringBuffer("IFS");
        tprNo.append(UUID.randomUUID().toString().replace("-", "").substring(0,12));
        return tprNo.toString();
    }
}
