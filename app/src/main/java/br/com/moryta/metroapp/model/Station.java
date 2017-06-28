package br.com.moryta.metroapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by moryta on 26/06/2017.
 */

public class Station {
    @SerializedName("nome")
    private String name;

    @SerializedName("endereco")
    private String address;

    private String latitude;

    private String longitude;

    @SerializedName("capacidade_passageiro_hora_pico")
    private String capacity;

    @SerializedName("area_construida_m_2")
    private Long area;

    @SerializedName("inauguracao")
    private String inaugurationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public String getInaugurationDate() {
        return inaugurationDate;
    }

    public void setInaugurationDate(String inaugurationDate) {
        this.inaugurationDate = inaugurationDate;
    }
}
