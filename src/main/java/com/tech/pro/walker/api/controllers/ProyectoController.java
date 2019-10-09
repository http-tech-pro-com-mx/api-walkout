package com.tech.pro.walker.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.pro.walker.api.models.entity.Proyecto;
import com.tech.pro.walker.api.services.IProyectoServiceImp;

@RestController
@RequestMapping("api/walkout")
public class ProyectoController {
	
	@Autowired
	private IProyectoServiceImp iProyectoServiceImp;
	
	@GetMapping("/getProyectos")
	public List<Proyecto> index(){
		return iProyectoServiceImp.findAll();
	} 

}
