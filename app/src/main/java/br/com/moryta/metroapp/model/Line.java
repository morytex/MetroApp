package br.com.moryta.metroapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by moryta on 26/06/2017.
 */

public class Line {
    @SerializedName("cor")
    private String color;

    @SerializedName("numero")
    private int number;

    @SerializedName("urlImagem")
    private String imageUrl;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
