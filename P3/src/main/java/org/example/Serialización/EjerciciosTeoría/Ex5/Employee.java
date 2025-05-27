package org.example.Serialización.EjerciciosTeoría.Ex5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@ToString
public class Employee implements Serializable {

    private String name;
    private double salary;

}
