package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Persona {
	
	public Persona(int id, String nombre, String dni,String sexo) {
		this.id=id;
		this.dni=dni;
		this.sexo=sexo;
	}

	@Id
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="dni")
	private String dni;
	@Column(name="sexo")
	private String sexo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
