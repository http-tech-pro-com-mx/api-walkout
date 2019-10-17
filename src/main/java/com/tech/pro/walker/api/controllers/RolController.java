package com.tech.pro.walker.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.pro.walker.api.models.entity.Rol;
import com.tech.pro.walker.api.services.IRolServiceImp;

@RestController
@RequestMapping("api/walkout")
public class RolController {
	
	@Autowired
	private IRolServiceImp iRolServiceImp;
	
	@GetMapping("/get-Roles")
	public List<Rol> index(){
		return iRolServiceImp.findAll();
	}

}
