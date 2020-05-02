package com.hpfs.distillery.retailer.repository;

import com.hpfs.distillery.retailer.model.ProductionLineDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionLineInfoRepository extends JpaRepository<ProductionLineDetails,Long>{



}
