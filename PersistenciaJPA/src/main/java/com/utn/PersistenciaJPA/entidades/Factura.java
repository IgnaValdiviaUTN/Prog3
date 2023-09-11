package com.utn.PersistenciaJPA.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura extends BaseEntidad{

    private String fecha;
    private int numero;
    private Double descuento;

    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    private Double total;

    public enum FormaPago{
        EFECTIVO, MERCADO_PAGO, DEBITO, CREDITO,
    }

    public void calcularTotal(Pedido p){
        total = p.getTotal() - descuento;
    }

}
