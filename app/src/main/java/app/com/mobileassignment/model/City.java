package app.com.mobileassignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City implements Comparable<City>{

    private String country;
    private String name;
    private int id;
    private Coordinates coordinates;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(int id) {
        this.id = id;
    }

    public Coordinates getCoord() {
        return coordinates;
    }

    @JsonProperty("coord")
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    @Override
    public int compareTo(City city) {
        return this.getName().compareTo(city.getName());
    }
}
