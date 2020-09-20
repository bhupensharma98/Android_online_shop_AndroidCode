package com.bhupendra.onlineshop.adapter_classes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhupendra.onlineshop.R;
import com.bhupendra.onlineshop.activity_classes.ProductDetailActivity;
import com.bhupendra.onlineshop.modal_classes.ProductModal;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Product extends RecyclerView.Adapter<Product.MyViewHolder>{

    Context context;
    List<ProductModal> productModals;

    public Product(Context context, List<ProductModal> productModals) {
        this.context = context;
        this.productModals = productModals;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //// getting data according to position
        final ProductModal productModal = productModals.get(position);

        holder.txt_product_name.setText(productModal.getName());
        holder.txt_product_price.setText("Rs. " + productModal.getPrice() + " /-");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDetailActivity.productID = productModal.get_id();
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra("_name",productModal.getName());
                intent.putExtra("_desc",productModal.getDescription());
                intent.putExtra("_price",productModal.getPrice());
                intent.putExtra("_img", productModal.getImage());
                context.startActivity(intent);
            }
        });



        // get Product Image
        Picasso.get()
                .load(productModal.getImage())
                .placeholder(R.drawable.loading)
                .resize(220, 220)
                .centerCrop()
                .into(holder.img_photo);
    }

    @Override
    public int getItemCount() {
        return productModals.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_product_name,txt_product_price;
        ImageView img_photo;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt_product_name = itemView.findViewById(R.id.txtProductName);
            txt_product_price = itemView.findViewById(R.id.txtPrice);
            img_photo = itemView.findViewById(R.id.imgProduct);
        }
    }
}