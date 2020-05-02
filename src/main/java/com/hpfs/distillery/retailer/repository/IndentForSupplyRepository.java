/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hpfs.distillery.retailer.model.TblIndentForSupply;
import com.hpfs.distillery.retailer.model.TblOrderForSupply;

/**
 * @author babasaheb
 *
 */
public interface IndentForSupplyRepository extends JpaRepository<TblIndentForSupply, String> {

	String fetchSingleIFSByIndentNoAndDisilleryId = "SELECT * FROM indent_for_supply i WHERE i.indent_no = ?1 AND i.distillery_id = ?2";
	String fetchIFSByDepoIdAndDisilleryIdAndByOfsNo = "SELECT * FROM indent_for_supply i WHERE i.indent_no = ?1 AND i.depot_id = ?2 AND i.distillery_id = ?3";
	

	String fetchIndentForSupplyByIndentNoAndDistilleryId = "SELECT * FROM indent_for_supply i WHERE i.indent_no = ?1 AND i.distillery_id = ?2";

	@Query(value = fetchIndentForSupplyByIndentNoAndDistilleryId, nativeQuery = true)
	TblIndentForSupply fetchIndentForSupplyByIndentNoAndDistilleryId(@Param("indentNo") String indentNo, 
			@Param("distilleryId") Long distilleryId);
	
	String fetchIndentForSupplyByIndentNoAndDepotId = "SELECT * FROM indent_for_supply i WHERE i.indent_no = ?1 AND i.depot_id = ?2";
	
	@Query(value = fetchIndentForSupplyByIndentNoAndDepotId, nativeQuery = true)
	TblIndentForSupply fetchIndentForSupplyByIndentNoAndDepotId(@Param("indentNo") String indentNo, 
			@Param("depotId") Long depotId);
	
	List<TblIndentForSupply> getTblIndentForSupplyByDistilleryId(Long distilleryId);
	
	@Query(value = fetchIFSByDepoIdAndDisilleryIdAndByOfsNo, nativeQuery = true)
	List<TblIndentForSupply> fetchIFSByDepoIdAndDisilleryIdAndByOfsNo(@Param("indentNo") String indentNo,@Param("depotId")Long depotId,@Param("distilleryId")Long distilleryId);
	
    String fetchIFSByDepoId = "SELECT * FROM indent_for_supply i WHERE i.depot_id = ?1";
	
	@Query(value = fetchIFSByDepoId, nativeQuery = true)
	List<TblIndentForSupply> fetchIFSByDepoId(@Param("depotId")Long depotId);
	
	String fetchIFSByDepoIdAndDisilleryId = "SELECT * FROM indent_for_supply i WHERE i.depot_id = ?1 AND i.distillery_id = ?2";
	@Query(value = fetchIFSByDepoIdAndDisilleryId, nativeQuery = true)
	List<TblIndentForSupply> fetchIFSByDepoIdAndDistilleryId(@Param("depotId")Long depotId,@Param("distilleryId")Long distilleryId);
	
	String fetchIFSByDisilleryId = "SELECT * FROM indent_for_supply i WHERE i.distillery_id = ?1";
	@Query(value = fetchIFSByDisilleryId, nativeQuery = true)
	List<TblIndentForSupply> fetchIFSByDisilleryId(@Param("distilleryId")Long distilleryId);
	
	String fetchIndentForSupplyByIndentNo = "SELECT * FROM indent_for_supply i WHERE i.indent_no = ?1";

	@Query(value = fetchIndentForSupplyByIndentNo, nativeQuery = true)
	TblIndentForSupply fetchIndentForSupplyByIndentNo(@Param("indentNo") String indentNo);
	
	
}
