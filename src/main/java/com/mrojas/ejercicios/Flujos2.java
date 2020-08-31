package com.mrojas.ejercicios;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.mrojas.ejercicios.modelo.Categoria;
import com.mrojas.ejercicios.modelo.Pregunta;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Flujos2 {

	private Map<Categoria, List<Pregunta>> modeloDatos;


	/**
	 * Inicializar el modelo de datos.
	 */
	private void init() {

		modeloDatos = new LinkedHashMap<>();

		AtomicInteger baseIdPregunta = new AtomicInteger(1000);

		IntStream.range(0, 10).forEach(idxC -> {
			Categoria categoria = new Categoria();
			categoria.setId(idxC);
			categoria.setNombre("Categoria " + idxC);

			List<Pregunta> preguntas = new ArrayList<>(); 
			IntStream.range(0, 100).forEach(idxP -> {
				Pregunta pregunta = new Pregunta();
				pregunta.setId(baseIdPregunta.intValue() + idxP);
				pregunta.setCategoriaId(idxC);
				pregunta.setNombre("Pregunta " + (baseIdPregunta.intValue() + idxP));
				pregunta.setDirty(idxP % 4 == 0);

				preguntas.add(pregunta);
				log.info("Agregando pregunta {}", pregunta);
			});

			modeloDatos.put(categoria, preguntas);
		});

	}


	/**
	 * Guardamos las preguntas afectadas.
	 */
	private void doIt() {
		List<Pregunta> aGuardar = new ArrayList<>();

		modeloDatos.forEach((categoria, preguntas) -> {
			log.info("Procesando categoria {}", categoria.getNombre());

			aGuardar.addAll( 
					preguntas.stream()
					.filter(Pregunta::isDirty)
					.collect(Collectors.toList())
					);
		});

		log.info("*** Total de preguntas a guardar {}", aGuardar.size());
	}




	public static void main(String[] args) {

		Flujos2 flujos = new Flujos2();

		flujos.init();
		flujos.doIt();

	}

}
