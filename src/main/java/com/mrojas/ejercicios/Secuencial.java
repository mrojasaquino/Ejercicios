package com.mrojas.ejercicios;

import java.util.ArrayList;
import java.util.List;

import com.mrojas.ejercicios.modelo.Categoria;
import com.mrojas.ejercicios.modelo.Pregunta;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Secuencial {

	private List<Categoria> categorias;


	/**
	 * Inicializar el modelo de datos.
	 */
	private void init() {

		categorias = new ArrayList<>();

		int baseIdPregunta = 1000;

		for(int i = 0; i < 10; i++) {

			Categoria categoria = new Categoria();
			categoria.setId(i);
			categoria.setNombre("Categoria " + i);
			categoria.setPreguntas(new ArrayList<Pregunta>());

			log.info("Generando categoría {}", categoria);

			for(int j = 0; j < 100; j++) {
				Pregunta pregunta = new Pregunta();
				pregunta.setId(baseIdPregunta + j);
				pregunta.setCategoriaId(i);
				pregunta.setNombre("Pregunta " + baseIdPregunta + j);
				pregunta.setDirty(j % 4 == 0);
				
				log.info("Agregando pregunta {}", pregunta);
				categoria.getPreguntas().add(pregunta);
			}

			baseIdPregunta += 1000;

			categorias.add(categoria);
		}
	}

	
	private void doIt() {
		
		for(Categoria categoria : categorias) {
			for(Pregunta pregunta : categoria.getPreguntas()) {
				if(pregunta.isDirty()) {
					log.info("*** Procesando pregunta {}", pregunta);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		Secuencial secuencial = new Secuencial();
		
		secuencial.init();
		secuencial.doIt();
	}
}
