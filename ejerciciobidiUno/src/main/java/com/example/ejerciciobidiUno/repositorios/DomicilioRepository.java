package com.example.ejerciciobidiUno.repositorios;

import com.example.ejerciciobidiUno.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {
}
