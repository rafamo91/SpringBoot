package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Empleado;
import com.example.demo.entity.Nominas;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
	
	@Query(value = "SELECT u FROM Nominas u WHERE u.dni = :dni")
	public Nominas ejemplo(@Param("dni") String dni);
	
}
