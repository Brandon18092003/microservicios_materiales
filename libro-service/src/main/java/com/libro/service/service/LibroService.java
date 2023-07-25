package com.libro.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libro.service.entity.Libro;
import com.libro.service.repository.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	public List<Libro> getAll(){
		return libroRepository.findAll();
	}
	
	public Libro getLibroById(int id) {
		return libroRepository.findById(id).orElse(null);
	}
	
	public Libro save(Libro libro) {
		Libro nuevoLibro = libroRepository.save(libro);
		return nuevoLibro;
	}
	
	public List<Libro> byUsuarioId(int usuarioId){
		return libroRepository.findByUsuarioId(usuarioId);
	}
}
