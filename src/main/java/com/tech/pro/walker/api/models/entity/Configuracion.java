package com.tech.pro.walker.api.models.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Configuraciones")
public class Configuracion implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_configuracion;
	
	@Column(nullable=false, length=300)
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date fecha_inicio;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date fecha_fin;
	
	@Column(nullable=false)
	private Long meta;
	
	@Column
	private boolean estatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name =  "id_proyecto")
	@JsonBackReference(value="configProyecto")
	private Proyecto proyecto;
	
	
	public Long getId_configuracion() {
		return id_configuracion;
	}

	public void setId_configuracion(Long id_configuracion) {
		this.id_configuracion = id_configuracion;
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

	public Date getFecha_inicio() {
		return getDateCorrecta(fecha_inicio, 1);
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return getDateCorrecta(fecha_fin, 1);
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Long getMeta() {
		return meta;
	}

	public void setMeta(Long meta) {
		this.meta = meta;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	private Date getDateCorrecta(Date f, int dias) {
		Calendar c = Calendar.getInstance();
		c.setTime(f);
	    c.add(c.DATE, dias);
	    return c.getTime();
	}
	


}
