package com.tech.pro.walker.api.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "IPS")
public class IP  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_ip;
	
	@NotEmpty(message="IP requerida")
	@Column(nullable=false, unique = true)
	private String ip;
	
	@Column
	private Double km;
	
	@Column
	private boolean QC;
	
	@Column
	private boolean sp;
	
	@NotEmpty(message="Ubicación requerida")
	@Column(nullable=false, length=300)
	private String ubicacion;
	
	@Column
	private boolean estatus;
	
	@Column
	private Date fecha_registro;
	
	@Column
	private Long usuario_registro;
	
	@Column
	private Date fecha_update;
	
	@Column
	private Long usuario_update;
	
	public Long getId_ip() {
		return id_ip;
	}
	public void setId_ip(Long id_ip) {
		this.id_ip = id_ip;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Double getKm() {
		return km;
	}
	public void setKm(Double km) {
		this.km = km;
	}
	public boolean isQC() {
		return QC;
	}
	public void setQC(boolean qC) {
		QC = qC;
	}
	public boolean isSp() {
		return sp;
	}
	public void setSp(boolean sp) {
		this.sp = sp;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public boolean isEstatus() {
		return estatus;
	}
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public Long getUsuario_registro() {
		return usuario_registro;
	}
	public void setUsuario_registro(Long usuario_registro) {
		this.usuario_registro = usuario_registro;
	}
	public Date getFecha_update() {
		return fecha_update;
	}
	public void setFecha_update(Date fecha_update) {
		this.fecha_update = fecha_update;
	}
	public Long getUsuario_update() {
		return usuario_update;
	}
	public void setUsuario_update(Long usuario_update) {
		this.usuario_update = usuario_update;
	}
	
	
	
	

}
