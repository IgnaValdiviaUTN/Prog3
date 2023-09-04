package com.example.ejerciciomuchosaMuchos.repositorios;

import com.example.ejerciciomuchosaMuchos.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
