package com.tech.pro.walker.api.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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

	@Secured({ "ROLE_HQ", "ROLE_ADMIN", "ROLE_C_IP" })
	@GetMapping("/get-IPS")
	public List<IP> index() {
		return iIpServiceImp.findAll();
	}

	@Secured({ "ROLE_HQ" })
	@PostMapping("/crear-IP")
	public ResponseEntity<?> save(@RequestBody IP IP) {
		Map<String, Object> response = new HashMap<>();
		IP.setFecha_asignacion(new Date());

		int reg = iIpServiceImp.findByIp(IP.getIp().trim());
		boolean b = true;
		String menssage = "";

		if (reg == 0) {

			response.put("ip", iIpServiceImp.save(IP));
			menssage = "Registro exitoso!";

		} else {
			b = false;
			menssage = "La IP ya fue registrada";
		}

		response.put("successful", b);
		response.put("message", menssage);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Secured({ "ROLE_HQ" })
	@PostMapping("/update-IP")
	public ResponseEntity<?> update(@RequestBody IP IP) {
		Map<String, Object> response = new HashMap<>();

		int reg = iIpServiceImp.findByIp(IP.getIp().trim());
		boolean b = true;
		String menssage = "";

		if (reg == 0) {

			response.put("ip", iIpServiceImp.save(IP));
			menssage = "Actualización exitosa!";

		} else {

			Long id_ip = iIpServiceImp.getIdIpByIP(IP.getIp());

			if (id_ip.equals(IP.getId_ip())) {

				response.put("ip", iIpServiceImp.save(IP));
				menssage = "Actualización exitosa!";

			} else {
				b = false;
				menssage = "La IP ya fue registrada";
			}

		}

		response.put("successful", b);
		response.put("message", menssage);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@Secured({ "ROLE_HQ", "ROLE_ADMIN", "ROLE_CONSULTA_IP" })
	@GetMapping("/get-IP/{id_IP}")
	public ResponseEntity<?> getIP(@PathVariable Long id_IP) {
		Map<String, Object> response = new HashMap<>();
		response.put("ip", iIpServiceImp.findById(id_IP));
		response.put("id_proyecto", iIpServiceImp.getIdProyecto(id_IP));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Secured({ "ROLE_HQ" })
	@DeleteMapping("/delete-IP/{id_IP}")
	public ResponseEntity<?> delete(@PathVariable Long id_IP) {
		Map<String, Object> response = new HashMap<>();
		iIpServiceImp.deleteById(id_IP);
		response.put("successful", true);
		response.put("message", " IP eliminada ");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Secured({ "ROLE_HQ" })
	@PostMapping("/changeStatusIP")
	public ResponseEntity<?> changeStatus(@RequestBody IP IP) {

		Map<String, Object> response = new HashMap<>();
		Date dia = new Date();

		iIpServiceImp.changeStatus(IP.getId_ip(), IP.getQC());

		switch (IP.getQC()) {

		case 0:
			IP.setFecha_envio_campo(dia);
			iIpServiceImp.updateFechaCampo(IP.getId_ip(), dia, IP.getTotal_grids(), IP.isActualizacion(), IP.getKm_actualizados());
			break;
		case 1:
			IP.setFecha_qc(dia);
			iIpServiceImp.updateFechaQC(IP.getId_ip(), dia);
			break;
		case 2:
			IP.setFecha_cliente(dia);
			iIpServiceImp.updateFechaCliente(IP.getId_ip(), dia);
			break;
		case 3:
			IP.setFecha_shared_point(dia);
			iIpServiceImp.updateFechaShared(IP.getId_ip(), dia);
			break;

		}

		response.put("successful", true);
		response.put("message", " Se actualizó el estatus");
		response.put("dia", dia);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@Secured({ "ROLE_HQ", "ROLE_ADMIN", "ROLE_CONSULTA_IP" })
	@GetMapping("/get-IPS/proyecto/{id_proyecto}")
	public ResponseEntity<?> getIpsProyecto(@PathVariable Long id_proyecto) {
		Map<String, Object> response = new HashMap<>();

		List<IP> ips = iIpServiceImp.findAllWhereIdProyecto(id_proyecto);
		List<Object> all = new ArrayList<>();

		for (IP ip : ips) {

			List<Object> participantes = new ArrayList<>();
			participantes.add(ip.getId_ip());
			participantes.add(iIpServiceImp.getParticipantesByIp(ip.getId_ip()));

			all.add(participantes);

		}

		response.put("ips", ips);
		response.put("participantes", all);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
