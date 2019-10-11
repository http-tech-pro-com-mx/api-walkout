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

import com.tech.pro.walker.api.models.entity.Proyecto;
import com.tech.pro.walker.api.services.IProyectoServiceImp;

@RestController
@RequestMapping("api/walkout")
public class ProyectoController {
	
	@Autowired
	private IProyectoServiceImp iProyectoServiceImp;
	
	@GetMapping("/get-proyectos")
	public List<Proyecto> index(){
		return iProyectoServiceImp.findAll();
	}
	
	@PostMapping("/crear-proyecto")
	public Proyecto save(@RequestBody Proyecto proyecto ) {
		return iProyectoServiceImp.save(proyecto);
	}
	
	@GetMapping("/get-proyecto/{id_proyecto}")
	public Optional<Proyecto> getProyecto(@PathVariable Long  id_proyecto) {
		return iProyectoServiceImp.findById(id_proyecto);
	}
	
	@DeleteMapping("/delete-proyecto/{id_proyecto}")
	public void delete(@PathVariable Long id_proyecto) {
		iProyectoServiceImp.deleteById(id_proyecto);
	}
	
	@PutMapping("/update-proyecto")
	public Proyecto update(@RequestBody Proyecto proyecto) {
		return iProyectoServiceImp.save(proyecto);
	}

}
