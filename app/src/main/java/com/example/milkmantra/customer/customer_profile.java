package com.example.milkmantra.customer;

import static android.provider.SyncStateContract.Helpers.update;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.milkmantra.MainActivity;
import com.example.milkmantra.R;

public class customer_profile extends AppCompatActivity {
    Button logout;
    ImageView edit_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);


        logout=findViewById(R.id.Logout);
        edit_profile=findViewById(R.id.Edit_profile);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
            private void logout() {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_profile();
            }

            private void edit_profile() {
                Intent intent=new Intent(getApplicationContext(),customer_edit_profile.class);
                startActivity(intent);
            }
        });




    }
}