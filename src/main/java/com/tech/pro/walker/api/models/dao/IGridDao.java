package com.tech.pro.walker.api.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tech.pro.walker.api.models.entity.Grid;

public interface IGridDao extends JpaRepository<Grid, Long> {

	@Query("from Grid g where g.ip.id_ip = ?1")
	public List<Grid> findAllGridByIp(Long id_ip);
	
}
