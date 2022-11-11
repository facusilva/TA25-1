package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Articulo;
import com.example.demo.service.ArticuloServiceImpl;

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
public class ArticuloController {

	@Autowired
	ArticuloServiceImpl ArticuloServiceImpl;
	
	//listar todos los Articulos
	@GetMapping("/articulos")
	public List<Articulo> listarArticulos(){
		return ArticuloServiceImpl.listarArticulos();
	}
	
	//guardar un Articulo
	@PostMapping("/articulos")
	public Articulo salvarArticulo(@RequestBody Articulo Articulo) {//los datos del Articulo llegan en formato JSON desde el Request Body
		return ArticuloServiceImpl.guardarArticulo(Articulo);
	}
	
	//muestro un Articulo según el ID indicada
	@GetMapping("/articulos/{id}") 
	public Articulo ArticuloXID(@PathVariable(name="id") Long id){ // el id del Articulo llega desde la variable del path
		Articulo Articulo_xid = new Articulo();//creo una instancia de la clase Articulo
		
		Articulo_xid=ArticuloServiceImpl.ArticuloXID(id);//busco el Articulo según el ID y le asigno los datos a la instancia de la clase Articulo
		
		System.out.println("Articulo XID: "+Articulo_xid);
		
		return Articulo_xid;//devuelvo el Articulo en formato JSON
	}
	
	//Actualizo los datos de un Articulo según el ID indicada
	@PutMapping("/articulos/{id}")
	public Articulo actualizarArticulo(@PathVariable(name="id")Long id,@RequestBody Articulo Articulo) {
		
		Articulo Articulo_seleccionado= new Articulo();
		Articulo Articulo_actualizado= new Articulo();
		
		Articulo_seleccionado= ArticuloServiceImpl.ArticuloXID(id);
		
		Articulo_seleccionado.setNombre(Articulo.getNombre());
		Articulo_seleccionado.setPrecio(Articulo.getPrecio());
		Articulo_seleccionado.setFabricante(Articulo.getFabricante());
		
		Articulo_actualizado = ArticuloServiceImpl.actualizarArticulo(Articulo_seleccionado);
		
		System.out.println("El Articulo actualizado es: "+ Articulo_actualizado);
		
		return Articulo_actualizado;
	}
	
	//borro el Articulo indicado por el ID que llega en la variable del path
	@DeleteMapping("/articulos/{id}")
	public void eleiminarArticulo(@PathVariable(name="id")Long id) {
		ArticuloServiceImpl.eliminarArticulo(id);
	}
}
