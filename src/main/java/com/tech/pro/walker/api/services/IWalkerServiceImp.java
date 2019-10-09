package com.tech.pro.walker.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.pro.walker.api.models.dao.IWalkerDao;
import com.tech.pro.walker.api.models.entity.Walker;

@Service
public class IWalkerServiceImp implements IWalkerService {
	
	@Autowired
	private IWalkerDao iWalkerDao;

	@Override
	public List<Walker> findAll() {
		return iWalkerDao.findAll();
	}

}
