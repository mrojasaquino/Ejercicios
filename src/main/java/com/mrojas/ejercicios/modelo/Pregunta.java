package com.mrojas.ejercicios.modelo;

import lombok.Builder;
import lombok.Data;


/**
 * Modelo de pregunta.
 * @author mrojas
 *
 */
@Data
//@Builder
public class Pregunta {

	private int id;
	private int categoriaId;
	private String nombre;
	private boolean dirty;
}
