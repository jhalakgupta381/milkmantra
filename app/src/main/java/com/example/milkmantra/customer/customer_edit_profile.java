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

public class customer_edit_profile extends AppCompatActivity {

    Button btn;
    Toolbar toolbar;
    EditText name,pincode,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_edit_profile);

        name=findViewById(R.id.Name);
        pincode=findViewById(R.id.Pincode);
        address=findViewById(R.id.Address);


        toolbar=findViewById(R.id.EditProfileToolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Edit Profile");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btn=findViewById(R.id.Update);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Update();
            }

            private void Update() {
                Intent intent=new Intent(getApplicationContext(),customer_profile.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Fetching the stored data from the SharedPreference
        SharedPreferences sh1 = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s2;
        s2 = sh1.getString("name","No name defined");
        int b = sh1.getInt("pincode",0);
        String s1;
        s1 = sh1.getString("address","");




        // Setting the fetched data in the EditTexts
        name.setText(s2);
        pincode.setText(String.valueOf(b));
        address.setText(s1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Creating a shared pref object with a file name "MySharedPref" in private mode
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref1", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("name", name.getText().toString());
        myEdit.putInt("pincode", Integer.parseInt(pincode.getText().toString()));
        myEdit.putString("address",address.getText().toString());
        myEdit.apply();
    }
}