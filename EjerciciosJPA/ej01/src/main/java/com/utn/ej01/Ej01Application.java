package com.utn.ej01;

import com.utn.ej01.entidades.Persona;
import com.utn.ej01.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ej01Application {

	@Autowired
	PersonaRepository personaRepository;

	public static void main(String[] args) {

		SpringApplication.run(Ej01Application.class, args);
		System.out.println("Estoy funcionando");
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepo) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");
			Persona persona = new Persona();
			persona.setNombre("Ignacio");
			persona.setApellido("Valdivia");
			persona.setEdad(22);

			// Guardar el objeto Persona en la base de datos
			// PersonaRepository personaRepository = context.getBean(PersonaRepository.class);
			personaRepository.save(persona);

			// Recuperar el objeto Persona desde la base de datos
			Persona personaRecuperada = personaRepository.findById(persona.getId()).orElse(null);
			if (personaRecuperada != null) {
				System.out.println("Nombre: " + personaRecuperada.getNombre());
				System.out.println("Apellido: " + personaRecuperada.getApellido());
				System.out.println("Edad: " + personaRecuperada.getEdad());
			}

		};

	}


}
