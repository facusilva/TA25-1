package com.example.demo.dto;

import javax.persistence.*;

@Entity
@Table(name="articulo")
public class Articulo {

	//atributos de la entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private int precio;
	
	@ManyToOne
	@JoinColumn(name="fabricante")
	private Fabricante fabricante;

	
	public Articulo() {
	}

	public Articulo(Long id, String nombre, int precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", fabricante=" + fabricante + "]";
	}
	
	

	

	
	

	
	
	
	
	
	
}
