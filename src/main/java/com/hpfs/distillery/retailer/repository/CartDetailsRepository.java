
package com.hpfs.distillery.retailer.repository;
import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.TblCartDetails;
import com.hpfs.distillery.retailer.model.TblIndent_D;
import com.hpfs.distillery.retailer.model.TblRetailerPaymentDetails;

	/**
	 * @author Vamsi Alla
	 *
	 */
	public interface CartDetailsRepository extends JpaRepository<TblCartDetails,Long> {
		
	}
	