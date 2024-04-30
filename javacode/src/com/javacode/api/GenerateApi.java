package com.javacode.api;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.google.gson.GsonBuilder;
import com.javacode.otherclass.intermd;

public class GenerateApi {
    String rsp;//body del req
    String monedaDeOrigen; //moneda de origen
    String monedaDeDestino; //moneda de destino
    int monto;

    public GenerateApi(String de, String amo,int monto) {
        this.monedaDeDestino = amo;
        this.monedaDeOrigen = de;
        this.monto = monto;
    }
//  https://v6.exchangerate-api.com/v6/f254c20d6afbba086f358289/pair/USD/MXN/500
    public intermd camino() {
        URI urlcondif = URI.create("https://v6.exchangerate-api.com/v6/f254c20d6afbba086f358289/pair/" + monedaDeOrigen + "/" + monedaDeDestino +"/" + monto );
        
        // String urlCompres = "https://v6.exchangerate-api.com/v6/f254c20d6afbba086f358289/pair/USD/MXN/500";
        HttpClient client  = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(urlcondif)
        .GET()
        .build();

        try {
            HttpResponse<String>response = client.send(request, HttpResponse.BodyHandlers.ofString());
            this.rsp= response.body();
            return transformToGson(rsp);

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("moneda no encontrada");
            return null;
        }
        
    }

    private intermd transformToGson (String url) {
        var gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

        intermd newUser = gson.fromJson(url, intermd.class);
        return newUser;
 
    }

    
}
