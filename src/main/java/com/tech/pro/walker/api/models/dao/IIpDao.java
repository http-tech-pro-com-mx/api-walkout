package com.tech.pro.walker.api.models.dao;

import com.tech.pro.walker.api.models.entity.IP;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IIpDao extends JpaRepository<IP, Long>{
	
	@Query("from IP i where i.proyecto.id_proyecto =?1 order by fecha_registro desc")
	public List<IP> findAllWhereIdProyecto(Long id_proyecto);
	
	@Query("select count(1) from IP i where i.ip =?1")
	public int findByIp(String ip);
	
	@Query("select i.id_ip from IP i where i.ip =?1")
	public Long getIdIpByIP(String ip);
	
	@Query("select i.proyecto.id_proyecto from IP i where i.id_ip =?1")
	public Long  getIdProyecto(Long id_ip); 
	
	@Modifying
	@Query( value= "SELECT CONCAT(W.nombre, ' ', W.apellido_paterno ) AS walker FROM walkout.ips AS  IP\r\n" + 
			"INNER JOIN walkout.grids AS G ON ( G.id_ip = IP.id_ip AND G.estatus = 1)\r\n" + 
			"INNER JOIN walkout.asignacion AS A ON ( A.id_grid = G.id_grid )\r\n" + 
			"INNER JOIN walkout.walkers AS W ON ( A.id_walker = W.id_walker)\r\n" + 
			"INNER JOIN walkout.proyecto_walkers as PW ON ( PW.id_walker = W.id_walker )\r\n" + 
			"WHERE IP.id_ip =?1 GROUP BY W.id_walker", nativeQuery = true)
	public List<Object> getParticipantesByIp(Long id_ip);
	
	@Modifying
	@Query("update IP i set i.QC =?2 where i.id_ip =?1")
	public void changeStatus(Long id_ip, int estatus);

}
