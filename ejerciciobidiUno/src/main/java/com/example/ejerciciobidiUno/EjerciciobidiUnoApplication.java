package com.example.ejerciciobidiUno;

import com.example.ejerciciobidiUno.entidades.Domicilio;
import com.example.ejerciciobidiUno.entidades.Persona;
import com.example.ejerciciobidiUno.repositorios.DomicilioRepository;
import com.example.ejerciciobidiUno.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EjerciciobidiUnoApplication {
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	DomicilioRepository domicilioRepository;


	public static void main(String[] args) {
		SpringApplication.run(EjerciciobidiUnoApplication.class, args);
		System.out.println("Funciono");
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepository, DomicilioRepository domicilioRepository) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");


			Domicilio domicilio = Domicilio.builder()
					.calle("Besares")
					.numero(635)
					.build();

			Persona persona = Persona.builder()
					.nombre("Ignacio")
					.apellido("Valdivia")
					.edad(22)
					.build();

			// Asocio el domicilio
			persona.setDomicilio(domicilio);

			// Asocio la persona
			domicilio.setPersona(persona);

			// Guardar el objeto Persona en la base de datos

			personaRepository.save(persona);

			// Recuperar el objeto Persona desde la base de datos

			Persona personaRecuperada = personaRepository.findById(persona.getId()).orElse(null);
			if (personaRecuperada != null) {
				System.out.println("Nombre: " + personaRecuperada.getNombre());
				System.out.println("Apellido: " + personaRecuperada.getApellido());
				System.out.println("Edad: " + personaRecuperada.getEdad());
				System.out.println("Calle : " + personaRecuperada.getDomicilio().getCalle());
				System.out.println("Número :" + personaRecuperada.getDomicilio().getNumero());
			}

			System.out.println("......  Muestro la bidireccionalidad.......");
			// Recuperar el objeto Persona desde la base de datos
			Domicilio domicilioRecuperado = domicilioRepository.findById(persona.getId()).orElse(null);
			if (domicilioRecuperado!= null) {
				System.out.println("Nombre: " + domicilioRecuperado.getPersona().getNombre());
				System.out.println("Apellido: " + domicilioRecuperado.getPersona().getApellido());
				System.out.println("Edad: " + domicilioRecuperado.getPersona().getEdad());
				System.out.println("Calle : " + domicilioRecuperado.getCalle());
				System.out.println("Número :" + domicilioRecuperado.getNumero());
			}



		};

	}


}
