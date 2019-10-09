package com.tech.pro.walker.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.pro.walker.api.models.entity.Walker;
import com.tech.pro.walker.api.services.IWalkerServiceImp;

import java.util.List;

@RestController
@RequestMapping("api/walkout")
public class WalkerController {
	
	@Autowired
	private IWalkerServiceImp iWalkerServiceImp;
	
	@GetMapping("/getWalkers")
	public List<Walker> index(){
		return iWalkerServiceImp.findAll();
	}

}
