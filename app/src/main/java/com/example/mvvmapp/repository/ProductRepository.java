package com.example.mvvmapp.repository;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmapp.ProductApiEndPoint;
import com.example.mvvmapp.RetrofitApi;
import com.example.mvvmapp.model.ProductsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {

    private Application application;

    MutableLiveData<List<ProductsResponse>> mutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();


    public ProductRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<ProductsResponse>> getPostDataRepo() {
       isLoading.postValue(true);

       ProductApiEndPoint endPoint = RetrofitApi.getInstance(ProductApiEndPoint.class);

         Call<List<ProductsResponse>> call = endPoint.getAllProduct();

         call.enqueue(new Callback<List<ProductsResponse>>() {
             @Override
             public void onResponse(Call<List<ProductsResponse>> call, Response<List<ProductsResponse>> response) {
                 isLoading.postValue(false);

                mutableLiveData.postValue(response.body());

             }

             @Override
             public void onFailure(Call<List<ProductsResponse>> call, Throwable t) {
                 isLoading.postValue(false);

                 //        Toast.makeText(application, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
             }
         });

        return mutableLiveData;
    }
    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }
}
