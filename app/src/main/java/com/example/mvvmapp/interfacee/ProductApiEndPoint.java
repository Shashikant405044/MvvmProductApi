package com.example.mvvmapp.interfacee;

import com.example.mvvmapp.model.ProductsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApiEndPoint {

    @GET("/products")
    Call<List<ProductsResponse>> getAllProduct();


}
