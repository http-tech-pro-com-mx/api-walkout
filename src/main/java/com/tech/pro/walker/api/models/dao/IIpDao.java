package com.tech.pro.walker.api.models.dao;

import com.tech.pro.walker.api.models.entity.IP;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IIpDao extends JpaRepository<IP, Long>{
	
	@Query("from IP i where i.proyecto.id_proyecto =?1")
	public List<IP> findAllWhereIdProyecto(Long id_proyecto);

}
