package com.utn.PersistenciaJPA.repositorios;

import com.utn.PersistenciaJPA.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
