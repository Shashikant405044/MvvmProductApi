package com.example.mvvmapp.model;

import com.google.gson.annotations.SerializedName;

public class ProductsResponse {


    @SerializedName("title")
    String title;


    @SerializedName("description")
    String description;

    @SerializedName("category")
    String category;

    @SerializedName("image")
    String image;

    @SerializedName("price")
    String price;


    @SerializedName("rating")
      RatingPojo rating;

    public RatingPojo getRating() {

        return rating;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }
}
