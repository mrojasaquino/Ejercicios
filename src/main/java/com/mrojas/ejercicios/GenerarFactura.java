package com.mrojas.ejercicios;

import com.google.common.base.MoreObjects;
import com.mrojas.ejercicios.modelo.DataProducer;
import com.mrojas.ejercicios.modelo.EntidadComercial;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenerarFactura {

	private static final DataProducer DP = DataProducer.INSTANCE;
	
	public static void main(String[] args) {
		
		EntidadComercial entidad = DP.findEntidadComercialByIdFiscal("ABC-900127");
		
		log.info("*** Entidad : {}", entidad);
		
		String direccionParaFactura = 
				MoreObjects.firstNonNull(entidad.getDireccionFactura(), entidad.getDireccionFiscal());
		
		log.info("*** Facturar con dirección: {}", direccionParaFactura);
		
	}
}
