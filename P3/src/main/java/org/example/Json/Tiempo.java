package org.example.Json;

public class Tiempo {

    public double latitude;
    public double longitude;
    public double generationtime_ms;
    public int utc_offset_seconds;
    public String timezone;
    public String timezone_abbreviation;
    public double elevation;
    public CurrentWeather currentWeather;

    static class CurrentWeather{

        public double temperature;
        public double windspeed;

    }
}
