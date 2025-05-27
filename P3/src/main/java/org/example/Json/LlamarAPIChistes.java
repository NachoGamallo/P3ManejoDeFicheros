package org.example.Json;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LlamarAPIChistes {

    public static void main(String[] args) {

        String url = "https://v2.jokeapi.dev/joke/Programming?type=single&lang=es";

        URL urlAPI;

        try {
            urlAPI = new URL(url);
            HttpURLConnection connection = ( HttpURLConnection ) urlAPI.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader respuesta = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder json_respuesta = new StringBuilder();
            String linea;

            while ( (linea = respuesta.readLine()) != null){

                json_respuesta.append(linea);

            }

            respuesta.close();

            Gson gson = new Gson();
            Chistes chistes = gson.fromJson(json_respuesta.toString(),Chistes.class);

            System.out.println("chiste = " + chistes.joke);

        } catch (IOException e) {

            System.out.println("Algo ha ido mal");
            e.printStackTrace();

        }

    }

}
