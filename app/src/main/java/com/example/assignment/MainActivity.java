package com.example.assignment;;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button button;
    Bundle bundle ,bundle1;
    String value ,pricevalue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn_go_to_another_activity);


        bundle = new Bundle();
        bundle1 = new Bundle();



        Spinner spinner = (Spinner) findViewById(R.id.spinner);


        spinner.setOnItemSelectedListener(this);


        List<String> products = new ArrayList<String>();
        products.add("iphone");
        products.add("Clothes");
        products.add("Laptop");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, products);


        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(dataAdapter);



    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();


        ImageView showimage = (ImageView)findViewById(R.id.categoryImage);
        TextView Price = (TextView)findViewById(R.id.price);

        if(item =="iphone"){

            showimage.setImageResource(R.drawable.iphone12);
            Price.setText("999");
            button.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                    value = "iphone";
                    pricevalue = Price.getText().toString();

                    bundle.putString("value", value);
                    bundle1.putString("pricevalue", pricevalue);

                    Intent intent = new Intent(MainActivity.this,
                            Secondactivity.class);
                    intent.putExtras(bundle);
                    intent.putExtras(bundle1);

                    startActivity(intent);
                }
            });





        }else if(item =="Clothes"){

            showimage.setImageResource(R.drawable.dress);
            Price.setText("325");
            button.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    value = "Clothes";
                    pricevalue = Price.getText().toString();

                    bundle.putString("value", value);
                    bundle1.putString("pricevalue", pricevalue);

                    Intent intent = new Intent(MainActivity.this,
                            Secondactivity.class);

                    intent.putExtras(bundle);
                    intent.putExtras(bundle1);

                    startActivity(intent);
                }
            });
        }else if(item =="Laptop"){

            showimage.setImageResource(R.drawable.laptop);
            Price.setText("490");

            button.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    value = "Laptop";
                    pricevalue = Price.getText().toString();

                    bundle.putString("value", value);
                    bundle1.putString("pricevalue", pricevalue);

                    Intent intent = new Intent(MainActivity.this,
                            Secondactivity.class);
                    intent.putExtras(bundle);
                    intent.putExtras(bundle1);

                    startActivity(intent);
                }
            });
        }
    }




    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


}

