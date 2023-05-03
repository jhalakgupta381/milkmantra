package com.example.milkmantra.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.milkmantra.R;

public class create_account_customer extends AppCompatActivity {
    Button register;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_customer);


        toolbar=findViewById(R.id.CustomerRegistrationToolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Create New Account");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }



        register=findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),home_customer.class);
                startActivity(intent);
            }
        });



    }
}