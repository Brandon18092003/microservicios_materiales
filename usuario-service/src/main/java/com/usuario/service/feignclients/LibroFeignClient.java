package com.usuario.service.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usuario.service.models.Libro;

@FeignClient(name = "libro-service",url = "http://localhost:8082")
@RequestMapping("/libro")
public interface LibroFeignClient {

	@PostMapping()
	public Libro save(@RequestBody Libro libro);
	
	@GetMapping("usuario/{usuarioId}")
	public List<Libro> getLibros(@PathVariable("usuarioId") int usuarioId);
}
