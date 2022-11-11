package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Fabricante;

public interface IFabricanteService {

	//Métodos del CRUD
	public List<Fabricante> listarFabricantes(); //Listar All
	
	public Fabricante guardarFabricante(Fabricante Fabricante); //Guarda un Fabricante CREATE
	
	public Fabricante FabricanteXID(Long id); //Leer datos de un Fabricante READ
	
	public Fabricante actualizarFabricante(Fabricante Fabricante); //Actualiza datos del Fabricante UPDATE
	
	public void eliminarFabricante(Long id);//Elimina el Fabricante DELETE
}
