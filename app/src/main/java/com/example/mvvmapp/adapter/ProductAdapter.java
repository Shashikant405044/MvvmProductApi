package com.example.mvvmapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmapp.R;
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

     View view = LayoutInflater.from(context).inflate(R.layout.product_item,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ProductsResponse productsResponse = productsResponses.get(position);

         String imageUrl =  productsResponse.getImage();
         Glide.with(context).load(imageUrl).into(holder.imageView);
         holder.title.setText(productsResponse.getTitle());
         holder.category.setText(productsResponse.getCategory());
      //  holder.description.setText(productsResponse.getRating().getRate());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
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

        TextView title, category, description;
        ImageView imageView;
    CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            category = itemView.findViewById(R.id.category);
            description = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.image_view);
            cardView = itemView.findViewById(R.id.card_view);



        }
    }
}
