/**
 * 
 */
package com.hpfs.distillery.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hpfs.distillery.retailer.model.TblOrderForSupply;

/**
 * @author babasaheb
 *
 */
public interface OrderForSupplyRepository extends JpaRepository<TblOrderForSupply, String> {

	
	
	String fetchOrderForSupplyByOfsNoAndDepoId = "SELECT * FROM order_for_supply i WHERE i.ofs_no = ?1 AND i.depot_id = ?2";
	
	@Query(value = fetchOrderForSupplyByOfsNoAndDepoId, nativeQuery = true)
	List<TblOrderForSupply> fetchOrderForSupplyByOfsNoAndDepoId(@Param("ofsNo") String ofsNo, 
			@Param("depotId") Long depoId);
	
	String fetchOFSByDepoIdAndDisilleryIdAndByOfsNo = "SELECT * FROM order_for_supply i WHERE i.ofs_no = ?1 AND i.depot_id = ?2 AND i.destillery_id = ?3";
	
	String fetchSingleOFSByOfsNoAndDisilleryId = "SELECT * FROM order_for_supply i WHERE i.ofs_no = ?1 AND i.destillery_id = ?2";

	@Query(value = fetchSingleOFSByOfsNoAndDisilleryId, nativeQuery = true)
	TblOrderForSupply fetchOrderForSupplyByOfsNoAndDistilleryId(@Param("ofsNo") String ofsNo, 
			@Param("distilleryId") Long distilleryId);

	List<TblOrderForSupply> getTblOrderForSupplyByDistilleryId(Long distilleryId);
	
	String fetchOFSByDepoId = "SELECT * FROM order_for_supply i WHERE i.depot_id = ?1";
	
	@Query(value = fetchOFSByDepoId, nativeQuery = true)
	List<TblOrderForSupply> fetchOFSByDepoId(@Param("depotId")Long depotId);
	
	String fetchOFSByDepoIdAndDisilleryId = "SELECT * FROM order_for_supply i WHERE i.depot_id = ?1 AND i.destillery_id = ?2";
	@Query(value = fetchOFSByDepoIdAndDisilleryId, nativeQuery = true)
	List<TblOrderForSupply> fetchOFSByDepoIdAndDistilleryId(@Param("depotId")Long depotId,@Param("distilleryId")Long distilleryId);
	
	@Query(value = fetchOFSByDepoIdAndDisilleryIdAndByOfsNo, nativeQuery = true)
	List<TblOrderForSupply> fetchOFSByDepoIdAndDisilleryIdAndByOfsNo(@Param("ofsNo") String ofsNo,@Param("depotId")Long depotId,@Param("distilleryId")Long distilleryId);
	
	String fetchOFSByDisilleryId = "SELECT * FROM order_for_supply i WHERE i.destillery_id = ?1";

	@Query(value = fetchOFSByDisilleryId, nativeQuery = true)
	List<TblOrderForSupply> fetchOFSByDisilleryId(@Param("distilleryId")Long distilleryId);
}
