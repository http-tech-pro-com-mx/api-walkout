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
@Table(name = "Evidencias")
public class Evidencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_evidencia;
	
	@Column(nullable=false, length=300)
	private String nombre;
	
	@Column(nullable=false, length=500)
	private String descripcion;
	
	@NotEmpty(message="Archivo es requerido")
	@Column(nullable=false)
	private String archivo;
	
	@Column
	private boolean estatus;

	public Long getId_evidencia() {
		return id_evidencia;
	}

	public void setId_evidencia(Long id_evidencia) {
		this.id_evidencia = id_evidencia;
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
