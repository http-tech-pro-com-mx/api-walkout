package com.tech.pro.walker.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.pro.walker.api.models.entity.IP;
import com.tech.pro.walker.api.services.IIpServiceImp;;

@RestController
@RequestMapping("api/walkout")
public class IpController {
	
	@Autowired
	private IIpServiceImp iIpServiceImp;
	
	@GetMapping("/getIPS")
	public List<IP> index(){
		return iIpServiceImp.findAll();
	} 
	

}
