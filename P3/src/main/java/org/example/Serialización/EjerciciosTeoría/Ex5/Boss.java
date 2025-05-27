package org.example.Serialización.EjerciciosTeoría.Ex5;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Boss extends Employee{

    private String department;

    public Boss(String name, double salary, String department) {

        super(name, salary);
        this.department = department;

    }
}
