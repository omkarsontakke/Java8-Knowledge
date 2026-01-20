package org.JavaEight.JavaExamples;

public class EmpCities {
    String cityName;
    int cityPopulation;

    public EmpCities(int cityPopulation, String cityName) {
        this.cityPopulation = cityPopulation;
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(int cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    @Override
    public String toString() {
        return "EmpCities{" +
                "cityName='" + cityName + '\'' +
                ", cityPopulation='" + cityPopulation + '\'' +
                '}';
    }
}
