package com.mrojas.ejercicios.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.common.base.MoreObjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuentaPaciente {

	private int id;
	private String consecutivo;
	private int pacienteId;
	private int entidadComercialId;
	private LocalDateTime fechaIngreso;
	boolean activa;
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("ID", id)
		.add("Consecutivo", consecutivo)
		.add("Fecha Ingreso", DateTimeFormatter.ISO_DATE.format(fechaIngreso))
		.toString();
	}
}
