package com.example.mvvmapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmapp.model.ProductsResponse;
import com.example.mvvmapp.repository.ProductRepository;

import java.util.List;

public class ProductVieModel extends AndroidViewModel {

    private ProductRepository productRepository;

    public ProductVieModel(@NonNull Application application) {
        super(application);

        productRepository = new ProductRepository(application);

    }

    public MutableLiveData<List<ProductsResponse>> getPostData(){

        return productRepository.getPostDataRepo();

    }

    public MutableLiveData<Boolean> isLoading(){
        return productRepository.getIsLoading();
    }

}
