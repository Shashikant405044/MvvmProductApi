package com.example.mvvmapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.mvvmapp.R;
import com.example.mvvmapp.databinding.ActivityProductDetailsBinding;

public class ProductDetailsActivity extends AppCompatActivity {

    ActivityProductDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this,R.layout.activity_product_details);

       ProductDetailsActivity.this.setTitle("Item Details");
       Intent intent = getIntent();
        String tile  =  intent.getStringExtra("title");
        String category  =  intent.getStringExtra("category");
        String description  =  intent.getStringExtra("description");
        String image = intent.getStringExtra("image");
        String price = intent.getStringExtra("price");
        String rate = intent.getStringExtra("rateing_rate");
        String count = intent.getStringExtra("rateing_count");

      binding.title.setText(tile);
      binding.category.setText(category);
      binding.description.setText(description);
      binding.price.setText("₹:  "+price);
      binding.rate.setText("Rate:  "+rate);




        String imageUrl = image;
        Glide.with(ProductDetailsActivity.this).load(imageUrl).into(binding.imageView);



    }
}