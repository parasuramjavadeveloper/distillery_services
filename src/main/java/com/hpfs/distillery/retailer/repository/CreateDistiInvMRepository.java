/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.CreateIndentMgtDts;

/**
 * @author babasaheb
 *
 */
public interface CreateDistiInvMRepository extends JpaRepository<CreateIndentMgtDts,Long> {
	
	String FETCH_INDENT_DTS="SELECT m.retailer_code,m.shop_name,d.depot_id,d.depot_name,d.location,d.district,m.owner,v.contact_number,v.vehicle_num FROM "+SCHEMA+"retailers_m  m " + 
			"INNER JOIN "+SCHEMA+"depot_m d ON m.depot_id = d.depot_id " + 
			"LEFT JOIN "+SCHEMA+"vehicle_m v on v.vehicle_num = m.vehicle_num " + 
			"WHERE m.user_id=?1";
	
	@Query(value= FETCH_INDENT_DTS,nativeQuery=true)
	CreateIndentMgtDts fetchIndentDtsByUserId(Long userId);
}
