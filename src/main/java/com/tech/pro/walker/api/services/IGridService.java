package com.tech.pro.walker.api.services;

import java.util.List;

import com.tech.pro.walker.api.models.entity.Grid;

public interface IGridService {
	
	public List<Grid> findAll();
	
	public Grid save(Grid grid);
	
	public List<Grid> findAllGridByIp(Long id_ip);
	
	public Grid findGridByIdGrid(String numero_plano, Long id_ip);
	
	public int findByGrid(String numero_plano, Long id_ip);
	
	public Grid fingGridById(Long id_grid);
	
	

}
