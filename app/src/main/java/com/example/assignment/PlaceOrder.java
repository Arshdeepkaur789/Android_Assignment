package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment.R;

public class PlaceOrder extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.placeorderactivity);
        String value = getIntent().getStringExtra("totalprice");
        TextView placeorderView = (TextView)findViewById(R.id.placeorder_txtView);

        Button PlaceOrder_Button =(Button)findViewById(R.id.PlaceOrder_btn);
        PlaceOrder_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                placeorderView.setText(value);

            }
        });


    }
}
