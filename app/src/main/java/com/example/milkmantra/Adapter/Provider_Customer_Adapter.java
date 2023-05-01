package com.example.milkmantra.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.milkmantra.R;
import com.example.milkmantra.model.Custom_Provider_Home;

import java.util.ArrayList;

public class Provider_Customer_Adapter extends   RecyclerView.Adapter<Provider_Customer_Adapter.ViewHolder>{

    Context context;
    ArrayList<Custom_Provider_Home>  customer_list;

    public Provider_Customer_Adapter(Context context, ArrayList<Custom_Provider_Home> customer_list) {
        this.context = context;
        this.customer_list = customer_list;
    }

    @NonNull
    @Override

    public Provider_Customer_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_provider_home,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Provider_Customer_Adapter.ViewHolder viewHolder, int i) {
        ViewHolder.number.setText(customer_list.get(i).getNo());
        viewHolder.name.setText(customer_list.get(i).getName());

    }

    @Override
    public int getItemCount() {
        return customer_list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        static TextView number;
          public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.Name);
            number=itemView.findViewById(R.id.Number);
        }
    }
}
