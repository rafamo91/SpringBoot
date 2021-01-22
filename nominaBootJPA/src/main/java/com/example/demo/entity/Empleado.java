package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nominas.exceptions.ControlExcepciones;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable{
	

	private static final long serialVersionUID = -3330556621758703583L;
	public Empleado() {
		
	}

	public Empleado(int id, String nombre, String dni, String sexo,int anios, int categoria) throws ControlExcepciones {
		ControlExcepciones comprobar = new ControlExcepciones();
		if ( !comprobar.anyos(anios)) {
			System.out.println("Años incorrectos");
			throw new ControlExcepciones();
		}
		if (!comprobar.categoria(categoria)) {
			System.out.println("Categoria incorrecta");
			throw new ControlExcepciones();
		}
		if (!comprobar.nombre(nombre)) {
			System.out.println("nombre incorrecto");
			throw new ControlExcepciones();
		}
		if (!comprobar.dni(dni)) {
			System.out.println("dni incorrecto");
			throw new ControlExcepciones();
		}
		if (!comprobar.sexo(sexo)) {
			System.out.println("Sexo incorrecto");
			throw new ControlExcepciones();
		}
		this.id=id;
		this.nombre=nombre;
		this.dni=dni;
		this.sexo=sexo;
		this.anios=anios;
		this.categoria=categoria;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="dni")
	private String dni;
	@Column(name="sexo")
	private String sexo;
	@Column(name="anios")
	private int anios;
	@Column(name="categoria")
	private int categoria;
	

	
	
	public int getAnios() {
		return anios;
	}
	public void setAnios(int anios) {
		this.anios = anios;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
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

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", sexo=" + sexo + ", anios=" + anios
				+ ", categoria=" + categoria + "]";
	}
	
}
