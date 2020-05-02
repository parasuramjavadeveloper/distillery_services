package com.hpfs.distillery.retailer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpfs.distillery.retailer.model.LabInformation;


public interface LabInformationRepository extends JpaRepository<LabInformation, Long> { 

	LabInformation findByLabInformationId(int labInformationId);
}
