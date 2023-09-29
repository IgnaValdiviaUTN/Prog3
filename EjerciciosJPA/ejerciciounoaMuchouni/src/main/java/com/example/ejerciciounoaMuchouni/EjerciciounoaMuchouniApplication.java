package com.example.ejerciciounoaMuchouni;

import com.example.ejerciciounoaMuchouni.entidades.Domicilio;
import com.example.ejerciciounoaMuchouni.entidades.Persona;
import com.example.ejerciciounoaMuchouni.repositorios.DomicilioRepository;
import com.example.ejerciciounoaMuchouni.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EjerciciounoaMuchouniApplication {
	@Autowired
	PersonaRepository personaRepository;


	public static void main(String[] args) {
		SpringApplication.run(EjerciciounoaMuchouniApplication.class, args);
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepo) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");

			Domicilio domicilio1 = Domicilio.builder()
					.calle("Calle 1")
					.numero(123)
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Calle 2")
					.numero(456)
					.build();

			// Crear instancia de Persona y agregar domicilios
			Persona persona = Persona.builder()
					.nombre("Ignacio")
					.apellido("Valdivia")
					.edad(22)
					.build();

			persona.agregarDomicilio(domicilio1);
			persona.agregarDomicilio(domicilio2);


			// Guardar el objeto Persona en la base de datos

			personaRepository.save(persona);


			// Recuperar el objeto Persona desde la base de datos

			Persona personaRecuperada = personaRepository.findById(persona.getId()).orElse(null);


			if (personaRecuperada != null) {
				System.out.println("Nombre: " + personaRecuperada.getNombre());
				System.out.println("Apellido: " + personaRecuperada.getApellido());
				System.out.println("Edad: " + personaRecuperada.getEdad());
				personaRecuperada.mostrarDomicilios();


			}


		};


	}
}