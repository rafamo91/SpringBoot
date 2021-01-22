package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


/**
 * Es la entidad de la tabla nominas. Los atributos forman las columnas con un id que actua como primary key
 * GeneratedValue est� comentado ya que es la clave for�nea que comparte con la tabla empleados, por lo que no se genera al crear un objeto
 * Contiene la funcion que calcula los sueldos de los empleados
 * @author rafa_
 *
 */


@Component
@Entity
@Table(name="nominas")
public class Nominas {
	
    @Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "dni")
    private String dni;

    @Column(name = "sueldo")
    private int sueldo;

    

    public Nominas() {
    }

    public Nominas(int id, String dni, int sueldo) {
    	this.id = id;
        this.dni = dni;
        this.sueldo = sueldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }


	@Override
	public String toString() {
		return "Nomina [id=" + id + ", dni=" + dni + ", sueldo=" + sueldo + "]";
	}
    
	public int sueldo(int categoria, int anyos) {
		int SUELDO_BASE[] = { 50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000,
	            230000 };
        int sueldo;
        int sueldoBase = SUELDO_BASE[categoria - 1];

        sueldo = sueldoBase + (5000 * anyos);

        return sueldo;
    }

}
