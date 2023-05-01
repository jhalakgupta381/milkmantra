package com.example.milkmantra.provider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.milkmantra.Adapter.Provider_Customer_Adapter;
import com.example.milkmantra.R;
import com.example.milkmantra.model.Custom_Provider_Home;

import java.util.ArrayList;

public class provider_home extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Custom_Provider_Home> customer_list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_home);
        recyclerView=findViewById(R.id.ProviderHomeRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Custom_Provider_Home custom_provider_home=new Custom_Provider_Home("1","Darshil Kanzariya");
        customer_list.add(custom_provider_home);
        customer_list.add(new Custom_Provider_Home("2","Mayank Patel"));
        customer_list.add(new Custom_Provider_Home("3","Sumit Dabhi"));
        customer_list.add(new Custom_Provider_Home("4","Anil Suthariya"));
        Provider_Customer_Adapter provider_customer_adapter=new Provider_Customer_Adapter(this,customer_list);
        recyclerView.setAdapter(provider_customer_adapter);

    }
}