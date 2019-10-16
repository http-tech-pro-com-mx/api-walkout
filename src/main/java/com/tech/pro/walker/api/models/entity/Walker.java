package com.tech.pro.walker.api.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;


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
	@Column(nullable=false, length=255)
	private String nombre;
	
	@NotEmpty(message="Apellido es requerido")
	@Column(nullable=false, length=255)
	private String apellido_paterno;
	
	@Column(length=255)
	private String apellido_materno;
	
	@Column(length=255)
	private String telefono;
	
	@NotEmpty(message="Usuario es requerido")
	@Column(nullable=false, unique = true)
	private String usuario;
	
	@NotEmpty(message="Contraseña es requerida")
	@Column
	private String pwd;
	
	@Column
	private boolean estatus;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="Walkers_roles", joinColumns = @JoinColumn(name="id_walker")
	, inverseJoinColumns = @JoinColumn(name ="id_rol")
	, uniqueConstraints = {@UniqueConstraint(columnNames= {"id_walker","id_rol"})})
	private List<Rol> roles;
	
	
	@ManyToMany(mappedBy="walkers_proyecto", fetch= FetchType.LAZY)
	@JsonIgnore
	private List<Proyecto> proyectos; 
	
	@ManyToMany(mappedBy="walkers")
	private List<Grid> grids;
	
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
	public List<Rol> getRoles() {
		return roles;
	}
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	public List<Proyecto> getProyectos() {
		return proyectos;
	}
	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	public List<Grid> getGrids() {
		return grids;
	}
	public void setGrids(List<Grid> grids) {
		this.grids = grids;
	}
	
	
	
	
	

}
