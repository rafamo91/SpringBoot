package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Empleado;
import com.example.demo.entity.Nominas;
import com.example.demo.repositories.EmpleadoRepository;




@Service
public class JPAEmpleado implements EmpleadoService{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> getListaEmpleados() {
		return empleadoRepository.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public Nominas getSalario(String dni) {
		return empleadoRepository.ejemplo(dni);
	}

	@Override
	@Transactional(readOnly = false)
	public void modificarEmpleado(Empleado empl) {
		em.merge(empl);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Empleado> consultaPersonalizada(String consultas) {
		if (consultas.length() <= 0) {
			return em.createQuery("from Empleado").getResultList();
		} else {
			return em.createQuery("from Empleado where " + consultas).getResultList();
		}
	}

	@Override
	public List<Empleado> consultaPersonalizada(ArrayList<String> consultas,String consultaDni) {
		String consultaPersonalizada = "";
		String consultaReparada = "";
		String[] parametros = { "dni='", "nombre='", "categoria='", "sexo='", "anios='" };
		
		for (int i = 0; i < consultas.size(); i++) {
			switch (consultas.get(i)) {
			case "": {
				break;
			}
			default:
				consultaReparada = comprobarParametros(consultas, i, parametros[i]);
				consultas.set(i, consultaReparada);
			}
		}

		for (String string : consultas) {
			consultaPersonalizada = consultaPersonalizada + string;
		}
		
		System.out.println(consultaPersonalizada);		
		
		return consultaPersonalizada(consultaPersonalizada);
	}
	

	
	private String comprobarParametros(ArrayList<String> consultas, int i, String atributo) {
		String consultaCustom = "";
		boolean comprobar;
		comprobar = false;
		for (int index = i; index < consultas.size() - 1; index++) {
			if (consultas.get(index + 1) != "") {
				consultaCustom = atributo + consultas.get(i) + "' and ";
				comprobar = true;
			}
		}
		if (comprobar == false) {
			consultaCustom = atributo + consultas.get(i) + "'";
		}
		return consultaCustom;
	}
}
