package com.aluracursos.conversorapp.consultas;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

import com.aluracursos.conversorapp.modelos.Moneda;
import com.google.gson.Gson;

public class ConsultaApi {
    public Moneda buscaMoneda(String monedaDeOrigen, String monedaDeDestino, double montoAConvertir){
        //Traigo la apikey desde mi carpeta resources
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar el archivo de configuración", e);
        }

        String apiKey = prop.getProperty("apiKey");

        URI api_url = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" +
                monedaDeOrigen + "/" +
                monedaDeDestino + "/" +
                montoAConvertir);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(api_url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo encontrar la moneda, hubo un error: ", e);
        }
    }
}
