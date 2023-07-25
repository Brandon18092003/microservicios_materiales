package com.usuario.service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario.service.entity.Usuario;
import com.usuario.service.feignclients.CuadernoFeignClient;
import com.usuario.service.feignclients.LibroFeignClient;
import com.usuario.service.models.Cuaderno;
import com.usuario.service.models.Libro;
import com.usuario.service.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
    @Autowired
    private CuadernoFeignClient cuadernoFeignClient;
    
    @Autowired
    private LibroFeignClient libroFeignClient;
    
	
	public List<Usuario> getAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario getUsuarioById(int id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public Usuario save(Usuario usuario) {
		Usuario nuevoUsuario = usuarioRepository.save(usuario);
		return nuevoUsuario;
	}
	
	public Cuaderno saveCuaderno(int usuarioId, Cuaderno cuaderno) {
		cuaderno.setUsuarioId(usuarioId);
		Cuaderno nuevoCuaderno = cuadernoFeignClient.save(cuaderno);
		return nuevoCuaderno;
	}
	
	public Libro saveLibro(int usuarioId, Libro libro) {
		libro.setUsuarioId(usuarioId);
		Libro nuevoLibro = libroFeignClient.save(libro);
		return nuevoLibro;
	}
	
	public Map<String, Object> getUsuarioAndMateriales(int usuarioId){
		Map<String, Object> resultado = new HashMap<>();
		Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
		if(usuario == null) {
			resultado.put("Mensaje", "El usuario no existe");
			return resultado;
		}
		
		resultado.put("Usuario", usuario);
		List<Cuaderno> cuadernos = cuadernoFeignClient.getCuadernos(usuarioId);
		if(cuadernos.isEmpty()) {
			resultado.put("Cuadernos", "El usuario no tiene cuadernos");
		}
		else {
			resultado.put("Cuadernos", cuadernos);
		}
		
		List<Libro> libros = libroFeignClient.getLibros(usuarioId);
		if(libros.isEmpty()) {
			resultado.put("Libros", "El usuario no tiene libros");
		}
		else {
			resultado.put("Libros", libros);
		}
		return resultado;
	}
	
	
}
