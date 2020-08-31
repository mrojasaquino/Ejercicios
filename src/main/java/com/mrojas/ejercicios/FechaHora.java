package com.mrojas.ejercicios;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FechaHora {

	public static void main(String[] args) {
		
		fechaHoraAuto();
		
		fechaHoraManual();
//		
		fechaHoraManualCadena();
//		
		operacionesConFechaYHora("2020-11-30T17:20:15");
//		
		formateoFecha("2021-01-01T13:25:59");
	}
	
	
	public static void fechaHoraAuto() {
		LocalDate fecha = LocalDate.now();
		LocalTime hora = LocalTime.now();
		LocalDateTime fechaHora = LocalDateTime.now();
		
		log.info("Fecha        : {}", fecha);
		log.info("Hora         : {}", hora);
		log.info("Fecha y hora : {}", fechaHora);
		log.info("------------------------------------------\n");
	}
	
	
	public static void fechaHoraManual() {
		LocalDate fecha = LocalDate.of(2020, 8, 31);
		LocalTime hora = LocalTime.of(17, 20, 15);
		LocalDateTime fechaHora = LocalDateTime.of(2020, 8, 31, 17, 20, 15);
		
		log.info("Fecha manual        : {}", fecha);
		log.info("Hora manual         : {}", hora);
		log.info("Fecha y hora manual : {}", fechaHora);
		log.info("------------------------------------------\n");
	}
	
	
	public static void fechaHoraManualCadena() {
		// fecha en formato ISO
		LocalDate fecha = LocalDate.parse("2020-08-31");
		LocalTime hora = LocalTime.parse("17:20:15");
		LocalDateTime fechaHora = LocalDateTime.parse("2020-08-31T17:20:15");
		
		log.info("Fecha manual        : {}", fecha);
		log.info("Hora manual         : {}", hora);
		log.info("Fecha y hora manual : {}", fechaHora);
		log.info("------------------------------------------\n");
	}
	
	
	public static void operacionesConFechaYHora(String valor) {
		LocalDateTime fechaHora = LocalDateTime.parse(valor);
		log.info("Fecha y hora manual : {}", fechaHora);
		
		fechaHora = fechaHora.plusDays(2).plusHours(1);
		log.info("Fecha y hora calculada : {}", fechaHora);
		
		
		LocalDateTime ahora = LocalDateTime.now();
		log.info(
				"Dias entre {} y {} = {}", 
				ahora, 
				fechaHora.toLocalDate(),
				ChronoUnit.DAYS.between(ahora.toLocalDate(), fechaHora.toLocalDate())
				);
		
		log.info(
				"Meses entre {} y {} = {}", 
				ahora, 
				fechaHora.toLocalDate(),
				ChronoUnit.MONTHS.between(ahora.toLocalDate(), fechaHora.toLocalDate())
				);
		
		log.info(
				"Segundos entre {} y {} = {}", 
				ahora, 
				fechaHora.toLocalDate(),
				ChronoUnit.SECONDS.between(ahora, fechaHora)
				);
		
		log.info(
				"Periodo entre {} y {} = {}", 
				ahora, 
				fechaHora.toLocalDate(),
				Period.between(ahora.toLocalDate(), fechaHora.toLocalDate())
				);
		
		log.info(
				"Duración entre {} y {} = {}", 
				ahora, 
				fechaHora.toLocalDate(),
				Duration.between(ahora, fechaHora)
				);
		
		log.info("------------------------------------------\n");
	}
	
	
	public static void formateoFecha(String valor) {
		LocalDateTime fechaHora = LocalDateTime.parse(valor);
		
		log.info(
				"*** Locale UK {}",
				fechaHora.format(
						DateTimeFormatter
						.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.UK)
						)
				);
		
		log.info(
				"*** Locale es_MX {}",
				fechaHora.format(
						DateTimeFormatter
						.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("es", "MX"))
						)
				);
		
		log.info(
				"*** Locale GERMANY {}",
				fechaHora.format(
						DateTimeFormatter
						.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.GERMANY)
						)
				);
		
		log.info(
				"*** Custom yyyy/MM/dd HH:mm:ss {}",
				fechaHora.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))
				);
		
		log.info(
				"*** Custom yyyy/MM/dd hh:mm:ss {}",
				fechaHora.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss"))
				);
		
		log.info("------------------------------------------\n");
	}
}
