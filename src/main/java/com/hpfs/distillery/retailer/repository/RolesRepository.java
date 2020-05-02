/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpfs.distillery.retailer.model.TblUsers;

/**
 * @author babasaheb
 *
 */
public interface RolesRepository extends JpaRepository<TblUsers,Long> {
}
