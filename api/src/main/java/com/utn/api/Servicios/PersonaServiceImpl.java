package com.utn.api.Servicios;

import com.utn.api.Entidades.Persona;
import com.utn.api.Repositorios.BaseRepository;
import com.utn.api.Repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {
        @Autowired
        private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository){
            super(baseRepository);
            this.personaRepository = personaRepository;
    }
}
