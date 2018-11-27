package UI;

import org.json.JSONArray;
import org.json.JSONObject;


import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.UnknownHostException;


public class WebDisplay extends JPanel {

    static String jsonWeather = "";

    public WebDisplay() throws IOException {

        BufferedReader br = null;

        try {
            String apiKey = "48c4e7336baa1fce57ddcb33b8b107fc";
            String londonWeatherQuery = "https://api.openweathermap.org/data/2.5/weather?q=Vancouver,ca&APPID=";
            String theURL = londonWeatherQuery + apiKey;
            URL url = new URL(theURL);


            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            jsonWeather = sb.toString();

        } catch (UnknownHostException e){
            System.out.println("Internet Error!");
        }
        finally {

            if (br != null) {
                br.close();
            }
        }
    }


    public String parseJson() {
        JSONObject obj = new JSONObject(jsonWeather);
        String city = obj.getString("name");
        String country = obj.getJSONObject("sys").getString("country");
        StringBuilder weatherForecast;
        weatherForecast = new StringBuilder("The weather for " + city + ", " + country + " is " + "\n");
        weatherForecast.append(printStatistic(obj));
        return weatherForecast.toString();


    }


    private String printStatistic(JSONObject jo) {
        String weather;
        String weatherPiece1 = "";
        String weatherPiece2 = "";
        JSONArray arr = jo.getJSONArray("weather");
        JSONObject main = jo.getJSONObject("main");
        JSONObject wind = jo.getJSONObject("wind");
        for (int i = 0; i < arr.length(); i++) {
            weatherPiece1 = arr.getJSONObject(i).getString("main");

        }

        for (int i = 0; i < arr.length(); i++) {
            weatherPiece2 = arr.getJSONObject(i).getString("description");
        }
        weather = weatherPiece1 + "\n" + weatherPiece2 + "\n" +
                "Temperature: " + main.getDouble("temp") + "\n" +
                "Pressure: " + main.getDouble("pressure") + "\n" +
                "Humidity: " + main.getDouble("humidity") + "\n" +
                "Visibility: " + jo.getDouble("visibility") + "\n" +
                "Wind Speed: " + wind.getDouble("speed") + "\n" +
                "Wind degree: " + wind.getDouble("deg") + "\n";
        return weather;
    }
}

