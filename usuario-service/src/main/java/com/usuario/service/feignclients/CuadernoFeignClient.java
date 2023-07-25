package com.usuario.service.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usuario.service.models.Cuaderno;

@FeignClient(name = "carro-service",url = "http://localhost:8081")
@RequestMapping("/cuaderno")
public interface CuadernoFeignClient {

	@PostMapping()
	public Cuaderno save(@RequestBody Cuaderno cuaderno);
	
	@GetMapping("usuario/{usuarioId}")
	public List<Cuaderno> getCuadernos(@PathVariable("usuarioId") int usuarioId);
	
}
