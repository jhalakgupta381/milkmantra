package com.example.milkmantra.customer;

import static android.widget.Toast.LENGTH_LONG;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.milkmantra.Adapter.Provider_Selection_Adapter;
import com.example.milkmantra.R;

import java.util.ArrayList;

import com.example.milkmantra.model.Customer_Add_Provider_model;

public class home_customer extends AppCompatActivity {
    ArrayList<Customer_Add_Provider_model> provider_selections=new ArrayList<Customer_Add_Provider_model>();
     RecyclerView recyclerView;
    Provider_Selection_Adapter provider_selection_adapter;
 ImageView profile;
 Toolbar toolbar;
 SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_customer);

        toolbar=findViewById(R.id.HomeToolbar);
        setSupportActionBar(toolbar);

        if(getApplicationContext()!=null){
            getSupportActionBar().setTitle("Home");
        }


        // here handle the search

        searchView=findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                fileList(s);

                return false;
            }
        });


        // it for customer
   

        profile=findViewById(R.id.Profile);
        recyclerView=findViewById(R.id.recyycleViewOfHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Customer_Add_Provider_model customer_add_provider_mode=new Customer_Add_Provider_model("Mayank","2","3","2","0","0","0","false");
        provider_selections.add(customer_add_provider_mode);
        provider_selections.add(new Customer_Add_Provider_model("Darshil","2","3","5","0","0","0","false"));
        provider_selections.add(new Customer_Add_Provider_model("Umang","2","3","5","0","0","0","false"));
        provider_selections.add(new Customer_Add_Provider_model("Nikhil","2","3","5","0","0","0","false"));
        provider_selections.add(new Customer_Add_Provider_model("Jayesh","2","3","5","0","0","0","false"));
        provider_selections.add(new Customer_Add_Provider_model("Manoj","2","3","5","0","0","0","false"));
        provider_selection_adapter=new Provider_Selection_Adapter(this,provider_selections);
        recyclerView.setAdapter(provider_selection_adapter);


        /*notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_Notification();
            }

            private void open_Notification() {
                Intent intent=new Intent(getApplicationContext(),customer_notification.class);
                startActivity(intent);
            }
        });*/


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile();
            }

            private void profile() {
                Intent intent=new Intent(getApplicationContext(),customer_profile.class);
                startActivity(intent);
            }
        });



        // It is for notification



    }

    private void fileList(String s) {
        ArrayList<Customer_Add_Provider_model> filterList=new ArrayList<>();
        for(Customer_Add_Provider_model item:provider_selections){
            if(item.getName().contains(s)){
                filterList.add(item);
            }
        }
        if(filterList.isEmpty()){
            Toast.makeText(this,"No Data found",Toast.LENGTH_LONG).show();
        }
        else {
            provider_selection_adapter.setFilteredList(filterList);
            recyclerView.scrollToPosition(0);

        }

    }
}