package com.hpfs.distillery.retailer.repository;

import com.hpfs.distillery.retailer.model.TblOrderForSupply;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hpfs.distillery.retailer.model.ShipmentHeader;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShipmentHeaderRepository extends JpaRepository<ShipmentHeader, String> {

    String getTPR = "SELECT * FROM shipment_hdr i WHERE i.shipment_hdr_id = ?1";
    @Query(value = getTPR, nativeQuery = true)
    ShipmentHeader fetchTPR(@Param("tprId") String tprId);

}
