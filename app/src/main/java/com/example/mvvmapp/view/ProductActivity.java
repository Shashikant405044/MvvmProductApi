package com.example.mvvmapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mvvmapp.R;
import com.example.mvvmapp.adapter.ProductAdapter;
import com.example.mvvmapp.databinding.ActivityProductsResponseBinding;
import com.example.mvvmapp.model.ProductsResponse;
import com.example.mvvmapp.viewmodel.ProductVieModel;

import java.util.List;

public class ProductActivity extends AppCompatActivity {

   private ActivityProductsResponseBinding binding;
    ProductVieModel vieModel;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_products_response);
        vieModel = new ViewModelProvider(this).get(ProductVieModel.class);
        ProductActivity.this.setTitle(" Shashi k Store");

//         if (isOnline()){
//
//             Dialog dialog = new Dialog(ProductActivity.this);
//             dialog.setContentView(R.layout.nointernet);
//             dialog.show();
//
//         }
//         else {
//
//
//
//         }

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading....");
        vieModel.isLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                if (isLoading) progressDialog.show();
                else progressDialog.dismiss();
            }
        });
        vieModel.getPostData().observe(this, new Observer<List<ProductsResponse>>() {
            @Override
            public void onChanged(List<ProductsResponse> productsResponses) {


                //    productsResponses.addAll(productsResponses);

                ProductAdapter productAdapter = new ProductAdapter(ProductActivity.this,productsResponses);
                binding.recyclerViewP.setAdapter(productAdapter);

//                LinearLayoutManager linearLayoutManager =
//                        new LinearLayoutManager(ProductActivity.this,LinearLayoutManager.VERTICAL,false);
//
//                 binding.recyclerViewP.setLayoutManager(linearLayoutManager);


                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager( 2,StaggeredGridLayoutManager.VERTICAL);
                binding.recyclerViewP.setLayoutManager(staggeredGridLayoutManager);

            }
        });
    }


     public  boolean isOnline(){

         ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
         NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
         if (  networkInfo == null || !networkInfo.isAvailable() || !networkInfo.isConnected())
         {
             return false;
         }


        return true;

     }

}