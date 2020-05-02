/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import com.hpfs.distillery.retailer.model.TblDistilleryInvM;
import com.hpfs.distillery.retailer.model.TblIndent_D;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import static com.hpfs.distillery.retailer.utils.ApplicationConstants.SCHEMA;

/**
 * @author babasaheb
 *
 */
public interface IndentDRepository extends JpaRepository<TblIndent_D,Long> {

    String INDENT_DTS_CONDITION="WHERE ((?1 is null or (?1 is not null and product_code like '%'||upper(?1)||'%')))"+
            "AND ((?2 is  null or (?2 is not null and bar_code like '%'||upper(?2)||'%' ) ))"+
            "AND ((?3 is null or (?3 is not null and indent_id = ?3 ) ))"+
            "AND ((?4 is null or (?4 is not null and total_price = ?4 ) ))";

    @Query(value="SELECT * FROM "+SCHEMA+"indent_d  #{#pageable}",
            countQuery="SELECT COUNT(1) FROM "+SCHEMA+"indent_d",nativeQuery=true)
    Page<TblIndent_D> fetchAllInvMgmDts(Pageable pageable);

    @Query(value="SELECT * FROM "+SCHEMA+"indent_d "+INDENT_DTS_CONDITION+"  #{#pageable}",
            countQuery="SELECT COUNT(1) FROM "+SCHEMA+"indent_d "+INDENT_DTS_CONDITION,nativeQuery=true)
    Page<TblIndent_D> fetchInvMgmDtsBy(String productCode,String barCode,Long indentId,Float total_price,Pageable pageable);
}
