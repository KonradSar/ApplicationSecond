package com.example.konrad.applicationsecond;

/**
 * Created by Konrad on 30.06.2017.
 */

public class WeatherResults {
    public String temperature;
    public String windSpeed;
    public String pressure;

    public WeatherResults(String temperature, String windSpeed, String pressure) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }
}
