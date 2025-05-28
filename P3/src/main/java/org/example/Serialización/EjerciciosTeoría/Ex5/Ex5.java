package org.example.Serialización.EjerciciosTeoría.Ex5;

import java.io.*;
import java.util.ArrayList;

public class Ex5 {

    public static void main(String[] args) {

        ArrayList <Employee> employees = new ArrayList<>();//Definimos una lista de empleados.

        employees.add(new Employee("Luis", 3000));
        employees.add(new Boss("Ana", 5000, "Recursos Humanos"));
        employees.add(new Boss("Carlos", 5500, "TI"));//Agregamos ejemplos a esta lista.

        try (ObjectOutputStream serialize = new ObjectOutputStream(new FileOutputStream("src/main/resources/empleados.ser"))){//Serializamos la ruta especificada.

            serialize.writeObject(employees);//Hacemos writeObjet para ingresar los datos de la lista de empleados.

        } catch (IOException e) {//Si algo saliera mal,

            System.out.println("Algo ha salido mal...");
            throw new RuntimeException(e);

        }

        try (ObjectInputStream desSerialize = new ObjectInputStream(new FileInputStream("src/main/resources/empleados.ser"))){//Desserializamos la ruta especifiac para leer el archivo.

            ArrayList <Employee> desSerializeList = (ArrayList<Employee>) desSerialize.readObject();//Indicamos el tipo de dato que tiene el archivo.

            for (Employee employee : desSerializeList){//Recorremos lista de con formato de fichero.
                System.out.println(employee.toString());//Imprimimos la info.
            }


        } catch (IOException | ClassNotFoundException e) {//Si algo sale mal, 

            System.out.println("Algo ha salido mal...");
            throw new RuntimeException(e);

        }
    }
}
//Cuando desSerializamos tenemos el contenido de los jefes, pero solo de sus atributos propios no de los extendidos de empleado.