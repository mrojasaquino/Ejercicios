package com.mrojas.ejercicios.modelo;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

public enum DataProducer {

	INSTANCE;

	private Map<String, EntidadComercial> entidadesComerciales = new HashMap<>();
	private Map<Integer, Paciente> pacientes = new HashMap<>();
	private Map<Integer, List<CuentaPaciente>> cuentas = new HashMap<>();
	

	private DataProducer() {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private void init() throws IOException {
		loadEntidadComercial();
		loadPacientes();
		loadCuentasPaciente();
	}


	private void loadEntidadComercial() throws IOException {
		
		Gson gson = new Gson();

		try(Reader reader = Files.newBufferedReader(Paths.get("entidad_comercial.json"))) {
			List<EntidadComercial> entidades = 
					gson.fromJson(reader, new TypeToken<List<EntidadComercial>>(){}.getType());
			
			entidades.forEach(entidad -> entidadesComerciales.put(entidad.getIdFiscal(), entidad));

		} catch (IOException e) {
			throw e;
		}
	}
	
	private void loadPacientes() throws IOException {
		Gson gson = new GsonBuilder().registerTypeAdapter(
				LocalDateTime.class, 
				(JsonDeserializer<LocalDateTime>)(json, type, jsonDeserializationContext) -> 
					LocalDateTime.parse(json.getAsJsonPrimitive().getAsString())
				).create();

		try(Reader reader = Files.newBufferedReader(Paths.get("paciente.json"))) {
			List<Paciente> entidades = 
					gson.fromJson(reader, new TypeToken<List<Paciente>>(){}.getType());
			
			entidades.forEach(paciente -> pacientes.put(paciente.getId(), paciente));
		} catch (IOException e) {
			throw e;
		}
	}
	
	private void loadCuentasPaciente() throws IOException {
		Gson gson = new GsonBuilder().registerTypeAdapter(
				LocalDateTime.class, 
				(JsonDeserializer<LocalDateTime>)(json, type, jsonDeserializationContext) -> 
					LocalDateTime.parse(json.getAsJsonPrimitive().getAsString())
				).create();

		try(Reader reader = Files.newBufferedReader(Paths.get("cuenta_paciente.json"))) {
			List<CuentaPaciente> entidades = 
					gson.fromJson(reader, new TypeToken<List<CuentaPaciente>>(){}.getType());
			
			entidades.forEach(cuenta -> {
				if(!cuentas.containsKey(cuenta.getPacienteId())) {
					cuentas.put(cuenta.getPacienteId(), new ArrayList<>());
				}
				
				cuentas.get(cuenta.getPacienteId()).add(cuenta);
			});

		} catch (IOException e) {
			throw e;
		}
	}
	
	
	public EntidadComercial findEntidadComercialByIdFiscal(String idFiscal) {
		return entidadesComerciales.get(idFiscal);
	}
	
	public Paciente findPacienteById(int id) {
		return pacientes.get(id);
	}
	
	public CuentaPaciente findCuentaActivaForPacienteId(int pacienteId) {
		AtomicReference<CuentaPaciente> retVal = new AtomicReference<>();
		
		if(cuentas.containsKey(pacienteId)) {
			cuentas.get(pacienteId)
			.stream().filter(CuentaPaciente::isActiva).findFirst().ifPresent(cuenta -> retVal.set(cuenta));
		}
		
		return retVal.get();
	}
}
