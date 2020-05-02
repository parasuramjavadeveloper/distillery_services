/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpfs.distillery.retailer.model.TblDistilleries;

/**
 * @author babasaheb
 *
 */
public interface DistilleryRepository extends JpaRepository<TblDistilleries, Long> {
}
