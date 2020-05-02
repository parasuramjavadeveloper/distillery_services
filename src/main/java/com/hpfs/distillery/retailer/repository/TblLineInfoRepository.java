package com.hpfs.distillery.retailer.repository;

import com.hpfs.distillery.retailer.model.TblLineInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TblLineInfoRepository extends JpaRepository<TblLineInfo,Long> {

    List<TblLineInfo> findAll();

}
