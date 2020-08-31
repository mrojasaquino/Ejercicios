package com.mrojas.ejercicios.modelo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Paciente {

	private int id;
	private String nombre;
	private LocalDateTime fechaNacimiento;
	private int entidadComercialId;
	private boolean tieneAlergias;
	private boolean tieneCondicionesMedicas;
	
}
