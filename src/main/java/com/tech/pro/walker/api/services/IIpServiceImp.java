package com.tech.pro.walker.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.pro.walker.api.models.dao.IIpDao;
import com.tech.pro.walker.api.models.entity.IP;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class IIpServiceImp implements IIpService{
	
	@Autowired
	private IIpDao iIpDao;

	@Override
	@Transactional(readOnly = true)
	public List<IP> findAll() {
		return iIpDao.findAll();
	}

	@Override
	@Transactional
	public IP save(IP IP) {
		return iIpDao.save(IP);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<IP> findById(Long id_IP) {
		return iIpDao.findById(id_IP);
	}

	@Override
	@Transactional
	public void deleteById(Long id_IP) {
		iIpDao.deleteById(id_IP);
	}

	@Override
	@Transactional(readOnly= true)
	public List<IP> findAllWhereIdProyecto(Long id_proyecto) {
		return iIpDao.findAllWhereIdProyecto(id_proyecto);
	}

	@Override
	@Transactional(readOnly= true)
	public int findByIp(String ip) {
		return iIpDao.findByIp(ip);
	}

	@Override
	@Transactional(readOnly= true)
	public Long getIdIpByIP(String ip) {
		return iIpDao.getIdIpByIP(ip);
	}

	@Override
	@Transactional(readOnly= true)
	public Long getIdProyecto(Long id_ip) {
		return iIpDao.getIdProyecto(id_ip);
	}
	
	
	
	
	
	

}
