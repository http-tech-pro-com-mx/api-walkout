package com.tech.pro.walker.api.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tech.pro.walker.api.models.entity.Configuracion;

public interface IConfiguracionDao extends JpaRepository<Configuracion, Long>{
	
	
	@Query("from Configuracion c where proyecto.id_proyecto =?1")
	public List<Configuracion> findAllByIdProyecto(Long id_proyecto);

}
