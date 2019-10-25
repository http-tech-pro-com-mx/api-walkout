package com.tech.pro.walker.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.pro.walker.api.models.entity.Grid;
import com.tech.pro.walker.api.services.IGridServiceImp;
import com.tech.pro.walker.api.services.IWalkerServiceImp;

@RestController
@RequestMapping("api/walkout")
public class GridController {
	
	@Autowired
	private IGridServiceImp iGridServiceImp;
	
	@Autowired
	private IWalkerServiceImp iWalkerServiceImp;
	
	@GetMapping("/get-Grids")
	public List<Grid> index(){
		return iGridServiceImp.findAll();
	} 
	
	@PostMapping("/crear-Grid")
	public Grid crear(@RequestBody Grid grid) {
		return iGridServiceImp.save(grid);
	}
	
	@GetMapping("get-Grids/{id_ip}")
	public List<Grid> gridsByIp(@PathVariable Long id_ip){
		return iGridServiceImp.findAllGridByIp(id_ip);
	}
	
	@GetMapping("/get-Grids/{id_ip}/All-walkers")
	public ResponseEntity<?> getGridsAllWalker(@PathVariable Long id_ip) {

		Map<String, Object> response = new HashMap<>();
		response.put("walkers", iWalkerServiceImp.findAll());
		response.put("grids", iGridServiceImp.findAllGridByIp(id_ip));
		response.put("successful", true);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
	
	

}
