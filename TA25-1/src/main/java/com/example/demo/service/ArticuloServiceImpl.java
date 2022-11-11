package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IArticuloDAO;
import com.example.demo.dto.Articulo;

@Service 
public class ArticuloServiceImpl implements IArticuloService{

	@Autowired
	IArticuloDAO iArticuloDAO;
	
	@Override
	public List<Articulo> listarArticulos() {
		// TODO Auto-generated method stub
		return iArticuloDAO.findAll();
	}

	@Override
	public Articulo guardarArticulo(Articulo Articulo) {
		// TODO Auto-generated method stub
			System.out.println("ARTICULO A INSERTAR"+Articulo);
			return iArticuloDAO.save(Articulo); //guardo el nuevo Articulo	
	}

	@Override
	public Articulo ArticuloXID(Long id) {
		// TODO Auto-generated method stub
		return iArticuloDAO.findById(id).get();
	}

	@Override
	public Articulo actualizarArticulo(Articulo Articulo) {
		// TODO Auto-generated method stub
		return iArticuloDAO.save(Articulo);
	}

	@Override
	public void eliminarArticulo(Long id) {
		iArticuloDAO.deleteById(id);
		
	}

}
