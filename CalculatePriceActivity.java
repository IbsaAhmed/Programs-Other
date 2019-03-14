package com.example.wtstudentsia895881.calculateprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CalculatePriceActivity extends AppCompatActivity {

    EditText inPrice, inDiscount, outPrice;
    Button findPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_price);
        inPrice = findViewById(R.id.price);
        inDiscount = findViewById(R.id.discount);
        outPrice = findViewById(R.id.discount_price);
        findPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = Double.parseDouble(inPrice.getText().toString());
                double rebate = Double.parseDouble(inDiscount.getText().toString());
                double priceNew = amount - amount*rebate/100;
                String priceNewString = String.format("%,.2f",priceNew);
                priceNewString = "$" + priceNewString;
                inPrice.setText("$"+(String.format("%,.2f",amount)));
                inDiscount.setText(String.format("%,.2f",rebate)+ "%" );
                outPrice.setText(priceNewString );

            }
        });

    }
}

