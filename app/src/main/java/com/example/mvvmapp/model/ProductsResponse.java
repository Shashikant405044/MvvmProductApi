package com.example.mvvmapp.model;
import android.widget.ImageView;

import androidx.annotation.IdRes;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;

public class ProductsResponse extends BaseObservable {


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
  @Bindable
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

    public String getPrice() {
        return price;
    }

    public RatingPojo getRating() {
        return rating;
    }


    @Bindable
    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }
    @Bindable
    public void setDescription(String description) {
        this.description = description;
    }

    @Bindable
    public void setCategory(String category) {
        this.category = category;
    }
    @Bindable
    public void setImage(String image) {
        this.image = image;
     notifyPropertyChanged(BR.productsIds);
  }
    @Bindable
    public void setPrice(String price) {
        this.price = price;
    }



    @BindingAdapter("android:src")
    public static void loadImage(ImageView view, String imageUrl) {
//        Glide.with(view.getContext())
//                .load(imageUrl).apply(new RequestOptions().circleCrop())
//                .into(view);

       Glide.with(view.getContext()).load(imageUrl).apply(new RequestOptions()).into(view);
    }
}