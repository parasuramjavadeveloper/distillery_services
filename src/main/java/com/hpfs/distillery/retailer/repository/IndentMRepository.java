/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import com.hpfs.distillery.retailer.model.TblIndent_M;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author babasaheb
 *
 */
public interface IndentMRepository extends JpaRepository<TblIndent_M,Long> {
}
