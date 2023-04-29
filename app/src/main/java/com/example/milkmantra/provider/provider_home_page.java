package com.example.milkmantra.provider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.milkmantra.R;

import java.util.ArrayList;

public class provider_home_page extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<provider_home> customer_list=new ArrayList<>();

    provider_home pr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_home_page);

        recyclerView=findViewById(R.id.provider_customer_number);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         customer_list.add(new provider_home(2,"Manav vyash"));
        customer_list.add(new provider_home(3,"Utsav Donda"));
        customer_list.add(new provider_home(4,"jatin vyash"));
        customer_list.add(new provider_home(5,"Umang vyash"));
        customer_list.add(new provider_home(6,"Nayan vyash"));
        customer_list.add(new provider_home(7,"Darshil Kanzariya"));
        customer_list.add(new provider_home(8,"Himanshu Kanzariya"));

          customer_Adapter customer_adapter=new customer_Adapter(this,customer_list);
          recyclerView.setAdapter(customer_adapter);

    }
}