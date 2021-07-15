package com.example.assignment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Secondactivity extends AppCompatActivity {
    int totalprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        String value = getIntent().getStringExtra("value");
        String pricevalue = getIntent().getStringExtra("pricevalue");
        int priceorigionalvalue =  Integer.parseInt(pricevalue.toString());

        TextView Description = (TextView) findViewById(R.id.product_description);
        Button Add = (Button)findViewById(R.id.Add_to_Cart);

        setTitle(value);


        TextView quant = (TextView) findViewById(R.id.Quantity);
        quant.setText("1");


        ImageView backImage = (ImageView)findViewById(R.id.back);
        backImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(Secondactivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        if(value.equals("iphone")){
            Description.setText("12 MP, f/1.6, 26mm (wide), 1.7µm, dual pixel PDAF, sensor-shift stabilization (IBIS)\n" +
                    "12 MP, f/2.2, 65mm (telephoto), 1/3.4\", 1.0µm, PDAF, OIS, 2.5x optical zoom\n" );
        }else if(value.equals("Clothes")){
            Description.setText("NILOFER SHAHID | CELEBRITY STYLE FILE - LUXURY PRET - CLEOPATRA’S VISION.");

        }else if(value.equals("Laptop")){
            Description.setText("20g Running Memory Fingerprint Unlocking 15.6-Inch I7 Laptop Customized Ultra Thin Game Laptop/Notebook Computer");

        }else{
            Description.setText("");
        }

        Add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){



                int number = Integer.parseInt(quant.getText().toString());

                int c = dataFile.calculatePrice(number,priceorigionalvalue);
                String toStringdata = Integer.toString(c);

                Toast.makeText(Secondactivity.this,    " Added Successfully" , Toast.LENGTH_LONG).show();


                Bundle bundle = new Bundle();
                bundle.putString("totalprice", toStringdata);
                Intent intent = new Intent(Secondactivity.this, PlaceOrder.class);

                intent.putExtras(bundle);

                startActivity(intent);



            }
        });

        Button quantityadd = (Button)findViewById(R.id.AddQuantity);


        quantityadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view) {


                int number = Integer.parseInt(quant.getText().toString());
                number = number + 1;
                String newvalue = Integer.toString(number);
                quant.setText(newvalue);

            }
        });

        Button quantitysubtract = (Button)findViewById(R.id.subtractquantity);
        quantitysubtract.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view) {


                int number = Integer.parseInt(quant.getText().toString());
                if(number >1){
                    number = number - 1;
                    String newvalue = Integer.toString(number);
                    quant.setText(newvalue);
                }

            }
        });



    }

}
