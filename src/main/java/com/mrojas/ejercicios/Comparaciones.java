package com.mrojas.ejercicios;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Comparaciones {

	public static void main(String[] args) {

		String variable = null;


		if(variable != null && variable.equals("Y")) {
			log.info("El valor fue igual a Y");
		} else {
			log.info("El valor no fue igual a Y");
		}


		if("Y".equals(variable)) {
			log.info("El valor fue igual a Y");
		} else {
			log.info("El valor no fue igual a Y");
		}

	}

}
