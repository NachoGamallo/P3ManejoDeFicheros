package org.example.Serialización.EjerciciosTeoría.Ex1;

import java.io.*;
import java.util.ArrayList;

public class Ex1 {

    public static void main(String[] args) {

        ArrayList<Perro> perros = new ArrayList<>();

        perros.add(new Perro("Chucho","Dorita",9));
        perros.add(new Perro("Pastor Aleman","Fred",5));

        try {

            ObjectOutputStream file_serial = new ObjectOutputStream(new FileOutputStream("src/main/resources/Perros.ser"));

            file_serial.writeObject(perros);
            file_serial.close();

        } catch (IOException e) {//Ejercicio 3

            System.out.println("Algo salio mal");
            e.printStackTrace();

        }

        try {

            ObjectInputStream file_read_serial = new ObjectInputStream(new FileInputStream("src/main/resources/Perros.ser"));

            ArrayList <Perro> listOfDogs = (ArrayList<Perro>) file_read_serial.readObject();

            for ( Perro perro : listOfDogs){

                System.out.println("Raza: " + perro.getRaza() + ", nombre: " + perro.getNombre() + ", Edad: " + perro.getEdad());
                System.out.println(perro.toString());

            }

            file_read_serial.close();

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Algo salio mal");
            e.printStackTrace();

        }

    }

}
