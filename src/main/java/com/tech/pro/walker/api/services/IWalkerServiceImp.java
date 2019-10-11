package com.tech.pro.walker.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.pro.walker.api.models.dao.IWalkerDao;
import com.tech.pro.walker.api.models.entity.Walker;

@Service
public class IWalkerServiceImp implements IWalkerService {
	
	@Autowired
	private IWalkerDao iWalkerDao;

	@Override
	@Transactional(readOnly=true)
	public List<Walker> findAll() {
		return iWalkerDao.findAll();
	}

	@Override
	@Transactional
	public Walker save(Walker w) {
		return iWalkerDao.save(w);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Walker> findById(Long id_walker) {
		return iWalkerDao.findById(id_walker);
	}

	@Override
	@Transactional
	public void deleteById(Long id_walker) {
	    iWalkerDao.deleteById(id_walker);
	}
	
	

}
