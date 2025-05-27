package org.example.Json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializarJSON {

    public static void main(String[] args) {

        Gson gson= new GsonBuilder().setPrettyPrinting().create();

        DatosCurso datos = new DatosCurso("1DAM","IES MUTXAMEL", Arrays.asList("Jose","David","Nacho"));

        String json = gson.toJson(datos);

        System.out.println(json);

        try (FileWriter file = new FileWriter("src/main/resources/datos.json")){

            gson.toJson(datos,file);

        } catch (IOException e) {

            System.out.println("Algo ha ido mal");
            e.printStackTrace();

        }

        //DESERIALIZAR
        //1 opc: string to object
        DatosCurso datosCurso = gson.fromJson(json,DatosCurso.class);
        System.out.println(datosCurso.getCurso() + " " + datosCurso.getInstituto() + datosCurso.getListaAlumnos());

        //2 opc: json file to object
        try {

            FileReader datosLeidos = new FileReader("src/main/resources/datos.json");
            DatosCurso datosCurso2 = gson.fromJson(datosLeidos,DatosCurso.class);
            System.out.println(datosCurso2.getCurso() + " " + datosCurso2.getInstituto() + datosCurso2.getListaAlumnos());

        } catch (IOException e) {

            System.out.println("Algo salio mal");
            e.printStackTrace();

        }

        List <DatosCurso> listaDatos = new ArrayList<>();
        listaDatos.add(new DatosCurso("1DAW","IES SANVICENTE",Arrays.asList("Victor","Roberto","Paula","Edgar")));
        listaDatos.add(new DatosCurso("1DAM","IES MUTXAMEL", Arrays.asList("Jose","David","Nacho")));

        Gson gson_list = new GsonBuilder().setPrettyPrinting().create();
        String json_list = gson_list.toJson(listaDatos);
        System.out.println(json_list);



    }

}
