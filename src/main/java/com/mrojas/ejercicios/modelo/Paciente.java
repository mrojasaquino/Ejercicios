package com.mrojas.ejercicios.modelo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Paciente {

	private int id;
	private String nombre;
	private LocalDateTime fechaNacimiento;
	private int entidadComercialId;
	private boolean tieneAlergias;
	private boolean tieneCondicionesMedicas;
	
}
