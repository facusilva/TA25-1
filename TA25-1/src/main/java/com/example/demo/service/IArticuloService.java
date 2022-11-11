package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Articulo;

public interface IArticuloService {

	//Métodos del CRUD
	public List<Articulo> listarArticulos(); //Listar All
	
	public Articulo guardarArticulo(Articulo Articulo); //Guarda un Articulo CREATE
	
	public Articulo ArticuloXID(Long id); //Leer datos de un Articulo READ
	
	public Articulo actualizarArticulo(Articulo Articulo); //Actualiza datos del Articulo UPDATE
	
	public void eliminarArticulo(Long id);//Elimina el Articulo DELETE
}
