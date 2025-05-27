package org.example.Serialización;

import java.io.*;

public class SerializarCarcel {

    public static void main(String[] args) {

        Carcel rosarioPeru = new Carcel(1000,"Rosario - Perú" , 20000);

        try {

            ObjectOutputStream file_serial = new ObjectOutputStream(new FileOutputStream("src/main/resources/carcel.nashe"));
            file_serial.writeObject(rosarioPeru);
            file_serial.close();

        } catch (IOException e) {

            System.out.println("Algo salio mal");
            e.printStackTrace();

        }

        try {

            ObjectInputStream file_read_Carcel = new ObjectInputStream(new FileInputStream("src/main/resources/carcel.nashe"));
            Carcel carcel = (Carcel) file_read_Carcel.readObject();
            System.out.println("Celdas: " + carcel.getCeldas() + ", nombre: " + carcel.getNombre() + ", NumPresos: " + carcel.getNum_Presos());
            System.out.println(carcel.toString());
            file_read_Carcel.close();

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Algo salio mal");
            e.printStackTrace();

        }

    }


}
