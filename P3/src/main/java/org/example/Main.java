package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {

    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {

        //Ex1();
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

        String path = "src/main/resources/";//Ruta del archivo.

        File file = new File(path + "test1.txt");//Archivo a crear

        try{

            if (file.createNewFile()){//Si el archivo se puede crear o ya existe se indica.

                System.out.println("Archivo creado: " + file.getName());

            }else {

                System.out.println("El archivo " + file.getName() + " ya existe.");

            }

        } catch (IOException e) {//Si algo fallara , como que la ruta no existe esto salta

            System.out.println("Ha habido algun problema.");
            e.printStackTrace();

        }

    }
    public static void Ex2(){

        File fichero = new File("src/main/resources/ejemplo1.txt");//Archivo que va a ser afectado.
        File carpeta = new File("src/main/resources");//Ruta del archivo.

        try{

            if (fichero.createNewFile()) System.out.println("Archivo creado.");//Si el archivo no existe se crea
            else System.out.println("El fichero ya existe.");//Si el archivo existe se indica.

        }catch (IOException e){

            System.out.println("Algo salio mal...");
            e.printStackTrace();

        }//Si algo falla, esto salta

        System.out.println("Nombre: " + fichero.getName());//Nombre del fichero
        System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());//Ruta absoluta
        System.out.println("Longitud: " + fichero.length());//Longitud del archivo (contenido)

        if (carpeta.mkdir()) System.out.println("Carpeta creada.");//Si la carpeta existe o no , se indica.
        else System.out.println("La carpeta ya existe.");

    }
    public static void Ex4(){

        System.out.println("Introduce la carpeta en la que quieres introducir los archivos:");
        String folder = entry.next();//Carpeta donde se introducen los archivos
        System.out.println("Introduce la catidad de archivos a introducir:");
        int numFiles = entry.nextInt();//Numeros de archivos a introducir.

        try {

            for (int i = 1 ; i <= numFiles ; i++ ){//Segun el numero indicado por el usuario, se crean x archivos en la ruta indicada.

                File file = new File(folder + "/nombre" + i + ".txt");
                if (file.createNewFile()){//Si el archivo se crea o ya existe, se indica.

                    System.out.println("Archivo creado: " + file.getName());

                }else {

                    System.out.println("El archivo ya existe: " + file.getName());

                }
            }

        }catch (IOException e){//Si ocurre algun error se para la ejecucion.

            System.out.println("Algo salio mal...");
            e.printStackTrace();

        }
    }
    public static void Ex5(String URL, String extension){

        File folder = new File(URL);//Definimos la ruta(path)

        if (folder.isDirectory()){//Si no existe la carpeta se indica , sino genera una lista con todos los archivos de la carpeta.

            File[] files = folder.listFiles();
            if (files != null){//Si la lista esta vacia, se indica , sino se recorre la lista buscando archivos con la extension dada por el usuario.

                for (File file : files){

                    if (file.isFile() && file.getName().endsWith("." + extension)){//Si es un archivo , y tiene nombre + extension indicada se imprime el nombre.

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

        try (BufferedReader read = new BufferedReader(new FileReader(file))){//Declaramos el Buffer para leer el archivo.

            String line;
            int count = 0;

            while ((line = read.readLine()) != null){//Mientras que hayan mas lineas en el archivo seguira el bucle.

                String[] words = line.split(" ");//Creamos un array con las palabras de la linea.
                for (String w : words){

                    if (w.equalsIgnoreCase(word))count++;//Si la palabra actual es igual a la palabra indicada +1 a contador.

                }

            }

            System.out.println("La palabra " + word + " aparece: " + count + " veces.");

        } catch (IOException e){//Si no se encuentra la ruta, esto lo caza para que no pete.

            System.out.println("Ruta erronea");
            e.printStackTrace();
        }
    }
    public static void Ex7(String word){

        System.out.println("Dame la ruta del archivo para buscar la palabra: ");
        String file = entry.next();

        try {

            Scanner wordToSaw = new Scanner(new File(file));//Variable Scanner, para recorrer las palabras del fichero.
            int count = 0;

            while (wordToSaw.hasNext()){//Mientras el archivo tenga palabras, recorremos el contenido de este.

                if ( wordToSaw.next().equalsIgnoreCase(word))count++;//Contador de veces que sale la palabra aumenta si la palabra indicada coincide.

            }

            System.out.println("La palabra " + word + " aparece: " + count + " veces.");

        }catch (FileNotFoundException e){//Si no se encuentra la ruta, esto lo caza para que no pete.

            System.out.println("Ruta erronea...");
            e.printStackTrace();

        }
    }
    public static void Ex8(){

        File file = new File("src/main/resources/ejemploEx8.txt");//Ruta del archivo con el que vamos a interactuar.

        try {

            if (file.createNewFile()){//Si existe crea el archivo o ya existe, se indica.

                System.out.println("Archivo creado");

            }else {

                System.out.println("El archivo ya existe.");

            }

            PrintWriter write = new PrintWriter(file);//Linea para poder escribir dentro del archivo.
            write.println("Este es el fichero " + file.getName());//Pintamos esta linea dentro del fichero.
            write.close();

        }catch (IOException e){//Si estuviera mal la ruta o algo indicado por el usuario , tenemos el catch para que el programa no explote.

            System.out.println("Algo salio mal...");
            e.printStackTrace();

        }
    }
    public static void Ex9(String filePath){

        File file = new File(filePath);//Declaramos el archivo que se indica por el usuario.
        File temp = new File(filePath + ".temp");//Creamos un archivo en esa misma ruta, llamada .temp

        try (BufferedReader read = new BufferedReader(new FileReader(file));
        BufferedWriter write = new BufferedWriter(new FileWriter(temp))){//Creamos los buffer para escribir (temp) /leer (pasado por user) en los ficheros.

            String line;//Definimos la linea.

            while ((line = read.readLine()) != null){//Mientras hayan lineas que recorrer , esto va a recorrer cada una del fichero.

                StringBuilder newLine = new StringBuilder();//Generamos un string builder, para despues agregar a temp
                for (String word : line.split(" ")){//Recorremos como si fuera un array la linea

                    if (!word.isEmpty()){//Si no esta vacio el espacio

                        newLine.append(Character.toUpperCase(word.charAt(0)));//Ponemos el primer caracter de la palabra en mayusculas en el StringBuilder.

                        if (word.length() > 1){//Si la longitud es mas de uno, entonces agregamos todo lo demas a el StringBuilder.

                            newLine.append(word.substring(1));

                        }
                        newLine.append(" ");//Agregamos un espacio por cada palabra recorrida.
                    }

                }
                write.write(newLine.toString().trim());//Si hubieran mas lineas. Debemos agregar esto ya que necesitamos hacer un "salto de linea"
                write.newLine();

            }

        }catch (IOException e){//Si algo no sale como lo esperado, salta.

            System.out.println("Algo salio mal...");
            e.printStackTrace();

        }

        if (file.delete()){//Borramos el archivo original para renombrar el archivo temp

            temp.renameTo(file);
            System.out.println("Archivo modificado correctamente.");

        }else {//Si falla el remplazo (eliminar el original) se indica.

            System.out.println("No se ha podido remplazar el archivo original.");

        }

    }
    public static void Ex10(String file1, String file2, String newFile){

        try (Scanner scannerFile1 = new Scanner(new File(file1));//Creamos el Scanner para recorrer palabra a palabra ambos archivos pasados por el usuario
             Scanner scannerFile2 = new Scanner(new File(file2));
             PrintWriter write = new PrintWriter(new FileWriter(newFile))) {//Vamos a definir tambien esto , para escribir sobre el archivo que vamos a generar.

            while (scannerFile1.hasNext() || scannerFile2.hasNext()){//Mientras alguno de los dos archivos no este vacio, vamos a recorrerlos.
                if (scannerFile1.hasNext())write.print(scannerFile1.next() + " ");//Si no esta vacio, se agrega la siguiente palabra y un espacio (archivo 1).
                if (scannerFile2.hasNext())write.print(scannerFile2.next() + " ");//Si no esta vacio, se agrega la siguiente palabra y un espacio (archivo 2).
            }

            System.out.println("Archivo combinado correctamente.");

        }catch (IOException e){//Si algo sale mal o se indica mal la ruta falla.

            System.out.println("Algo salio mal...");
            e.printStackTrace();

        }

    }

}