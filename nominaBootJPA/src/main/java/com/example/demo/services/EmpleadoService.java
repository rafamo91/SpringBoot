package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Empleado;
import com.example.demo.entity.Nominas;


public interface EmpleadoService {
	
	public List<Empleado> getListaEmpleados();
	public Nominas getSalario(String dni);
	public void modificarEmpleado(Empleado empl);
	public List<Empleado> consultaPersonalizada(ArrayList<String> consultas,String consultaDni);

}
