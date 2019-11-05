package com.tech.pro.walker.api.models.dao;

import com.tech.pro.walker.api.models.entity.IP;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IIpDao extends JpaRepository<IP, Long>{
	
	@Query("from IP i where i.proyecto.id_proyecto =?1")
	public List<IP> findAllWhereIdProyecto(Long id_proyecto);
	
	@Query("select count(1) from IP i where i.ip =?1")
	public int findByIp(String ip);
	
	@Query("select i.id_ip from IP i where i.ip =?1")
	public Long getIdIpByIP(String ip);
	
	@Query("select i.proyecto.id_proyecto from IP i where i.id_ip =?1")
	public Long  getIdProyecto(Long id_ip); 

}
