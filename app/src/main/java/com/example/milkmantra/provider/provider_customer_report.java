package com.example.milkmantra.provider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.milkmantra.Adapter.Provider_Customer_Report_Adapter;
import com.example.milkmantra.R;
import com.example.milkmantra.model.Provider_Customer_Report;

import java.util.ArrayList;

public class provider_customer_report extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Provider_Customer_Report> reports=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_customer_report);

        // here handle recycleview

        recyclerView=findViewById(R.id.ProviderCustomerReportRecycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Provider_Customer_Report provider_customer_report=new Provider_Customer_Report("1","Darshil Kanzariya");
        reports.add(provider_customer_report);
        reports.add(new Provider_Customer_Report("2","Mayank Patel"));
        reports.add(new Provider_Customer_Report("3","OM Mehta"));
        reports.add(new Provider_Customer_Report("4","Amit Bhutt"));

        Provider_Customer_Report_Adapter provider_customer_report_adapter=new Provider_Customer_Report_Adapter(this,reports);
        recyclerView.setAdapter(provider_customer_report_adapter);

    }

}