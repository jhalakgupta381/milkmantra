package com.example.milkmantra.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.milkmantra.R;

import java.util.ArrayList;

public class customer_Adapter  extends RecyclerView.Adapter<customer_Adapter.ViewHolder> {
    Context context;
    ArrayList<provider_home> customer_list;

    public customer_Adapter(Context context, ArrayList<provider_home> customer_list) {
        this.context = context;
        this.customer_list = customer_list;
    }

    @NonNull
    @Override
    public customer_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_provider_home,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull customer_Adapter.ViewHolder viewHolder, int i) {
        viewHolder.txtview1.setText(customer_list.get(i).number);
        viewHolder.txtview2.setText(customer_list.get(i).name);

    }

    @Override
    public int getItemCount() {
        return customer_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtview1,txtview2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtview1=itemView.findViewById(R.id.Number);
            txtview2=itemView.findViewById(R.id.Name);
        }
    }
}
