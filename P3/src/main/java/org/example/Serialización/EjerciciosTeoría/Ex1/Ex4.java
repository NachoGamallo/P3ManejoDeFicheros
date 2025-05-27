package org.example.Serialización.EjerciciosTeoría.Ex1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Ex4 {

    public static void main(String[] args) {

        HashMap<Integer, Perro> dogsPosition = new HashMap<>();

        dogsPosition.put(1 ,new Perro("Chucho","Dorita",9));
        dogsPosition.put(5 ,new Perro("Pastor Aleman","Fred",5));
        dogsPosition.put(2 ,new Perro("Huski","Manolo/",3));
        dogsPosition.put(8 ,new Perro("Chucho","Junior (morci)",11));

        try (ObjectOutputStream serialize = new ObjectOutputStream(new FileOutputStream("src/main/resources/dogsrace.ser"))) {

            serialize.writeObject(dogsPosition);

        }catch (IOException e){

            System.out.println("Algo salio mal...");
            e.printStackTrace();

        }

        try (ObjectInputStream desSerialize = new ObjectInputStream(new FileInputStream("src/main/resources/dogsrace.ser"))) {

            HashMap< Integer, Perro > desSerializeList = (HashMap<Integer, Perro>) desSerialize.readObject();
            desSerializeList.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach( line -> System.out.println("Posicion: " + line.getKey() + ", Perro: " + line.getValue()));

        } catch (IOException | ClassNotFoundException e){

            System.out.println("Algo salio mal...");
            e.printStackTrace();

        }
    }
}//Hacemos una copia, con el Map y lo recorremos como si fuera una lista corriente.
// Podriamos hacer un Map ordenado y luego recorrerlo pero prefiero usar stream que puedo hacer todo a la vez.
 