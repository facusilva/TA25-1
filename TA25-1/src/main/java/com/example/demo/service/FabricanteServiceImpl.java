package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IFabricanteDAO;
import com.example.demo.dto.Fabricante;

@Service 
public class FabricanteServiceImpl implements IFabricanteService{

	@Autowired
	IFabricanteDAO iFabrifcanteDAO;
	
	@Override
	public List<Fabricante> listarFabricantes() {
		// TODO Auto-generated method stub
		return iFabrifcanteDAO.findAll();
	}

	@Override
	public Fabricante guardarFabricante(Fabricante Fabricante) {
		// TODO Auto-generated method stub
			return iFabrifcanteDAO.save(Fabricante); //guardo el nuevo Fabricante	
	}

	@Override
	public Fabricante FabricanteXID(Long id) {
		// TODO Auto-generated method stub
		return iFabrifcanteDAO.findById(id).get();
	}

	@Override
	public Fabricante actualizarFabricante(Fabricante Fabricante) {
		// TODO Auto-generated method stub
		return iFabrifcanteDAO.save(Fabricante);
	}

	@Override
	public void eliminarFabricante(Long id) {
		iFabrifcanteDAO.deleteById(id);
		
	}

}
