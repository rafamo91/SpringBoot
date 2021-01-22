package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Empleado;
import com.example.demo.entity.Nominas;
import com.example.demo.services.EmpleadoService;

@Controller
public class HomeController {

	@Autowired
	public EmpleadoService empl;

	@GetMapping("")
	public String inicio() {
		return "index";
	}

	@GetMapping("index")
	public String redirect() {
		return "index";
	}
	
	@GetMapping("calcularSalario")
	public String redirectToSalary() {
		return "showSalary";
	}

	@GetMapping("user")
	public String empleadoPage(Model model) {
		model.addAttribute("empleados", empl.getListaEmpleados());
		return "userPage";
	}

	@GetMapping("modifyUser")
	public String modifyPage(Model model) {
		model.addAttribute("empleados", empl.getListaEmpleados());
		return "modifyUser";
	}
	
	@PostMapping("actualizarDatos")
	public String modifyUser(@RequestParam(name = "idM") String consultaId,
			@RequestParam(name = "dniM") String consultaDni,
			@RequestParam(name = "nombreM") String consultaNombre,
			@RequestParam(name = "categoriaM") String consultaCategoria,
			@RequestParam(name = "sexoM") String consultaSexo,
			@RequestParam(name = "aniosM") String consultaAnios,
			Model model) {
		

		Empleado empleado = null;
		try {
			int categoria = Integer.parseInt(consultaCategoria);
			int id = Integer.parseInt(consultaId);
			int anios = Integer.parseInt(consultaAnios);
			empleado = new Empleado(id,consultaNombre,consultaDni,consultaSexo,anios,categoria);
		} catch (Exception e) {
			System.out.println("Error:"+e);
			System.out.println("Error al crear empleado");
		}
		if(empleado!=null) {
			empl.modificarEmpleado(empleado);
			ArrayList<Empleado> emple = new ArrayList<Empleado>();
			emple.add(empleado);
			model.addAttribute("Modifyempleados",emple);
		}
		
		return "modifyUser";
	}
	

	@PostMapping("consultaPersonalizada")
	public String consultaPersonalizada(@RequestParam(name = "consultaDni") String consultaDni,
			@RequestParam(name = "consultaNombre") String consultaNombre,
			@RequestParam(name = "consultaCategoria") String consultaCategoria,
			@RequestParam(name = "consultaSexo") String consultaSexo,
			@RequestParam(name = "consultaAnios") String consultaAnios, Model model) {

		ArrayList<String> consultas = new ArrayList<>();

		if (consultaDni != null) {
			consultas.add(consultaDni);
			consultas.add(consultaNombre);
			consultas.add(consultaCategoria);
			consultas.add(consultaSexo);
			consultas.add(consultaAnios);
		}

		model.addAttribute("Modifyempleados",empl.consultaPersonalizada(consultas, consultaDni));
		return "modifyUser";
	}

	@PostMapping("nominas")
	public String nominas(@RequestParam(name = "dniSalario") String dni, Model model) {
		
		Nominas nom = empl.getSalario(dni);

		model.addAttribute("salario", nom);
		return "showSalary";
	}

}
