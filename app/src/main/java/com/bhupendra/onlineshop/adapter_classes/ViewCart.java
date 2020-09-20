package com.bhupendra.onlineshop.adapter_classes;

//public class ViewCartAdapter {
//}

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhupendra.onlineshop.R;
import com.bhupendra.onlineshop.modal_classes.GetCartModal;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewCart extends RecyclerView.Adapter<ViewCart.MyViewHolder>{

    Context context;
    List<GetCartModal> productModals;

    public ViewCart(Context context, List<GetCartModal> productModals) {
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        //// getting data according to position
        final GetCartModal GetCartModal = productModals.get(position);
        holder.txt_item_product_name.setText(GetCartModal.getProductName());
        holder.txt_item_product_price.setText(GetCartModal.getLocation());

        // get Product Image
        Picasso.get()
                .load(GetCartModal.getImage())
                .placeholder(R.drawable.loading)
                .resize(220, 220)
                .centerCrop()
                .into(holder.pro_image);

        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the clicked item label
                String itemLabel = String.valueOf(productModals.get(position));
                productModals.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,productModals.size());
                Toast.makeText(context,"Removed product from your cart!!",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productModals.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_item_product_name,txt_item_product_price;
        ImageView pro_image, img_delete;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt_item_product_name = itemView.findViewById(R.id.productName);
            txt_item_product_price = itemView.findViewById(R.id.productPrice);
            pro_image = itemView.findViewById(R.id.productImage);
            img_delete = itemView.findViewById(R.id.delete);
        }
    }
}