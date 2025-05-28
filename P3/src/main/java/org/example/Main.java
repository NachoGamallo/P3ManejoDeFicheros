package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {

    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {

        Ex1();
        //Ex2(); //Tambien incluye el Ex3;
        //Ex4();
        //Ex5("sarc/main/resources/","txt");
        //Ex6("palabras");
        //Ex7("palabra");
        //Ex8();
        //Ex9("src/main/resources/test.txt");
        //Ex10("src/main/resources/testcombinar1.txt","src/main/resources/testcombinar2.txt","src/main/resources/combinado.txt");

    }

    public static void Ex1(){

        String path = "src/main/resources/";

        File file = new File(path + "test1.txt");

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
    public static void Ex5(String URL, String extension){

        File folder = new File(URL);

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
    public static void Ex6(String word){

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
    public static void Ex7(String word){

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

        File file = new File("src/main/resources/ejemploEx8.txt");
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
    public static void Ex9(String filePath){

        File file = new File(filePath);
        File temp = new File(filePath + ".temp");

        try (BufferedReader read = new BufferedReader(new FileReader(file));
        BufferedWriter write = new BufferedWriter(new FileWriter(temp))){

            String line;

            while ((line = read.readLine()) != null){

                StringBuilder newLine = new StringBuilder();
                for (String word : line.split(" ")){

                    if (!word.isEmpty()){

                        newLine.append(Character.toUpperCase(word.charAt(0)));

                        if (word.length() > 1){

                            newLine.append(word.substring(1));

                        }
                        newLine.append(" ");
                    }

                }
                write.write(newLine.toString().trim());
                write.newLine();

            }

        }catch (IOException e){

            System.out.println("Algo salio mal...");
            e.printStackTrace();

        }

        if (file.delete()){

            temp.renameTo(file);
            System.out.println("Archivo modificado correctamente.");

        }else {

            System.out.println("No se ha podido remplazar el archivo original.");

        }

    }
    public static void Ex10(String file1, String file2, String newFile){

        try (Scanner scannerFile1 = new Scanner(new File(file1));
             Scanner scannerFile2 = new Scanner(new File(file2));
             PrintWriter write = new PrintWriter(new FileWriter(newFile))) {

            while (scannerFile1.hasNext() || scannerFile2.hasNext()){
                if (scannerFile1.hasNext())write.print(scannerFile1.next() + " ");
                if (scannerFile2.hasNext())write.print(scannerFile2.next() + " ");
            }

            System.out.println("Archivo combinado correctamente.");

        }catch (IOException e){

            System.out.println("Algo salio mal...");
            e.printStackTrace();

        }

    }

}