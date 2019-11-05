package com.tech.pro.walker.api.models.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tech.pro.walker.api.models.entity.Walker;

public interface IWalkerDao extends JpaRepository<Walker, Long> {
	
	public Walker findByUsuario(String usuario);
	
	@Modifying
	@Query(value = "SELECT * FROM walkout.walkers w INNER JOIN walkout.walkers_roles r  ON  r.id_walker = w.id_walker WHERE r.id_rol =?1", nativeQuery = true)
	public List<Walker> findAllWalkersByRol(Long id_rol);

}
