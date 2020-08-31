package com.mrojas.ejercicios.modelo;

import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * Modelo de las categorías.
 * @author mrojas
 *
 */
@Data
//@Builder
public class Categoria {

	private int id;
	private String nombre;
	private List<Pregunta> preguntas;
	
}
