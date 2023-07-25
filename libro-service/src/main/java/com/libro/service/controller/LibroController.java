package com.libro.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libro.service.entity.Libro;
import com.libro.service.service.LibroService;


@RestController
@RequestMapping("/libro")
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@GetMapping
	public ResponseEntity<List<Libro>> listarUsuarios(){
		List<Libro> libros = libroService.getAll();
		if(libros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(libros);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Libro> obtenerLibro(@PathVariable("id") int id) {
	    Libro libro = libroService.getLibroById(id);
	    if (libro == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(libro);
	}
	
	@PostMapping
	public ResponseEntity<Libro> guardarLibro(@RequestBody Libro libro){
		Libro nuevoLibro = libroService.save(libro);
		return ResponseEntity.ok(nuevoLibro);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Libro>> listarLibrosPorUsuarioId(@PathVariable("usuarioId") int id){
		List<Libro> libros = libroService.byUsuarioId(id);
		if(libros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(libros);
	}
}
