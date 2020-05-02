/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpfs.distillery.retailer.model.TblBarcodeM;

/**
 * @author babasaheb
 *
 */
public interface TblBarcodeMRepository extends JpaRepository<TblBarcodeM,Long> {
	
	TblBarcodeM findByBarcodeNumber(String barcodeNumber);
	
}
