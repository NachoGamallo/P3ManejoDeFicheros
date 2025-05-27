package org.example.Serialización.EjerciciosTeoría.Ex5;

import java.io.*;
import java.util.ArrayList;

public class Ex5 {

    public static void main(String[] args) {

        ArrayList <Employee> employees = new ArrayList<>();

        employees.add(new Employee("Luis", 3000));
        employees.add(new Boss("Ana", 5000, "Recursos Humanos"));
        employees.add(new Boss("Carlos", 5500, "TI"));

        try (ObjectOutputStream serialize = new ObjectOutputStream(new FileOutputStream("src/main/resources/empleados.ser"))){

            serialize.writeObject(employees);

        } catch (IOException e) {

            System.out.println("Algo ha salido mal...");
            throw new RuntimeException(e);

        }

        try (ObjectInputStream desSerialize = new ObjectInputStream(new FileInputStream("src/main/resources/empleados.ser"))){

            ArrayList <Employee> desSerializeList = (ArrayList<Employee>) desSerialize.readObject();

            for (Employee employee : desSerializeList){
                System.out.println(employee.toString());
            }


        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Algo ha salido mal...");
            throw new RuntimeException(e);

        }
    }
}
//Cuando desSerializamos tenemos el contenido de los jefes, pero solo de sus atributos propios no de los extendidos de empleado.