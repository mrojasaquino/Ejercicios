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
public class Flujos3 {

//	private Map<Categoria, List<Pregunta>> modeloDatos;
//
//
//	/**
//	 * Inicializar el modelo de datos.
//	 */
//	private void init() {
//
//		modeloDatos = new LinkedHashMap<>();
//
//		AtomicInteger baseIdPregunta = new AtomicInteger(1000);
//
//		IntStream.range(0, 10).forEach(idxC -> {
//			Categoria categoria = 
//					Categoria.builder()
//					.id(idxC)
//					.nombre("Categoria " + idxC).build();
//					
//			List<Pregunta> preguntas = new ArrayList<>(); 
//			IntStream.range(0, 100).forEach(idxP -> {
//				Pregunta pregunta =
//						Pregunta.builder()
//						.id(baseIdPregunta.intValue() + idxP)
//						.categoriaId(idxC)
//						.nombre("Pregunta " + (baseIdPregunta.intValue() + idxP))
//						.dirty(idxP % 4 == 0).build();
//				
//				preguntas.add(pregunta);
//				log.info("Agregando pregunta {}", pregunta);
//			});
//
//			modeloDatos.put(categoria, preguntas);
//
//		});
//
//	}
//
//
//	/**
//	 * Guardamos las preguntas afectadas.
//	 */
//	private void doIt() {
//		List<Pregunta> aGuardar = new ArrayList<>();
//
//		modeloDatos.forEach((categoria, preguntas) -> {
//			log.info("Procesando categoria {}", categoria.getNombre());
//
//			aGuardar.addAll( 
//					preguntas.stream()
//					.filter(Pregunta::isDirty)
//					.collect(Collectors.toList())
//					);
//		});
//
//
//		log.info("*** Total de preguntas a guardar {}", aGuardar.size());
//
//	}
//
//
//
//
//	public static void main(String[] args) {
//
//		Flujos3 flujos = new Flujos3();
//
//		flujos.init();
//		flujos.doIt();
//
//	}

}
