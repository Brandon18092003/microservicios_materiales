package com.cuaderno.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuaderno.service.entity.Cuaderno;
import com.cuaderno.service.repository.CuadernoRepository;

@Service
public class CuadernoService {

	@Autowired
	private CuadernoRepository cuadernoRepository;
	
	public List<Cuaderno> getAll(){
		return cuadernoRepository.findAll();
	}
	
	public Cuaderno getCuadernoById(int id) {
		return cuadernoRepository.findById(id).orElse(null);
	}
	
	public Cuaderno save(Cuaderno cuaderno) {
		Cuaderno nuevoCuaderno = cuadernoRepository.save(cuaderno);
		return nuevoCuaderno;
	}
	
	public List<Cuaderno> byUsuarioId(int usuarioId){
		return cuadernoRepository.findByUsuarioId(usuarioId);
	}
}
