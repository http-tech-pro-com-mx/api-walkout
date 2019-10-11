package com.tech.pro.walker.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.pro.walker.api.models.entity.IP;
import com.tech.pro.walker.api.services.IIpServiceImp;;

@RestController
@RequestMapping("api/walkout")
public class IpController {
	
	@Autowired
	private IIpServiceImp iIpServiceImp;
	
	@GetMapping("/get-IPS")
	public List<IP> index(){
		return iIpServiceImp.findAll();
	}
	
	@PostMapping("/crear-IP")
	public IP save(@RequestBody IP IP ) {
		return iIpServiceImp.save(IP);
	}
	
	@GetMapping("/get-IP/{id_IP}")
	public Optional<IP> getIP(@PathVariable Long  id_IP) {
		return iIpServiceImp.findById(id_IP);
	}
	
	@DeleteMapping("/delete-IP/{id_IP}")
	public void delete(@PathVariable Long id_IP) {
		iIpServiceImp.deleteById(id_IP);
	}
	
	@PutMapping("/update-IP")
	public IP update(@RequestBody IP IP) {
		return iIpServiceImp.save(IP);
	}
	
	
	

}
