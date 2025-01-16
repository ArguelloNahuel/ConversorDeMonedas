import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class MonedaConverter {

    private static final String API_KEY = "49a3ece97b41aa410f6152a5";
    private static final String URL_API = "https://api.exchangerate-api.com/v4/latest/MXN"; //

    public static double obtenerTasaDeCambio(String monedaDestino) {
        try {

            URL url = new URL(URL_API);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject rates = jsonResponse.getJSONObject("rates");


            return rates.getDouble(monedaDestino);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static double convertirMoneda(double cantidad, String monedaDestino) {
        double tasa = obtenerTasaDeCambio(monedaDestino);
        if (tasa == -1) {
            System.out.println("Error al obtener la tasa de cambio.");
            return -1;
        }
        return cantidad * tasa;
    }
}

