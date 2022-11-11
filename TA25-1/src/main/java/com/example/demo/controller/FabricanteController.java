package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Fabricante;
import com.example.demo.service.FabricanteServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FabricanteController {

	@Autowired
	FabricanteServiceImpl FabricanteServiceImpl;
	
	//listar todos los Fabricantes
	@GetMapping("/fabricantes")
	public List<Fabricante> listarFabricantes(){
		return FabricanteServiceImpl.listarFabricantes();
	}
	
	//guardar un Fabricante
	@PostMapping("/fabricantes")
	public Fabricante salvarFabricante(@RequestBody Fabricante Fabricante) {//los datos del Fabricante llegan en formato JSON desde el Request Body
		return FabricanteServiceImpl.guardarFabricante(Fabricante);
	}
	
	//muestro un Fabricante según el ID indicada
	@GetMapping("/fabricantes/{id}") 
	public Fabricante FabricanteXID(@PathVariable(name="id") Long id){ // el id del Fabricante llega desde la variable del path
		Fabricante Fabricante_xid = new Fabricante();//creo una instancia de la clase Fabricante
		
		Fabricante_xid=FabricanteServiceImpl.FabricanteXID(id);//busco el Fabricante según el ID y le asigno los datos a la instancia de la clase Fabricante
		
		System.out.println("Fabricante XID: "+Fabricante_xid);
		
		return Fabricante_xid;//devuelvo el Fabricante en formato JSON
	}
	
	//Actualizo los datos de un Fabricante según el ID indicada
	@PutMapping("/fabricantes/{id}")
	public Fabricante actualizarFabricante(@PathVariable(name="id")Long id,@RequestBody Fabricante Fabricante) {
		
		Fabricante Fabricante_seleccionado= new Fabricante();
		Fabricante Fabricante_actualizado= new Fabricante();
		
		Fabricante_seleccionado= FabricanteServiceImpl.FabricanteXID(id);
		
		Fabricante_seleccionado.setNombre(Fabricante.getNombre());
		Fabricante_seleccionado.setArticulo(Fabricante.getArticulo());
		
		Fabricante_actualizado = FabricanteServiceImpl.actualizarFabricante(Fabricante_seleccionado);
		
		System.out.println("El Fabricante actualizado es: "+ Fabricante_actualizado);
		
		return Fabricante_actualizado;
	}
	
	//borro el Fabricante indicado por el ID que llega en la variable del path
	@DeleteMapping("/fabricantes/{id}")
	public void eleiminarFabricante(@PathVariable(name="id")Long id) {
		FabricanteServiceImpl.eliminarFabricante(id);
	}
}
