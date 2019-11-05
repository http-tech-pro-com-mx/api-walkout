package com.tech.pro.walker.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.pro.walker.api.models.entity.IP;
import com.tech.pro.walker.api.services.IIpServiceImp;


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
	public ResponseEntity<?>  save(@RequestBody IP IP ) {
		Map<String, Object> response = new HashMap<>();	
		
		int reg = iIpServiceImp.findByIp(IP.getIp().trim());
		boolean b = true;
		String menssage = "";
		
		if( reg == 0) {
			
			response.put("ip", iIpServiceImp.save(IP));
			menssage = "Registro exitoso!";
			
		}else {
			b= false;
			menssage = "La IP ya fue registrada";
		}
		
		response.put("successful", b);
		response.put("message", menssage);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	@PostMapping("/update-IP")
	public ResponseEntity<?>  update(@RequestBody IP IP ) {
		Map<String, Object> response = new HashMap<>();	
		
		int reg = iIpServiceImp.findByIp(IP.getIp().trim());
		boolean b = true;
		String menssage = "";
		
		if( reg == 0) {
			
			response.put("ip", iIpServiceImp.save(IP));
			menssage = "Actualización exitosa!";
			
		}else {
			
			Long id_ip = iIpServiceImp.getIdIpByIP(IP.getIp());
			
			if(id_ip.equals(IP.getId_ip())) {
				
				response.put("ip", iIpServiceImp.save(IP));
				menssage = "Actualización exitosa!";
				
			}else {
				b= false;
				menssage = "La IP ya fue registrada";
			}
		
		}
		
		response.put("successful", b);
		response.put("message", menssage);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/get-IP/{id_IP}")
	public ResponseEntity<?> getIP(@PathVariable Long  id_IP) {
		Map<String, Object> response = new HashMap<>();	
		response.put("ip", iIpServiceImp.findById(id_IP));
		response.put("id_proyecto", iIpServiceImp.getIdProyecto(id_IP));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-IP/{id_IP}")
	public void delete(@PathVariable Long id_IP) {
		iIpServiceImp.deleteById(id_IP);
	}
	
	
	@GetMapping("/get-IPS/proyecto/{id_proyecto}")
	public List<IP> getIpsProyecto(@PathVariable Long id_proyecto){
		return iIpServiceImp.findAllWhereIdProyecto(id_proyecto);
	}
	
	
	

}
