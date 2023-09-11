package com.utn.PersistenciaJPA.repositorios;

import com.utn.PersistenciaJPA.entidades.ConfiguracionGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionGeneralRepository extends JpaRepository<ConfiguracionGeneral,Long> {
}
