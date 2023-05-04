package com.example.milkmantra.customer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.milkmantra.R;

public class create_account_customer extends AppCompatActivity {
    Button register;
    Toolbar toolbar;
    EditText name,phone_number,pincode,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_customer);
        name=findViewById(R.id.Name);
        phone_number=findViewById(R.id.Phone_Number);
        pincode=findViewById(R.id.Pincode);
        address=findViewById(R.id.Address);


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
    @Override
    protected void onResume() {
        super.onResume();
        // Fetching the stored data from the SharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s2;
        s2 = sh.getString("name","No name defined");
        int a = sh.getInt("phone_number",0);
        int b = sh.getInt("pincode",0);
        String s1;
        s1 = sh.getString("address","");




        // Setting the fetched data in the EditTexts
        name.setText(s2);
        phone_number.setText(String.valueOf(a));
        pincode.setText(String.valueOf(b));
        address.setText(s1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Creating a shared pref object with a file name "MySharedPref" in private mode
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("name", name.getText().toString());
        myEdit.putInt("phone_number", Integer.parseInt(phone_number.getText().toString()));
        myEdit.putInt("pincode", Integer.parseInt(pincode.getText().toString()));
        myEdit.putString("address",address.getText().toString());
        myEdit.apply();
    }
}
