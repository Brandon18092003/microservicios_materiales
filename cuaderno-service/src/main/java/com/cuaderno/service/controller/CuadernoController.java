package com.cuaderno.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuaderno.service.entity.Cuaderno;
import com.cuaderno.service.service.CuadernoService;

@RestController
@RequestMapping("/cuaderno")
public class CuadernoController {

	@Autowired
	private CuadernoService cuadernoService;
	
	@GetMapping
	public ResponseEntity<List<Cuaderno>> listarUsuarios(){
		List<Cuaderno> cuadernos = cuadernoService.getAll();
		if(cuadernos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cuadernos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cuaderno> obtenerCuaderno(@PathVariable("id") int id) {
	    Cuaderno cuaderno = cuadernoService.getCuadernoById(id);
	    if (cuaderno == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(cuaderno);
	}
	
	@PostMapping
	public ResponseEntity<Cuaderno> guardarCuaderno(@RequestBody Cuaderno cuaderno){
		Cuaderno nuevoCuaderno = cuadernoService.save(cuaderno);
		return ResponseEntity.ok(nuevoCuaderno);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Cuaderno>> listarCuadernosPorUsuarioId(@PathVariable("usuarioId") int id){
		List<Cuaderno> cuadernos = cuadernoService.byUsuarioId(id);
		if(cuadernos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cuadernos);
	}
}
