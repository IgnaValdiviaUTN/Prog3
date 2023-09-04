package com.example.ejerciciobidiUno.repositorios;

import com.example.ejerciciobidiUno.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
