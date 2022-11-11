package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="fabricante")
public class Fabricante {

	//atributos de la entidad fabricante
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="fabricante")
	private List<Articulo> articulo;

	
	public Fabricante() {
	}

	public Fabricante(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	//Getters y Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "articulo")
	public List<Articulo> getArticulo() {
		return articulo;
	}

	public void setArticulo(List<Articulo> articulo) {
		this.articulo = articulo;
	}

	@Override
	public String toString() {
		return "Fabricante [id=" + id + ", nombre=" + nombre + ", articulo=" + articulo + "]";
	}
	
	
	
	
	

	
	
	
	
	
	
}
