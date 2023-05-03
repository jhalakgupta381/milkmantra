package com.example.milkmantra.provider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.milkmantra.Adapter.Provider_Customer_Adapter;
import com.example.milkmantra.R;
import com.example.milkmantra.model.Custom_Provider_Home;

import java.util.ArrayList;

public class provider_home extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    ArrayList<Custom_Provider_Home> customer_list=new ArrayList<>();
    ImageView more;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_home);

        toolbar=findViewById(R.id.ProviderHomeToolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Home");
        }

        // it for customer
        recyclerView=findViewById(R.id.ProviderHomeRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Custom_Provider_Home custom_provider_home=new Custom_Provider_Home("1","Darshil Kanzariya");
        customer_list.add(custom_provider_home);
        customer_list.add(new Custom_Provider_Home("2","Mayank Patel"));
        customer_list.add(new Custom_Provider_Home("3","Sumit Dabhi"));
        customer_list.add(new Custom_Provider_Home("4","Anil Suthariya"));
        Provider_Customer_Adapter provider_customer_adapter=new Provider_Customer_Adapter(this,customer_list);
        recyclerView.setAdapter(provider_customer_adapter);







        // it for more

        more=findViewById(R.id.More);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),provider_more.class);
                startActivity(intent);
            }
        });

    }
}