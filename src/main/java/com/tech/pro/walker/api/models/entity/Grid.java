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
@Table(name = "Grids")
public class Grid implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_grid;
	
	@Column
	private Date fecha;
	
	@Column
	private Double total_pies;
	
	@Column
	private int total_casas;
	
	@Column
	private int total_negocios;
	
	@Column
	private int total_escuelas;
	
	@Column
	private int total_iglesias;
	
	@Column
	private int total_baldios;
	
	@NotEmpty(message="Numero de plano es requerido")
	@Column(nullable=false, unique = true)
	private String numero_plano;
	
	@Column(length=255)
	private String comentarios;
	
	@Column
	private int tipo;
	
	@Column
	private String archivo;
	
	@Column
	private boolean estatus;

	public Long getId_grid() {
		return id_grid;
	}

	public void setId_grid(Long id_grid) {
		this.id_grid = id_grid;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getTotal_pies() {
		return total_pies;
	}

	public void setTotal_pies(Double total_pies) {
		this.total_pies = total_pies;
	}

	public int getTotal_casas() {
		return total_casas;
	}

	public void setTotal_casas(int total_casas) {
		this.total_casas = total_casas;
	}

	public int getTotal_negocios() {
		return total_negocios;
	}

	public void setTotal_negocios(int total_negocios) {
		this.total_negocios = total_negocios;
	}

	public int getTotal_escuelas() {
		return total_escuelas;
	}

	public void setTotal_escuelas(int total_escuelas) {
		this.total_escuelas = total_escuelas;
	}

	public int getTotal_iglesias() {
		return total_iglesias;
	}

	public void setTotal_iglesias(int total_iglesias) {
		this.total_iglesias = total_iglesias;
	}

	public int getTotal_baldios() {
		return total_baldios;
	}

	public void setTotal_baldios(int total_baldios) {
		this.total_baldios = total_baldios;
	}

	public String getNumero_plano() {
		return numero_plano;
	}

	public void setNumero_plano(String numero_plano) {
		this.numero_plano = numero_plano;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	
}
