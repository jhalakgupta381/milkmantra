package com.example.milkmantra.customer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.milkmantra.Adapter.Customer_Notification_Adapter;
import com.example.milkmantra.R;

import java.util.ArrayList;

public class customer_notification extends AppCompatActivity {
     ArrayList<String> message=new ArrayList<>();
     RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_notification);

        recyclerView=findViewById(R.id.notificationRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        message.add("Today Mayank Bhai is Not avilable");
        message.add("Today Nayan Bhai increase milk 2liter");
        message.add("Today Kiran bahi not available");

        Customer_Notification_Adapter customer_notification_adapter=new Customer_Notification_Adapter(this,message);
        recyclerView.setAdapter(customer_notification_adapter);


    }
}