package com.example.milkmantra.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.milkmantra.R;

public class customer_edit_profile extends AppCompatActivity {
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_edit_profile);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
            }

            private void update() {
                Intent intent=new Intent(getApplicationContext(),customer_profile.class);
                startActivity(intent);
            }
        });
    }
}