package org.example.Serialización;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@ToString

public class Carcel implements Serializable {

    private int celdas;
    private String nombre;
    private transient int Num_Presos;



}
