package com.tech.pro.walker.api.services;

import java.util.List;
import java.util.Optional;

import com.tech.pro.walker.api.models.entity.IP;


public interface IIpService {
	
	public List<IP> findAll();
	
    public IP save(IP IP);
	
	public  Optional<IP> findById(Long id_IP);
	
	public void deleteById(Long id_IP);
	
}
