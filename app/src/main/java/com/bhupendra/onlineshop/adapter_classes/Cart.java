package com.bhupendra.onlineshop.adapter_classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhupendra.onlineshop.R;
import com.bhupendra.onlineshop.modal_classes.ProductModal;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Cart extends RecyclerView.Adapter<Cart.MyViewHolder>{

    Context context;
    List<ProductModal> productModals;

    public Cart(Context context, List<ProductModal> productModals) {
        this.context = context;
        this.productModals = productModals;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_cart,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //// getting data according to position
        final ProductModal productModal = productModals.get(position);

        holder.txt_item_product_name.setText(productModal.getName());
        holder.txt_item_product_price.setText(productModal.getPrice());

        // get Product Image
        Picasso.get()
                .load(productModal.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .resize(220, 220)
                .centerCrop()
                .into(holder.item_product_image);
    }

    @Override
    public int getItemCount() {
        return productModals.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_item_product_name,txt_item_product_price;
        ImageView item_product_image;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt_item_product_name = itemView.findViewById(R.id.productName);
            txt_item_product_price = itemView.findViewById(R.id.productPrice);
        }
    }
}