package com.tech.pro.walker.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.pro.walker.api.models.dao.IGridDao;
import com.tech.pro.walker.api.models.entity.Grid;

@Service
public class IGridServiceImp implements IGridService {
	
	@Autowired
	private IGridDao iGridDao;

	@Override
	@Transactional(readOnly=true)
	public List<Grid> findAll() {
		return iGridDao.findAll();
	}

	@Override
	@Transactional
	public Grid save(Grid grid) {
		return iGridDao.save(grid);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Grid> findAllGridByIp(Long id_ip) {
		return iGridDao.findAllGridByIp(id_ip);
	}
	
	
	
	
	
	

}
