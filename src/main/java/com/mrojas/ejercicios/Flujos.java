package com.mrojas.ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.mrojas.ejercicios.modelo.Categoria;
import com.mrojas.ejercicios.modelo.Pregunta;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Flujos {

	private List<Categoria> modeloDatos;


	/**
	 * Inicializar el modelo de datos.
	 */
	private void init() {

		modeloDatos = new ArrayList<>();

		AtomicInteger baseIdPregunta = new AtomicInteger(1000);

		IntStream.range(0, 10).forEach(idxC -> {
			Categoria categoria = new Categoria();
			categoria.setId(idxC);
			categoria.setNombre("Categoria " + idxC);
			categoria.setPreguntas(new ArrayList<Pregunta>());

			log.info("Generando categoría {}", categoria);

			IntStream.range(0, 100).forEach(idxP -> {
				Pregunta pregunta = new Pregunta();
				pregunta.setId(baseIdPregunta.intValue() + idxP);
				pregunta.setCategoriaId(idxC);
				pregunta.setNombre("Pregunta " + (baseIdPregunta.intValue() + idxP));
				pregunta.setDirty(idxP % 4 == 0);
				
				log.info("Agregando pregunta {}", pregunta);
				categoria.getPreguntas().add(pregunta);
			});

			baseIdPregunta.accumulateAndGet(1000, (x, y) -> x + y);

			modeloDatos.add(categoria);
		});
	}


	/**
	 * Guardamos las preguntas afectadas.
	 */
	private void doIt() {
		List<Pregunta> aGuardar = new ArrayList<>();

		modeloDatos.forEach(
				categoria -> 
				aGuardar.addAll( 
						categoria.getPreguntas().stream()
						.filter(Pregunta::isDirty)
						.collect(Collectors.toList())
						)
				);

		log.info("*** Total de preguntas a guardar {}", aGuardar.size());

	}




	public static void main(String[] args) {

		Flujos flujos = new Flujos();

		flujos.init();
		flujos.doIt();

	}

}
