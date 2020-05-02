/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpfs.distillery.retailer.model.TblRoleMapping;

/**
 * @author babasaheb
 *
 */
public interface StockRepository extends JpaRepository<TblRoleMapping,Long> {
}
