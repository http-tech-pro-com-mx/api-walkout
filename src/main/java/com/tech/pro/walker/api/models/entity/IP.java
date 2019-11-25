package com.tech.pro.walker.api.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private Double pies;
	
	@Column
	private int QC;
	
	
	@Column
	private Date fecha_levantamiento;
	
	@Column
	private int tipo;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name =  "id_proyecto")
	@JsonBackReference(value="proyectoIp")
	private Proyecto proyecto;
	
	@OneToMany(mappedBy= "ip" , cascade = CascadeType.ALL)
	@JsonManagedReference(value="ipGrid")
	private List<Grid> grids = new ArrayList<>();
	
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

	public Double getPies() {
		return pies;
	}
	public void setPies(Double pies) {
		this.pies = pies;
	}
	public int getQC() {
		return QC;
	}
	public void setQC(int qC) {
		QC = qC;
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
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public List<Grid> getGrids() {
		return grids;
	}
	public void setGrids(List<Grid> grids) {
		this.grids = grids;
	}
	public Date getFecha_levantamiento() {
		return fecha_levantamiento;
	}
	public void setFecha_levantamiento(Date fecha_levantamiento) {
		this.fecha_levantamiento = fecha_levantamiento;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
	
	

}
