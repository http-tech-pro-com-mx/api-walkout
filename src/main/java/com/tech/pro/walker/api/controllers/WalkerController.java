package com.tech.pro.walker.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tech.pro.walker.api.models.entity.Walker;
import com.tech.pro.walker.api.services.IWalkerServiceImp;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/walkout")
public class WalkerController {
	
	@Autowired
	private IWalkerServiceImp iWalkerServiceImp;
	
	@GetMapping("/get-walkers")
	public List<Walker> index(){
		return iWalkerServiceImp.findAll();
	}
	
	@PostMapping("/crear-walker")
	public Walker crear(@RequestBody Walker walker) {
		return iWalkerServiceImp.save(walker);
	}
	
	@GetMapping("/get-walker/{id_walker}")
	public Optional<Walker> getWalker(@PathVariable Long id_walker){
		return iWalkerServiceImp.findById(id_walker);
	}
	
	@DeleteMapping("/delete-walker/{id_walker}")
	public void delete(@PathVariable Long id_walker) {
		iWalkerServiceImp.deleteById(id_walker);
	}
	
	@PutMapping("/update-walker")
	public Walker update(@RequestBody Walker walker) {
		return iWalkerServiceImp.save(walker);
	}

}
