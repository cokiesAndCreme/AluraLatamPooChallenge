package com.javacode.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.GsonBuilder;
import com.javacode.otherclass.intermd;

public class GenerateApi {
    String url;
    String a;

    public GenerateApi(String url) {
        this.url = url;
    }
//  https://v6.exchangerate-api.com/v6/f254c20d6afbba086f358289/pair/USD/MXN/500

    public intermd camino() {
        HttpClient client  = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();

        try {
            HttpResponse<String>response = client.send(request, HttpResponse.BodyHandlers.ofString());
            this.a = response.body();
            return transformToGson(a);

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    private intermd transformToGson (String url) {
        var gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

        intermd newUser = gson.fromJson(a, intermd.class);
        return newUser;
 
    }

    
}
