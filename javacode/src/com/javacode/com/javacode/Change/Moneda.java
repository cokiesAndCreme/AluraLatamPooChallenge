package com.javacode.com.javacode.Change;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javacode.otherclass.intermd;

public class Moneda {
    private double estadoDeMoneda;
    private double montoConvertido;
    private String monedaAconvertir;
    private String monedaConvertidora;
    private int monto;
    private String time;
    
    public Moneda(intermd a) {
        this.estadoDeMoneda = a.conversion_rate();
        this.montoConvertido = a.conversion_result();
        this.monedaAconvertir = a.base_code();
        this.monedaConvertidora = a.target_code();
    
        LocalDate fechaAct = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaComoString = fechaAct.format(formatter);
        this.time = fechaComoString;

        
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void mosrarMonedas() {

    System.out.println("--------------------------------------------------");
        System.out.println("Cantidad: $"+monto +"\nDe  [" + monedaAconvertir + "] a [" + monedaConvertidora +"] \n"
        + "Estado de moneda: " + estadoDeMoneda + "\n" + "Monto convertido: " +montoConvertido +" \nFecha " + time);
        
    }

    public void convertiAjsn(ArrayList<Moneda> a) throws IOException {
        Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

        FileWriter pajson = new FileWriter("nombre.json");
        try {
            pajson.write(gson.toJson(a));
            pajson.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    

}
