package com.tech.pro.walker.api.models.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tech.pro.walker.api.models.entity.Walker;

public interface IWalkerDao extends JpaRepository<Walker, Long> {
	
	public Walker findByUsuario(String usuario);
	
	@Query("from Rol r INNER JOIN Walker w ON (w.roles.id_rol = r.id_rol) where r.id_rol =  ?1")
	public List<Walker> findAllWalkersByRol(Long id_rol);

}
