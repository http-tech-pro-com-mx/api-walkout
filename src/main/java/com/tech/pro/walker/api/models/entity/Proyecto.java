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
@Table(name = "Proyectos")
public class Proyecto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_proyecto;
	
	@NotEmpty(message="Nombre es requerido")
	@Column(nullable=false)
	private String nombre;
	
	@NotEmpty(message="Descripción requerida")
	@Column(nullable=false)
	private String descripcion;
	
	@Column
	private boolean estatus;


	public Long getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(Long id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	
	
	

}
