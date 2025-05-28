package org.example.Serialización.EjerciciosTeoría.Ex1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ex1 {

    static final String URL = "src/main/resources/Perros.ser";

    public static void main(String[] args) {

        ArrayList<Perro> perros = new ArrayList<>();//Array de los objetos (en este caso perro).

        perros.add(new Perro("Chucho","Dorita",9));
        perros.add(new Perro("Pastor Aleman","Fred",5));

        try {

            ObjectOutputStream file_serial = new ObjectOutputStream(new FileOutputStream("srca/main/resources/Perros.ser"));

            file_serial.writeObject(perros);
            file_serial.close();

        } catch (IOException e) {//Ejercicio 3

            System.out.println("Algo salio mal, creando archivo con valores por defecto");
            try {

                ObjectOutputStream fileDefault = new ObjectOutputStream(new FileOutputStream(URL));//Creamos el objeto con la ruta por defecto
                fileDefault.writeObject(new ArrayList<>(List.of(new Perro("default","default",0))));//Escribimos un objeto Lista con un perro por defecto.
                fileDefault.close();//Cerramos conexion.
            } catch (IOException e1){

                System.out.println("Los valores por defecto son incorrectos. Correguir");

            }

        }

        try {

            ObjectInputStream file_read_serial = new ObjectInputStream(new FileInputStream("src/main/resources/Perros.ser"));

            ArrayList <Perro> listOfDogs = (ArrayList<Perro>) file_read_serial.readObject();

            for ( Perro perro : listOfDogs){

                System.out.println("Raza: " + perro.getRaza() + ", nombre: " + perro.getNombre() + ", Edad: " + perro.getEdad());

            }

            file_read_serial.close();

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Algo salio mal");
            e.printStackTrace();

        }

    }

}
