package com.example.milkmantra.customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.milkmantra.R;

import java.util.ArrayList;

public class home_customer extends AppCompatActivity {
    ArrayList<Provider_Selection> provider_selections=new ArrayList<>();
 RecyclerView recyclerView;
 ImageView profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_customer);

       /* recyclerView=findViewById(R.id.recyycleViewOfHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Provider_Selection model=new Provider_Selection("Dhaval Varia",2.5,0,0,0,2.5,0);

        provider_selections.add(model);
        Provider_Selection_Adapter provider_selection_adapter=new Provider_Selection_Adapter(this,provider_selections);
        recyclerView.setAdapter(provider_selection_adapter);*/

        profile=findViewById(R.id.Profile);

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



    }
}