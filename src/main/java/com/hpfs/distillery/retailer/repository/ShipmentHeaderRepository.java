package com.hpfs.distillery.retailer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpfs.distillery.retailer.model.ShipmentHeader;

public interface ShipmentHeaderRepository extends JpaRepository<ShipmentHeader, Long> {

}
