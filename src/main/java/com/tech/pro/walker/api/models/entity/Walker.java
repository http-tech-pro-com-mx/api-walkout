package com.tech.pro.walker.api.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Walkers")
public class Walker implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_walker;
	
	@NotEmpty(message="Nombre es requerido")
	@Column(nullable=false)
	private String nombre;
	
	@NotEmpty(message="Apellido es requerido")
	@Column(nullable=false)
	private String apellido_paterno;
	
	@Column
	private String apellido_materno;
	
	@Column
	private String telefono;
	
	@NotEmpty(message="Usuario es requerido")
	@Column(nullable=false, unique = true)
	private String usuario;
	
	@NotEmpty(message="Contraseña es requerida")
	@Column
	private String pwd;
	
	@Column
	private boolean estatus;
	
	
	public Long getId_walker() {
		return id_walker;
	}
	public void setId_walker(Long id_walker) {
		this.id_walker = id_walker;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	public String getApellido_materno() {
		return apellido_materno;
	}
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public boolean isEstatus() {
		return estatus;
	}
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	
	
	
	

}
