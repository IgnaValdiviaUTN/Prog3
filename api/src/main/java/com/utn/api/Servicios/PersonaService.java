package com.utn.api.Servicios;

import com.utn.api.Entidades.Persona;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PersonaService extends BaseService<Persona,Long> {
//Si se necesitan metodos especificos se crea la clase implements

    List<Persona> search(String filtro) throws Exception;
}
