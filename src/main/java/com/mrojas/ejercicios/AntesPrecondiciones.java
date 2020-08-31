package com.mrojas.ejercicios;

import com.mrojas.ejercicios.modelo.CuentaPaciente;
import com.mrojas.ejercicios.modelo.DataProducer;
import com.mrojas.ejercicios.modelo.EntidadComercial;
import com.mrojas.ejercicios.modelo.Paciente;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AntesPrecondiciones {

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
		int entidadComercialId;

		log.info("*** Cuenta paciente : {}", ctaPac);
		
		if(ctaPac == null) {
			throw new IllegalArgumentException("El paciente no tiene una cuenta paciente activa.");
		} else {
			//vamos revisar si tiene entidad comercial asociada
			if(ctaPac.getEntidadComercialId() <= 0) {
				
				//no tiene, recuperamos la asociada al paciente
				EntidadComercial entidad = DP.findEntidadComercialForPacienteId(ctaPac.getPacienteId());
				
				if(entidad == null) {
					throw new IllegalStateException("El paciente no tiene una entidad comercial asociada.");
				} else {
					entidadComercialId = entidad.getId();
				}
			} else {
				entidadComercialId = ctaPac.getEntidadComercialId();
			}
			
			log.info("*** Vamos a generar el cargo con la entidad comercial {}", entidadComercialId);
			
		}
	}


	private static void aplicarMedicamentoValidarAlergia() throws Exception {
		//obtener cuenta paciente activa )para generarle un cargo
		CuentaPaciente ctaPac = DP.findCuentaActivaForPacienteId(10);

		log.info("*** Cuenta paciente : {}", ctaPac);
		
		if(ctaPac == null) {
			throw new IllegalArgumentException("El paciente no tiene una cuenta paciente activa.");
		} else {
			//vamos a validar que el paciente no tenga alergias
			Paciente paciente = DP.findPacienteById(10);
			
			if(paciente.isTieneAlergias()) {
				throw new Exception("El paciente tiene alergias ...");
			} else {
				// aplicamos el medicamento
				log.info(
						"*** Vamos a aplicar el medicamento al paciente {} con cuenta {}", 
						paciente.getNombre(),
						ctaPac.getConsecutivo()
						);
			}
		}
	}
}
