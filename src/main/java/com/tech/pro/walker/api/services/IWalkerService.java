package com.tech.pro.walker.api.services;


import java.util.List;

import com.tech.pro.walker.api.models.entity.Walker;

public interface IWalkerService {
	
	public List<Walker> findAll();

}
