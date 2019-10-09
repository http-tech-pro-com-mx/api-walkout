package com.tech.pro.walker.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.pro.walker.api.models.dao.IIpDao;
import com.tech.pro.walker.api.models.entity.IP;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class IIpServiceImp implements IIpService{
	
	@Autowired
	private IIpDao iIpDao;

	@Override
	public List<IP> findAll() {
		return iIpDao.findAll();
	}

}
