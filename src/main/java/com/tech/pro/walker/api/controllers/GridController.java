package com.tech.pro.walker.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.pro.walker.api.models.entity.Grid;
import com.tech.pro.walker.api.services.IGridServiceImp;

@RestController
@RequestMapping("api/walkout")
public class GridController {
	
	@Autowired
	private IGridServiceImp iGridServiceImp;
	
	@GetMapping("/get-Grids")
	public List<Grid> index(){
		return iGridServiceImp.findAll();
	} 
	
	@PostMapping("/crear-Grid")
	public Grid crear(@RequestBody Grid grid) {
		return iGridServiceImp.save(grid);
	}

}
