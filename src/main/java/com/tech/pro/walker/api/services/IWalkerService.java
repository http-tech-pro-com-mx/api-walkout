package com.tech.pro.walker.api.services;


import java.util.List;
import java.util.Optional;

import com.tech.pro.walker.api.models.entity.Walker;

public interface IWalkerService {
	
	public List<Walker> findAll();
	
	public Walker save(Walker w);
	
	public  Optional<Walker>  findById(Long id_walker);
	
	public void deleteById(Long id_walker);
	
	public Walker findByUsuario(String username);

}
