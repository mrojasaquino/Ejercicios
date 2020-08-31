package com.mrojas.ejercicios.modelo;

import lombok.Data;

@Data
public class EntidadComercial {

	private int id;
	private String idFiscal;
	private String nombre;
	private String direccionFiscal;
	private String direccionFactura;
	
}
