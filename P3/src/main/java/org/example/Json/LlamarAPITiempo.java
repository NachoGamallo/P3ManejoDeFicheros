package org.example.Json;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class LlamarAPITiempo {

    public static void main(String[] args) {

        String url = "https://api.open-meteo.com/v1/forecast?latitude=38.41921088667074&longitude=-0.4464988854601825&current_weather=true";

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
            Tiempo tiempo = gson.fromJson(json_respuesta.toString(),Tiempo.class);

            System.out.println("Temperatura = " + tiempo.currentWeather.temperature);

        } catch ( IOException e) {

            System.out.println("Algo ha ido mal");
            e.printStackTrace();

        }

    }

}
