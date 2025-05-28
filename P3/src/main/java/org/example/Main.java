package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {

        //Ex1();
        //Ex2(); //Tambien incluye el Ex3;
        //Ex4();
        //Ex5("pdf");
        //Ex6();
        //Ex7();

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
        System.out.println("Introduce la catidad de archivos a introducir:");
        int numFiles = entry.nextInt();

        try {

            for (int i = 1 ; i <= numFiles ; i++ ){

                File file = new File(folder + "/nombre" + i + ".txt");
                if (file.createNewFile()){

                    System.out.println("Archivo creado: " + file.getName());

                }else {

                    System.out.println("El archivo ya existe: " + file.getName());

                }
            }

        }catch (IOException e){

            System.out.println("Algo salio mal...");
            e.printStackTrace();

        }
    }
    public static void Ex5(String extension){

        System.out.println("Introduce la carpeta en la que buscaremos: ");
        File folder = new File(entry.next());

        if (folder.isDirectory()){

            File[] files = folder.listFiles();
            if (files != null){

                for (File file : files){

                    if (file.isFile() && file.getName().endsWith("." + extension)){

                        System.out.println(file.getName());

                    }
                }
            }else {

                System.out.println("El directorio esta vacio...");

            }

        }else {

            System.out.println("La ruta no existe...");

        }

    }
    public static void Ex6(){

        System.out.println("Dame una palabra a buscar: ");
        String word = entry.next();
        System.out.println("Dame la ruta del archivo para buscar la palabra: ");
        String file = entry.next();

        try {

            File userFile = new File(file);
            Scanner readFile = new Scanner(userFile);
            int count = 0;

            while (readFile.hasNext()){

                if (readFile.next().equalsIgnoreCase(word))count++;

            }

            System.out.println("La palabra " + word + " aparece: " + count + " veces.");

        } catch (FileNotFoundException e){
            System.out.println("Ruta erronea");
            e.printStackTrace();
        }
    }
    public static void Ex7(){

        System.out.println("Dame una palabra a buscar: ");
        String word = entry.next();
        System.out.println("Dame la ruta del archivo para buscar la palabra: ");
        String file = entry.next();

        try {

            Scanner wordToSaw = new Scanner(new File(file));
            int count = 0;

            while (wordToSaw.hasNext()){

                if ( wordToSaw.next().equalsIgnoreCase(word))count++;

            }

            System.out.println("La palabra " + word + " aparece: " + count + " veces.");

        }catch (FileNotFoundException e){

            System.out.println("Ruta erronea...");
            e.printStackTrace();

        }
    }
    public static void Ex8(){

        File file = new File("src/main/resources/ejemplo1.txt");
        File folder = new File("src/main/resources");

        try {

            if (file.createNewFile()){

                System.out.println("Archivo creado");

            }else {

                System.out.println("El archivo ya existe.");

            }

            PrintWriter write = new PrintWriter(file);
            write.println("Este es el fichero " + file.getName());
            write.close();

        }catch (IOException e){

            System.out.println("Algo salio mal...");
            e.printStackTrace();

        }
    }
    public static void Ex9(){}
    public static void Ex10(){}

}