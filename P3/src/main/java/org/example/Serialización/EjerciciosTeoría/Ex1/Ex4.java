package org.example.Serialización.EjerciciosTeoría.Ex1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Ex4 {

    public static void main(String[] args) {

        HashMap<Integer, Perro> dogsPosition = new HashMap<>();//Declaramos el map

        dogsPosition.put(1 ,new Perro("Chucho","Dorita",9));
        dogsPosition.put(5 ,new Perro("Pastor Aleman","Fred",5));
        dogsPosition.put(2 ,new Perro("Huski","Manolo/",3));
        dogsPosition.put(8 ,new Perro("Chucho","Junior (morci)",11));//Ingresos de prueba de perros.

        try (ObjectOutputStream serialize = new ObjectOutputStream(new FileOutputStream("src/main/resources/dogsrace.ser"))) {//Serializamos el archivo en ruta.

            serialize.writeObject(dogsPosition);//Ingresamos los datos definidos en el MAP.

        }catch (IOException e){//Si salta algun error

            System.out.println("Algo salio mal...");
            e.printStackTrace();

        }

        try (ObjectInputStream desSerialize = new ObjectInputStream(new FileInputStream("src/main/resources/dogsrace.ser"))) {//Deserializamos el archivo, para poder imprimir la informacion.

            HashMap< Integer, Perro > desSerializeList = (HashMap<Integer, Perro>) desSerialize.readObject();//Indicamos el objeto a deserializar
            desSerializeList.entrySet().stream()//Recorremos la lista de estos, y con sorted indicando a la key. Ordenamos por valor.
                    .sorted(Map.Entry.comparingByKey())
                    .forEach( line -> System.out.println("Posicion: " + line.getKey() + ", Perro: " + line.getValue()));//Imprimimos la informacion.

        } catch (IOException | ClassNotFoundException e){//Si algo sale mal salta.

            System.out.println("Algo salio mal...");
            e.printStackTrace();

        }
    }
}//Hacemos una copia, con el Map y lo recorremos como si fuera una lista corriente.
// Podriamos hacer un Map ordenado y luego recorrerlo pero prefiero usar stream que puedo hacer todo a la vez.
 