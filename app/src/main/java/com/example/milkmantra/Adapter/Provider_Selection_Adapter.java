package com.example.milkmantra.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.milkmantra.R;

import java.util.ArrayList;

import com.example.milkmantra.model.Customer_Add_Provider_model;

public class Provider_Selection_Adapter  extends RecyclerView.Adapter<Provider_Selection_Adapter.ViewHolder> {

    Context context;
    ArrayList<Customer_Add_Provider_model> provider_selections;


     public  void  setFilteredList(ArrayList<Customer_Add_Provider_model> list){
         provider_selections=list;
         notifyDataSetChanged();
     }
    public Provider_Selection_Adapter(Context context, ArrayList<Customer_Add_Provider_model> provider_selections) {
        this.context = context;
        this.provider_selections = provider_selections;
    }

    //here we have create whole layout into view
    @NonNull
    @Override
    public Provider_Selection_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.custom_add_provider,viewGroup,false);
       ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Provider_Selection_Adapter.ViewHolder viewHolder, int i) {


        viewHolder.name.setText(provider_selections.get(i).getName());
        viewHolder.ed1.setText(provider_selections.get(i).getCow_Morning());
        viewHolder.ed2.setText(provider_selections.get(i).getBuffelow_Morning());
        viewHolder.ed3.setText(provider_selections.get(i).getOther_Morning());
        viewHolder.ed4.setText(provider_selections.get(i).getCow_Evening());
        viewHolder.ed5.setText(provider_selections.get(i).getBuffelow_Evening());
        viewHolder.ed6.setText(provider_selections.get(i).getOther_Evening());






    }

    // here we have specifing the size of list
    @Override
    public int getItemCount() {
        return provider_selections.size();
    }

    // all the operation perform here
    public class ViewHolder extends RecyclerView.ViewHolder {
        EditText ed1,ed2,ed3,ed4,ed5,ed6;
        int m,e;
        TextView name;
        Switch sw;
        RadioButton rb1,rb2;

        // here we have find id and after the set data into onBindingViewHolder
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.Name);

        ed1=itemView.findViewById(R.id.moring_cow);
        ed2=itemView.findViewById(R.id.mornig_buffelow);
        ed3=itemView.findViewById(R.id.mornig_other);
        ed4=itemView.findViewById(R.id.evening_cow);
        ed5=itemView.findViewById(R.id.evenig_buffelow);
        ed6=itemView.findViewById(R.id.eveninig_other);


        }
    }
}
