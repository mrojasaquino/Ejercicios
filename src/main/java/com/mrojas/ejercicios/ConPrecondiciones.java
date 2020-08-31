package com.mrojas.ejercicios;

import com.google.common.base.Preconditions;
import com.mrojas.ejercicios.modelo.CuentaPaciente;
import com.mrojas.ejercicios.modelo.DataProducer;
import com.mrojas.ejercicios.modelo.Paciente;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConPrecondiciones {

	private static final DataProducer DP = DataProducer.INSTANCE;


	public static void main(String[] args) {
		try {
			generarCargo();
		} catch (Exception e) {
			log.error("*** Al procesar información ...", e);
		}

		try {
			aplicarMedicamentoValidarAlergia();
		} catch (Exception e) {
			log.error("*** Al procesar información ...", e);
		}
	}


	private static void generarCargo() {
		//obtener cuenta paciente activa para generarle un cargo
		CuentaPaciente ctaPac = DP.findCuentaActivaForPacienteId(70);

		Preconditions.checkArgument(ctaPac != null, "El paciente no tiene una cuenta paciente activa.");
		Preconditions.checkArgument(ctaPac.getEntidadComercialId() > 0, "La cuenta paciente no tiene una entidad comercial asociada.");

		log.info("*** Vamos a generar el cargo");
	}


	private static void aplicarMedicamentoValidarAlergia() throws Exception {
		//obtener cuenta paciente activa para generarle un cargo
		CuentaPaciente ctaPac = DP.findCuentaActivaForPacienteId(10);
		Preconditions.checkArgument(ctaPac != null, "El paciente no tiene una cuenta paciente activa.");

		//vamos a validar que el paciente no tenga alergias
		Paciente paciente = DP.findPacienteById(10);
		Preconditions.checkArgument(!paciente.isTieneAlergias(), "El paciente tiene alergias ...");

		// aplicamos el medicamento
		log.info(
				"*** Vamos a aplicar el medicamento al paciente {} con cuenta {}", 
				paciente.getNombre(),
				ctaPac.getConsecutivo()
				);
	}
}
