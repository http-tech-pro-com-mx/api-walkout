package com.tech.pro.walker.api.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.tech.pro.walker.api.models.entity.IP;


public interface IIpService {
	
	public List<IP> findAll();
	
    public IP save(IP IP);
	
	public  Optional<IP> findById(Long id_IP);
	
	public void deleteById(Long id_IP);
	
	public List<IP> findAllWhereIdProyecto(Long id_proyecto);
	
	public int findByIp(String ip);
	
	public Long getIdIpByIP(String ip);
	
	public Long  getIdProyecto(Long id_ip); 
	
	public List<Object> getParticipantesByIp(Long id_ip);
	
	public void changeStatus(Long id_ip, int estatus);
	
	public void updateFechaCampo(Long id_ip, Date dia, int total_grids, boolean actualizacion, Double km_actualizados );
	
	public void updateFechaCliente(Long id_ip, Date dia);
	
	public void updateFechaQC(Long id_ip, Date dia);
	
	public void updateFechaShared(Long fecha_shared_point, Date dia);
	
	
}
