
package com.hpfs.distillery.retailer.repository;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hpfs.distillery.retailer.model.TblDepot_M;
import com.hpfs.distillery.retailer.model.TblHologramDetails;

/**
 * @author Vamsi Alla
 *
 */

public interface HologramDetailsRepository extends JpaRepository<TblHologramDetails, Long> {

	String HOLOGRAM_DTS_FROM = "FROM " + SCHEMA + "heal_purchase_indent dm";

	String HOLOGRAM_DTS_MAINQUERY = "SELECT dm.indent_num," + "               dm.challan_num,\n"
			+ "               dm.challan_amount,\n" + "               dm.challan_date,\n"
			+ "               dm.carrier_name,\n" + "               dm.quantity,\n" + "               dm.purpose,\n"
			+ "               dm.sto_bank, \n" + "               dm.status,\n" + "               dm.creation_date,\n"
			+ "               dm.created_by,\n" + "               dm.updated_date,\n"
			+ "               dm.updated_by \n" + HOLOGRAM_DTS_FROM;
	String HOLOGRAM_DTS_CONDITION = "WHERE ((?1 is null) or (?1 is not null and dm.indent_num = ?1))"
			+ "AND ((?2 is  null) or (?2 is not null and dm.challan_num = ?2))"
			+ "AND ((?3 is null) or (?3 is not null and dm.challan_amount= ?3)"
			+ "AND ((?4 is null) or (?4 is not null and dm.carrier_name = ?4))"
			+ "AND ((?5 is null) or (?5 is not null and  dm.quantity = ?5))"
			+ "AND ((?6 is null) or (?6 is not null and dm.purpose = ?6 ))"
			+ "AND ((?7 is null) or (?7 is not null and dm.sto_bank = ?7))"
			+ "AND ((?8 is null) or (?7 is not null and dm.status = ?8))"
			+ "AND ((?9 is null) or (?8 is not null and dm.creation_date= ?9)";

	@Query(value = HOLOGRAM_DTS_MAINQUERY + " #{#pageable}", countQuery = "SELECT COUNT(1) "
			+ HOLOGRAM_DTS_FROM, nativeQuery = true)
	Page<TblHologramDetails> fetchAllHealDailyIndentDts(Pageable pageable);

	@Query(value = HOLOGRAM_DTS_MAINQUERY + HOLOGRAM_DTS_CONDITION + "  #{#pageable}", countQuery = "SELECT COUNT(1) "
			+ HOLOGRAM_DTS_MAINQUERY + HOLOGRAM_DTS_CONDITION, nativeQuery = true)
	Page<TblHologramDetails> fetchHealDailyIndentDtsBy(Long indentNum, String challanNum, int challanAmount,
			String challanDate, String carrierName, int quantity, String purpose, String stoBank, String status,
			String creationDate, Pageable pageable);

	@Query(value = "SELECT * FROM " + SCHEMA
			+ "heal_purchase_indent  #{#pageable}", countQuery = "SELECT COUNT(1) FROM " + SCHEMA
					+ "heal_purchase_indent", nativeQuery = true)
	List<TblHologramDetails> findAllHologramHealDailyIndents(Pageable pageable);

	@Query(value = "SELECT * FROM heal_purchase_indent u WHERE u.indent_num = ?1", nativeQuery = true)
	List<TblHologramDetails> fetchHologramHealDailyIndentsByIndentNo(Long indentNum);

	String PURCHASE_PURPOSE_QUERY = "select distinct purpose from distillery.heal_purchase_indent";

	@Query(value = PURCHASE_PURPOSE_QUERY, nativeQuery = true)
	List<String> fetchHealPurchaseIndentPurposeList();
	
	String DATES_BETWEEN= " WHERE date(dm.creation_date) >= ?1 and date(dm.creation_date)< ?2 ";
	
	  @Query(value=HOLOGRAM_DTS_MAINQUERY+ DATES_BETWEEN,nativeQuery=true)
	    List<TblHologramDetails> fetchDateWiseStmts(String startDate,String endDate);

}
