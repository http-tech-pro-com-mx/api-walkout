package com.tech.pro.walker.api.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tech.pro.walker.api.models.entity.Grid;

public interface IGridDao extends JpaRepository<Grid, Long> {

	@Query("from Grid g where g.ip.id_ip = ?1")
	public List<Grid> findAllGridByIp(Long id_ip);
	
	@Query("from Grid g where g.id_grid =?1")
	public Grid fingGridById(Long id_grid);
	
	@Query("select count(1) from Grid g where g.numero_plano =?1 AND g.ip.id_ip =?2")
	public int findByGrid(String numero_plano, Long id_ip);
	
	@Query("from Grid g where g.numero_plano =?1 AND g.ip.id_ip =?2")
	public Grid findGridByIdGrid(String numero_plano , Long id_ip);
}
