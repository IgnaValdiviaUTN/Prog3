package com.example.ejerciciounoaMuchouni.repositorios;

import com.example.ejerciciounoaMuchouni.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
