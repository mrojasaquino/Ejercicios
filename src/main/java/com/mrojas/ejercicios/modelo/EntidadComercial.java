package com.mrojas.ejercicios.modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EntidadComercial {

	private int id;
	private String idFiscal;
	private String nombre;
	private String direccionFiscal;
	private String direccionFactura;
	
}
