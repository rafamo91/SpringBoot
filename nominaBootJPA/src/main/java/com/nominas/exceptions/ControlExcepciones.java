package com.nominas.exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Reune todas las excepciones que debe de tener el objeto empleado
 * @author rafa_
 *
 */
public class ControlExcepciones extends Exception {
	/**
	 * Normas para que el dni sea correcto
	 * 
	 * @param dni
	 * @return
	 */
	public boolean dni(String dni) {
		boolean correcto = true;
		Pattern dniPat = Pattern.compile("\\d{8}[A-Z]");
		Matcher dniMat = dniPat.matcher(dni);
		if (!dniMat.matches()) {
			correcto = datosErroneos();
		}
		return correcto;
	}

	/**
	 * Normas para que el nombre sea correcto
	 * 
	 * @param nombre
	 * @return
	 */
	public boolean nombre(String nombre) {
		boolean correcto = true;
		Pattern nombrePat = Pattern.compile("^([A-Z]{1}[a-z]+[ ]*){1,2}$");
		Matcher nombreMat = nombrePat.matcher(nombre);
		if (!nombreMat.matches()) {
			correcto = false;
		}
		return correcto;
	}

	/**
	 * normas para que el sexo sea correcto
	 * 
	 * @param sexo
	 * @return
	 */
	public boolean sexo(String sexo) {
		boolean correcto = true;
		String sex = String.valueOf(sexo);
		Pattern sexPat = Pattern.compile("[MF]");
		Matcher sexMat = sexPat.matcher(sex);
		if (!sexMat.matches()) {
			correcto = datosErroneos();
		}
		return correcto;
	}

	/**
	 * Normas para que los años sean correctos
	 * 
	 * @param anyos
	 * @return
	 */
	public boolean anyos(int anyos) {
		boolean correcto = true;
		if (anyos < 0) {
			correcto = datosErroneos();
		}
		return correcto;
	}

	/**
	 * Normas para que la categoria sea correcta
	 * 
	 * @param categoria
	 * @return
	 */
	public boolean categoria(int categoria) {
		boolean correcto = true;
		if (categoria < 0 || categoria > 10) {
			correcto = datosErroneos();
		}
		return correcto;
	}

	/**
	 * En caso de datos erroneos, devolvera falso
	 * 
	 * @return
	 */
	private boolean datosErroneos() {
		boolean correcto;
		correcto = false;
		return correcto;
	}

	/**
	 * Mensaje de error personalizado
	 */
	public String getMessage() {
		String error = "Datos no correctos";
		return error;
	}
}
