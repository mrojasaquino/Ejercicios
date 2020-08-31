package com.mrojas.ejercicios.modelo;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * Modelo de las categorías.
 * @author mrojas
 *
 */
@Data
public class Categoria {

	private int id;
	private String nombre;
	private List<Pregunta> preguntas;
	
}
