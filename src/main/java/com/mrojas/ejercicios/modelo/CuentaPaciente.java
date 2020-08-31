package com.mrojas.ejercicios.modelo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CuentaPaciente {

	private int id;
	private String consecutivo;
	private int pacienteId;
	private int entidadComercialId;
	private LocalDateTime fechaIngreso;
	boolean activa;
}
