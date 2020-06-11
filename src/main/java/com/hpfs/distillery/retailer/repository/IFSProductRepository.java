/**
 *
 */
package com.hpfs.distillery.retailer.repository;

import com.hpfs.distillery.retailer.model.IFSProducts;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ram
 *
 */
public interface IFSProductRepository extends JpaRepository<IFSProducts,Integer> {


}
