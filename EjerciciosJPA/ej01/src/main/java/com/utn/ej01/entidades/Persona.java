package com.utn.ej01.entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity//califica a la clase, manejada por jpa
@Data//lombok: genera getter & setter
@NoArgsConstructor//lombok: genera contructor vacio
@AllArgsConstructor//lombok: genera contructores con argumentos
@Builder//lombok: patron de diseño
public class Persona implements Serializable{
    @Id//jpa
    @GeneratedValue(strategy = GenerationType.IDENTITY)//estrategia de clave
    private Long id;

    private String nombre;

    private String apellido;

    private int edad;
}



