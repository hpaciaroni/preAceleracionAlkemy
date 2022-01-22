package com.alkemy.icons.icons.entity;

import javax.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import lombok.*;


@EntityScan
@Table(name = "continente")
@Getter
@Setter
public class ContinenteEntity{
	
	@Id
	//No va @Column ya que la columna y el atributo tienen el mismo nombre
	//Los id van a ser "secuenciales"
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String imagen;
	private String denominacion;
	
	//Averiguar porque no esta funcionando lombok y debo implementar nuevamente los setters y getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
}
