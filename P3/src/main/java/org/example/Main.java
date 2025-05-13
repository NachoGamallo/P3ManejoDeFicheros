package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {

        //Ex1();
        //Ex2() //Tambien incluye el Ex3;


    }

    public static void Ex1(){

        String path = "src/main/resources/";

        File file = new File(path + "test.txt");

        try{

            if (file.createNewFile()){

                System.out.println("Archivo creado: " + file.getName());

            }else {

                System.out.println("El archivo " + file.getName() + " ya existe.");

            }

        } catch (IOException e) {

            System.out.println("Ha habido algun problema.");
            e.printStackTrace();

        }

    }
    public static void Ex2(){

        File fichero = new File("src/main/resources/ejemplo1.txt");
        File carpeta = new File("src/main/resources");

        try{

            if (fichero.createNewFile()) System.out.println("Archivo creado.");
            else System.out.println("El fichero ya existe.");

        }catch (IOException e){ e.printStackTrace(); }

        System.out.println("Nombre: " + fichero.getName());
        System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
        System.out.println("Longitud: " + fichero.length());

        if (carpeta.mkdir()) System.out.println("Carpeta creada.");
        else System.out.println("La carpeta ya existe.");

    }
    public static void Ex4(){

        System.out.println("Introduce la carpeta en la que quieres introducir los archivos:");
        String folder = entry.next();
        System.out.println("");

    }

}