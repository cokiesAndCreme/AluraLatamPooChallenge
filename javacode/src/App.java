import java.util.ArrayList;
import java.util.Scanner;

import com.javacode.api.GenerateApi;
import com.javacode.com.javacode.Change.Moneda;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scaner = new Scanner(System.in);
        int monto  = 0;
        String monedaDeOrigen;
        String monedaDeDestino;
        String controlador;
        ArrayList<Moneda> arraydeconversasiones = new ArrayList<>();
        System.out.println("Escriba el monto a convertir "+"\n Contries suported:"+"\n USD,MXN,ARS,EUR,JPY,COP,CAD,BRL");


        while (true) {
               monto = scaner.nextInt();
               scaner.nextLine();
               
            System.out.println("Conversion de " + monto + "\n De: Escribe la moneda de origen" );
            monedaDeOrigen = scaner.nextLine();
            
          
            System.out.println("Escriba la moneda de destino");
            monedaDeDestino = scaner.nextLine();
         

            var GenerateApi = new GenerateApi(monedaDeOrigen.toUpperCase(),monedaDeDestino.toUpperCase(),monto);
            var moneda = new Moneda(GenerateApi.camino());
            moneda.setMonto(monto);
            moneda.mosrarMonedas();
            arraydeconversasiones.add(moneda);
            
            System.out.println("write exit or write generar .json or pres any key for continue");
            
            controlador = scaner.nextLine();
            
            if (controlador.equals("exit")) {
                System.out.println("tanks");
                break;
            }else if (controlador.equals("generar")){
                moneda.convertiAjsn(arraydeconversasiones);
                break;
            }
            
            System.out.println("da otra cantidad "+"\n Contries suported:"+"\n USD,MXN,ARS,EUR,JPY,COP,CAD,BRL");

        }
        
        // var GenerateApi = new GenerateApi("ARS","EUR",1500);
        // var moneda = new Moneda(GenerateApi.camino());
        //     moneda.setMonto(1500);
        //     moneda.mosrarMonedas();

        
    }
}
