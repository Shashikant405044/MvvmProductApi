package com.example.mvvmapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmapp.R;
import com.example.mvvmapp.databinding.ProductItemBinding;
import com.example.mvvmapp.model.ProductsResponse;
import com.example.mvvmapp.view.ProductDetailsActivity;

import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    Context context;
    List<ProductsResponse> productsResponses;

    public ProductAdapter(Context context, List<ProductsResponse> productsResponses) {
        this.context = context;
        this.productsResponses = productsResponses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        ProductItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.product_item, parent, false);
        return  new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ProductsResponse productsResponse = productsResponses.get(position);
        holder.binding.setProductsIds(productsResponses.get(position));


        holder.binding.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("image",productsResponse.getImage());
                intent.putExtra("description",productsResponse.getDescription());
                intent.putExtra("price",productsResponse.getPrice());
                intent.putExtra("title",productsResponse.getTitle());
                intent.putExtra("category",productsResponse.getCategory());
                intent.putExtra("rateing_rate",productsResponse.getRating().getRate());
                intent.putExtra("rateing_count",productsResponse.getRating().getCount());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productsResponses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ProductItemBinding binding;

        public MyViewHolder(ProductItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
