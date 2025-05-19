package org.example.Serialización.EjerciciosTeoría;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@ToString
public class Perro implements Serializable {

    private String raza;
    private String nombre;
    private int edad;

}
