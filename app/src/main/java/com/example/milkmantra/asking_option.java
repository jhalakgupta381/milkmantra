package com.example.milkmantra;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.milkmantra.customer.create_account_customer;

public class asking_option extends AppCompatActivity {

    Button skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asking_option);


        skip=findViewById(R.id.skip);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSkipDialog();
            }
        });


    }
    private void showSkipDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.popup_dialog, null);
        builder.setView(dialogView);

        final AlertDialog dialog = builder.create();

        Button cancelButton = dialogView.findViewById(R.id.cancle);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        Button confirmButton = dialogView.findViewById(R.id.confirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform action for skipping
                dialog.dismiss();
                Intent intent=new Intent(getApplicationContext(), create_account_customer.class);
                startActivity(intent);
            }
        });

        dialog.show();
    }

}