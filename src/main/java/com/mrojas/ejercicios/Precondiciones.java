package com.mrojas.ejercicios;

import com.mrojas.ejercicios.modelo.DataProducer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Precondiciones {

	public static void main(String[] args) {
		comparacionesOriginales();
	}
	
	public static void comparacionesOriginales() {
		DataProducer dp = DataProducer.INSTANCE;
		
		log.info("*** Entidad comercial {}", dp.findEntidadComercialByIdFiscal("ABC-900127"));
		log.info("*** Paciente {}", dp.findPacienteById(20));
	}
}
