package eduit.learning.demo.consumowebapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/PrimeraAplicacionWeb/api/demo/get/json/23");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("Ocurrió un error al intentar hacer la petición: " + conn.getResponseCode());
            }

            InputStreamReader sr = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(sr);

            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            
            conn.disconnect();
        } catch (Exception ex) {

        }
    }

}
