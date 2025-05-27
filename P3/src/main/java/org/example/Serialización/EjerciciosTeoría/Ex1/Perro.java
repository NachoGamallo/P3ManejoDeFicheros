package org.example.Serialización.EjerciciosTeoría.Ex1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@ToString
public class Perro implements Serializable {

    private transient String raza; //Ejercicio 2
    private String nombre;
    private int edad;

}
