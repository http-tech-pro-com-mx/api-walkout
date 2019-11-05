package com.tech.pro.walker.api.services;

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
	
}
