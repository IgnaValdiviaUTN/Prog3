package com.utn.PersistenciaJPA.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido extends BaseEntidad{

    private String fecha;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public enum Estado{
        INICIADO, PREPARACION, ENTREGADO;
    }

    private String horaEstimadaEntrega;

    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    public enum TipoEnvio{
        DELIVERY, RETIRA;
    }

    private double total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallePedido> detalles =new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "factura_id")
    private Factura factura;


    public void agregarDetalle(DetallePedido nuevoDetalle){
        detalles.add(nuevoDetalle);
    }

}
