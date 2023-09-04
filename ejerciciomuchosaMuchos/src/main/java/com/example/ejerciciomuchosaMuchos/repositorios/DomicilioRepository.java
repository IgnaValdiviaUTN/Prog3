package com.example.ejerciciomuchosaMuchos.repositorios;

import com.example.ejerciciomuchosaMuchos.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {
}
