import java.util.ArrayList;
import java.util.Scanner;

import com.javacode.api.GenerateApi;
import com.javacode.com.javacode.Change.Moneda;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scaner = new Scanner(System.in);
        int monto  = 0;
        System.out.println("aaaaa press any button");
        ArrayList<Moneda> arraydeconversasiones = new ArrayList<>();


        while (true) {
               monto = scaner.nextInt();
            if (monto == 9) {
                System.out.println("tanks");
                break;
            }
            String url = "https://v6.exchangerate-api.com/v6/f254c20d6afbba086f358289/pair/USD/MXN/"+ monto;
            var GenerateApi = new GenerateApi(url);
            var moneda = new Moneda(GenerateApi.camino());
            moneda.setMonto(monto);
            moneda.mosrarMonedas();
            arraydeconversasiones.add(moneda);
            
            System.out.println("Press 9 or any int to convert");
            if (monto == 1) {
                moneda.convertiAjsn(arraydeconversasiones);
                break;
            }

        }
        // for (Moneda moneda : arraydeconversasiones) {
        //     moneda.mosrarMonedas();
            
        // }

        
    }
}
