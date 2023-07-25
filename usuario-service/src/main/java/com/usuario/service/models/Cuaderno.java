package com.usuario.service.models;

public class Cuaderno {

	private String marca;
	private String tamaño;
	private int usuarioId;
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTamaño() {
		return tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	public int getUsuarioId() {
		return usuarioId;
	} 

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Cuaderno() {
		super();
	}

}
