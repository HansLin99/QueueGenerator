package UI;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class WebDisplay {

    static String json = "";

    public void displayWelcome() throws IOException {

        BufferedReader br = null;

        try {
            String apikey = "48c4e7336baa1fce57ddcb33b8b107fc";
            String londonweatherquery = "https://api.openweathermap.org/data/2.5/weather?q=Vancouver,ca&APPID=";
            String theURL = londonweatherquery + apikey;
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            json = sb.toString();
            parseJson();

        } finally {

            if (br != null) {
                br.close();
            }
        }
    }


    public void parseJson() {
        JSONObject obj = new JSONObject(json);
        String city = obj.getString("name");
        String country = obj.getJSONObject("sys").getString("country");


        System.out.println("The weather for " + city + ", " + country + " is ");
        printMainWeatherInfo(obj);
        printStatistic(obj);



    }

    private void printMainWeatherInfo(JSONObject jo) {
        JSONArray arr = jo.getJSONArray("weather");
        for (int i = 0; i < arr.length(); i++) {
            System.out.println(arr.getJSONObject(i).getString("main"));

        }

        for (int i = 0; i < arr.length(); i++) {
            System.out.println(arr.getJSONObject(i).getString("description"));
        }
    }

    private void printStatistic(JSONObject jo) {
        JSONObject main = jo.getJSONObject("main");
        JSONObject wind = jo.getJSONObject("wind");
        System.out.println("Temperature: " + main.getDouble("temp"));
        System.out.println("Pressure: " + main.getDouble("pressure"));
        System.out.println("Humidity: " + main.getDouble("humidity"));
        System.out.println("Visibility: " + jo.getDouble("visibility"));
        System.out.println("Wind Speed: " + wind.getDouble("speed"));
        System.out.println("Wind degree: " + wind.getDouble("deg"));
    }
}

